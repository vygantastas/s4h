package lt.bit.s4h.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import lt.bit.s4h.entity.Provider;
import lt.bit.s4h.repository.ProvRepository;

@Service
@Validated
@Transactional
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

//	@Override
//	public List<Provider> findAllFreeProviders() {
//		return repository.findByFreeBeforeOrderByFree(LocalDate.now()); //findAll();// findAllFree();
//	}

	@Override
	public List<Provider> findAllProviders() {
		return repository.findAll();
	}

	@Override
	public List<Provider> getProviders(String viewType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Provider> findAllFreeProviders() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public List<Provider> getProviders(String viewType) {
//		
//		System.out.println(viewType + "-------------" + viewType);
//		if (viewType.equals("free")) {
//			return repository.findByFreeBeforeOrderByFree(LocalDate.now());
//		} else {
//			return repository.findAll();
			
		
//				repository.findAll().stream().collect(Collectors.toList());
//		List<Provider> prov = 			
		//return repository.findAll().stream()
//				.forEach(pr -> System.out.println(pr.getName()));	
		//		.filter(pr -> pr.getFree().isBefore(LocalDate.now())).collect(Collectors.toList());
//		Collections.sort(prov, );
//		System.out.println("---------------" + prov);
		// return new ArrayList<Provider>();


//	public List<Provider> findByFreeBeforeOrderByFree(LocalDate today) {
//		return repository.findByFreeBeforeOrderByFree(today);
//	}

}
