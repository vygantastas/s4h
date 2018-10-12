package lt.bit.s4h.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lt.bit.s4h.entity.Provider;
import lt.bit.s4h.service.ProvService;

@RestController
@RequestMapping("/providers")
public class ProvRestController {

	private String viewType = "free";
	private ProvService service;

	// Autowired
	public ProvRestController(ProvService service) {
//	public void setProvService(ProvService service) {
		this.service = service;
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Provider>> getProductResponseEntity() {
		return ResponseEntity.ok(service
				.findByFreeBeforeOrderByFree(LocalDate.now())); //findByFreeOrderByFree()); 
//				.getProviders(viewType));
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Provider> getProviderById(@PathVariable Integer id) {
		return ResponseEntity.ok(service.getProviderById(id));
	}

//	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseStatus(value = HttpStatus.CREATED)
//	public UUID addProductToMap(@RequestBody Product product) {
//		return service.saveProduct(product);
//	}
//
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteProvider(@PathVariable Integer id) {
		service.deleteProvider(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK, reason = "Updated")
	public void updateProvider(@PathVariable Integer id, @RequestBody Provider provider) {
		service.updateProvider(id, provider);
	}

	@ResponseBody
	public HttpStatus sendViaResponseEntity(String isStatus) {
		if (isStatus.equals("Not Found")) {
			System.out.println("ResponseEntity 1");
			return HttpStatus.NOT_FOUND;
		}
		System.out.println("ResponseEntity 2");
		return HttpStatus.OK;
	}

}
