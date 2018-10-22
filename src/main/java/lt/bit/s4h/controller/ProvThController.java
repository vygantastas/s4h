package lt.bit.s4h.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lt.bit.s4h.entity.Provider;
import lt.bit.s4h.service.AuthServiceImpl;
import lt.bit.s4h.service.ProvService;

//@Controller
public class ProvThController {

	@Autowired
	private ProvService provService;
	@Autowired
	private AuthServiceImpl authService;
	private String sortViewMeth = "free";

	@GetMapping("/providers")
	public String getProducts(Model model) {
		List<Provider> providers = provService.getProviders(sortViewMeth); // getProviders("free");
		model.addAttribute("providers", providers);
		model.addAttribute("view", sortViewMeth);
		return "index";
	}

	@GetMapping("/view/{sortView}")
	public String sortChoose(@PathVariable String sortView) {
		sortViewMeth = sortView;
		System.out.println(sortView);
		return "redirect:/providers";
	}

	@PostMapping("/login}")
	public String login(HttpServletRequest request) {
		String auth = authService.authenticateProvider(request.getParameter("username"),
				request.getParameter("password"));
		switch (auth) {
		case "T":
			System.out.println("T");
			break;
		case "U":
			System.out.println("U");
			break;
		default:
			System.out.println("bad");

		}
		if (auth.equals("T")) {
			System.out.println("login............");
			return "index";
		}
		return "index";

	}

	@PostMapping("/create}")
	public String create(HttpServletRequest request) {
		if (authService.registerUser(request.getParameter("username"), request.getParameter("password"),
				request.getParameter("sort"))) {
			System.out.println("create............");
			return "index";
		}
		return "index";

	}

//	@PostMapping("/products")
//	public String addProduct(HttpServletRequest request) {
//		Provider edit = new Provider(request.getParameter("fname"),
//				Float.parseFloat(request.getParameter("fprice")));
//		String id = request.getParameter("fid");
//		if( !StringUtils.isEmpty(id) ){
//			edit.setId(UUID.fromString(id));
//		}
//		provService.saveProduct(edit);
//		return "redirect:/th/products";
//	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		provService.deleteProvider(id);
		return "redirect:/th/products";
	}

	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable Integer id, Model model) {

		Provider editable = provService.getProviderById(id);
		model.addAttribute("editProduct", editable);

		return "products";
	}

//	@GetMapping("/filter")
//	public String getForm(Model model) {
//		List<Provider> products = provService.getProducts();
//		model.addAttribute("products", products);
//		return "products";
//	}

//	@PostMapping("/filter")
//	public String filterProducts(HttpServletRequest request, Model model) {
//		ProductFilter filter = new ProductFilter();
//		filter.setName(request.getParameter("finame"))
//		.setPriceMax(Float.valueOf(request.getParameter("fipricemax")))
//		.setPriceMin(Float.valueOf(request.getParameter("fipricemin")));
//		List<Provider> filtered = provService.getFilteredProducts(filter);
//		model.addAttribute("products", filtered);
//		return "products";
//	}

}
