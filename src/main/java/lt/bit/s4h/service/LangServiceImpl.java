package lt.bit.s4h.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import lt.bit.s4h.entity.Language;
import lt.bit.s4h.repository.LangRepository;

@Service
@Validated
@Transactional
public class LangServiceImpl implements LangService {

	private LangRepository repository;

///    @Autowired
//    public void setProductRepository(ProvRepository repository) {
	public LangServiceImpl(LangRepository repository) {
		this.repository = repository;
	}

//	public List<Language> findByFirst() {
//		return repository.findAll(); // findLanguagesByFirst();
//	}

//	@Override
	public List<Language> findDifferenceLanguages() {
		return repository.findDifferenceLanguages();// findByProvId(provId);
	}

	public List<Language> findAllByProvId(Integer provId) {
//			System.out.println("repository.findFirstDistinctAndSecond();");
		return repository.findAllByProvId(provId);
	}

	@Override
	public Language findByLangId(Integer langId) {
		return repository.findByLangId(langId);
	}

	@Override
	public Language jobDone(Language lang) {
		lang.setFree(LocalDate.now());
		return lang;
	}

	@Override
	public void saveLanguage(Language lang) {
		repository.save(lang);

	}

//	public List<Language> findByFirst() {
//		// TODO Auto-generated method stub
//		return repository.findby;
//	}

}
