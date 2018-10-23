package lt.bit.s4h.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lt.bit.s4h.entity.Language;
import lt.bit.s4h.entity.Provider;
import lt.bit.s4h.repository.AuthRepository;
import lt.bit.s4h.service.LangServiceImpl;
import lt.bit.s4h.service.ProvServiceImpl;

@Controller
@SessionAttributes("provId")
public class LangThController {
	private Integer provId;
	@Autowired
	private ProvServiceImpl provService;
	@Autowired
	private LangServiceImpl langService;
	@Autowired
	private AuthRepository authService;
	ResourceBundle messages = ResourceBundle.getBundle("LocaleMessages", Locale.getDefault());

	@GetMapping("/languages")
	public String getProducts(Model model) { // , RedirectAttributes attr) {
		System.out.println("@GetMapping(/languages) prId= " + provId);
		List<Language> langs = langService.findAllByProvId(provId);
		System.out.println("Languages === " + langs);
		model.addAttribute("languages", langs);
//		model.addAttribute("lang", lang.get(0));

//		return "index";
		return "operations/langList";
	}

	@GetMapping("/login")
	public String loginTransl() {
		System.out.println("login...");
		return "operations/login";
	}

	@PostMapping("/login")
	public String registerUser(HttpServletRequest request, Model model) {
		String user = request.getParameter("username");
		String passw = request.getParameter("password");
		System.out.println(user + " " + passw);
		Optional<Provider> prov = authService.findByUsernameAndPassword(user, passw);
		System.out.println("provvvvv -------" + prov);
		if (!prov.isPresent()) {
			String errorMsg = messages.getString("errorBadUser");
			System.out.println("errorMsg ---" + errorMsg);
			model.addAttribute("error", errorMsg); //"Bad user");
			System.out.println("Bad username or password");
//			return "redirect:/login";
			return "operations/login";
		}
		provId = prov.orElseThrow().getId();
		String role = prov.get().getSort();
		System.out.println("provId === " + provId + " is " + role);
		List<Language> langs;
		switch (role) {
		case "T":
			System.out.println("T");
			langs = langService.findAllByProvId(provId);
			model.addAttribute("languages", langs);
			return "/operations/langList";
//			break;
		case "U":
			System.out.println("U");
			langs = langService.findAllLanguages();
			model.addAttribute("languages", langs);
			return "/operations/langSelect";
//			break;
		default:
			System.out.println("BAD");

		}

//		RedirectAttributes attr,
//		attr.addFlashAttribute("providerId", 1); // provId);
		// attr.addAttribute("provId", provId);
//		langService.registerUser(user, pass);
		// return "indexList";
		return "redirect:/languages";
//		return "operations/languageList";
	}

	@GetMapping("/edit/{id}")
	public String editLang(@PathVariable Integer id, Model model) {

		Language editLang = langService.findByLangId(id); // .getProviderById(id);
		System.out.println(editLang.getProvId() + "--- /edit/{id} ---" + editLang.getLangId());
		model.addAttribute("editLang", editLang);
		System.out.println("Edit " + editLang);
//		return "redirect:/languages";
		// return "/operations/langList";

		return "/operations/editLang";
	}

	@GetMapping("/delete/{id}")
	public String deleteLang(@PathVariable Integer id) { // , Model model) {

		langService.deleteLanguage(id);
//		return "/operations/editLang";
		return "redirect:/languages";

//		return "redirect:/"; //operations/langList";

	}

	@GetMapping("/newLang")
	public String newLang(Model model) {
		Language newLang = new Language();
//		langService.saveLanguage(newLang);
		model.addAttribute("editLang", newLang);
		return "/operations/editLang";
//		return "/edit/{" + 1
		// newLang.getLangId()
//				+ "}";
	}

	@GetMapping("/create")
	public String inputNew(Model model) {
		System.out.println("Active provider --- " + provId);
		String username = "";
		String password = "";
		String name = "";
		String mail = "";
		if (provId != null) {
			Provider prov = provService.getProviderById(provId);
			username = prov.getUsername();
			name = prov.getName();
			mail = prov.getMail();
		}
		model.addAttribute("id", provId);
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		model.addAttribute("name", name);
		model.addAttribute("mail", mail);
		return "operations/create";

	}
	
	@PostMapping("/create/{id}")
	public String updateProv(@PathVariable Integer id, @ModelAttribute Provider editProv) {
		Provider startProv = provService.getProviderById(id);
		
		if (id != null) {
			editProv.setSort(startProv.getSort());
			editProv.setUsername(startProv.getUsername());
		}
		System.out.println("/create/id --- " + editProv.getId());
		
		provService.updateProvider(id, editProv);
		return "/operations/login";
	}

	@PostMapping("/create")
	public String createNew(HttpServletRequest request) {
		
		String username = (String) request.getParameter("username");
		if (authService.findByUsername(username).isPresent()) {
			System.out.println("Duplicate username");
			return "operations/login";
		}
		String password = (String) request.getParameter("password");
		String mail = (String) request.getParameter("mail");
		String name = (String) request.getParameter("name");
		String sort = (String) request.getParameter("sort");
		System.out.println(name + " Sort type - " + sort);
		Provider prov = new Provider(username, password, name, mail, sort);
		System.out.println(prov);
		provService.saveProvider(prov);
//		if (sort.equals("T")) {
//		} else {
//		}
		return "/operations/login";
	}

	@GetMapping("/logout")
	public String logoutProv() {
		provId = null;
		return "/operations/login";
	}

//	@PostMapping("/update")
	public String addProduct(HttpServletRequest request) { // , Model model) {
		System.out.println("fiddd = " + request.getParameter("fid"));
		Language edit;
		if (request.getParameter("fid").equals("0")) {
			edit = new Language();
			edit.setProvId(provId);
		} else {
			edit = langService.findByLangId(Integer.valueOf(request.getParameter("fid")));
		}
		edit.setFirst(request.getParameter("ffirst"));
		edit.setSecond(request.getParameter("fsecond"));
		edit.setWork(Byte.valueOf(request.getParameter("fwork")));
		edit.setFree(LocalDate.parse(request.getParameter("ffree")));
		edit.setPrice(Float.valueOf(request.getParameter("fprice")));
		langService.saveLanguage(edit);

		List<Language> lang = langService.findAllByProvId(provId);
		System.out.println("Languages update === " + lang);
//		model.addAttribute("languages", lang);
//		return "operations/langList";
		return "redirect:/languages";

	}

	@PostMapping("/update")
	public String updateLang(@ModelAttribute Language editLang) {
		System.out.println(editLang.getProvId() + "--- /update ---" + editLang.getLangId());
		if (editLang.getLangId() == 0) {
			editLang.setProvId(provId);
		}
		System.out.println(editLang.getProvId() + "--- /update 2 ---" + editLang); // .getLangId());

		langService.saveLanguage(editLang);
		System.out.println(editLang.getProvId() + "--- /update after ---" + +editLang.getLangId());
		return "redirect:/languages";
	}

//		<input type="hidden" name="fid" th:value="${editLang?.langId}" /> <input
//	type="text" name="ffirst" th:value="${editLang?.first}" /> <input
//			type="text" name="fsecond" th:value="${editLang?.second}" /> <input
//			type="text" name="fwork" th:value="${editLang?.work}" /> <input
//			type="text" name="ffree" th:value="${editLang?.free}" /> <input
//			type="text" name="fprice" th:value="${editLang?.price}" /> <input

//	@PostMapping("/login")
//	public String loginTransl(@RequestParam String username) {
//		
//	}
//		service.saveNote(new Note(message));
//		return "redirect:/";
//	}
}
