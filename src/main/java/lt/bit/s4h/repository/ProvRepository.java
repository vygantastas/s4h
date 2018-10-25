package lt.bit.s4h.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.bit.s4h.entity.Provider;

//@Repository
public interface ProvRepository extends JpaRepository<Provider, Integer> {

	List<Provider> findAll(); //WhereFreeIsNotNull(); //Free();
	List<Provider> findByName(String name); 
	Provider findByUsername(String username);
//	List<Provider> findByFreeBeforeNowOrderByFree(LocalDate now); 
//	List<Provider> findByFreeOrderByFree();

//	List<Provider> findByFreeBeforeOrderByFree(LocalDate today); 
//	List<Provider> findByFreeBeforeOrderByFree(LocalDate today); 
	
	
}
