package lt.bit.s4h.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.bit.s4h.entity.Language;

//@Repository
public interface LangRepository extends JpaRepository<Language, Integer> {

	List<Language> findAll(); // WhereFreeIsNotNull(); //Free();

	List<Language> findByFirst(String name);
	
	List<Language> findByProvId(Integer id);

//	List<Language> findLanguagesByFirst();

}
