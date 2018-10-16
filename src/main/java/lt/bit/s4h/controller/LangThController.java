package lt.bit.s4h.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lt.bit.s4h.entity.Language;
import lt.bit.s4h.entity.Provider;
import lt.bit.s4h.repository.AuthRepository;
import lt.bit.s4h.service.LangServiceImpl;


@Controller
@SessionAttributes("provId")
public class LangThController {
	public Integer provId;
	@Autowired
	private LangServiceImpl langService;
	@Autowired
	private AuthRepository authService;

	@GetMapping("/languages")
	public String getProducts( Model model, RedirectAttributes attr) {
		System.out.println("prId= " + provId);
		List<Language> lang = langService.findAllByProvId(provId);// findByFirst(); // Distinct(); // Providers(sortViewMeth); //
															// getProviders("free");
		System.out.println(lang);
		model.addAttribute("languages", lang);
		return "index";
		//		return "operations/languageList";
	}

	@GetMapping("/login")
	public String loginTransl() {
		System.out.println("login...");
		return "operations/login";
	}
	
	@PostMapping("/login")
	public String registerUser(HttpServletRequest request, RedirectAttributes attr, Model model) {
		String user = request.getParameter("username");
		String passw = request.getParameter("password");
		System.out.println(user + " " + passw);
		Optional<Provider> prov = authService.findByNameAndPassw(user, passw);
		provId = prov.orElseThrow().getId();
		System.out.println("provId ===" + provId);
//		attr.addFlashAttribute("providerId", 1); // provId);
	//	attr.addAttribute("provId", provId);
//		langService.registerUser(user, pass);
		return "languages";
	}

//	@PostMapping("/login")
//	public String loginTransl(@RequestParam String username) {
//		
//	}
//		service.saveNote(new Note(message));
//		return "redirect:/";
//	}
}
