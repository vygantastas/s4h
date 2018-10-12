package lt.bit.s4h.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import lt.bit.s4h.entity.Provider;
import lt.bit.s4h.repository.ProvRepository;
import lt.bit.s4h.service.ProvService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class ProvServiceImpl implements ProvService {

	private ProvRepository repository;

///    @Autowired
//    public void setProductRepository(ProvRepository repository) {
	public ProvServiceImpl(ProvRepository repository) {
		this.repository = repository;
	}

	@Override
	public Provider getProviderById(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public void saveProvider(Provider provider) {
		repository.save(provider);
	}

	@Override
	public void updateProvider(Integer id, Provider provider) {
//		  Provider updated = repository.getOne(id);
//	        updated.setDone(done);
//	        updated.setMessage(message);
		provider.setId(id);
		repository.save(provider);

	}

	@Override
	public void deleteProvider(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Provider> findAllFree() {
		return repository.findAll();// findAllFree();
	}

	@Override
	public List<Provider> getProviders(String viewType) {
		System.out.println(viewType + "-------------" + viewType);
//				repository.findAll().stream().collect(Collectors.toList());
//		List<Provider> prov = 			
				return repository.findAll().stream()
//				.forEach(pr -> System.out.println(pr.getName()));	
				.filter(pr -> pr.getFree().isBefore(LocalDate.now()))
				.collect(Collectors.toList());
//		Collections.sort(prov, );
//		System.out.println("---------------" + prov);
		//return new ArrayList<Provider>();
	}
	
	public List<Provider> findByFreeBeforeOrderByFree(LocalDate today) {
		return repository.findByFreeBeforeOrderByFree(today);
	}
}
