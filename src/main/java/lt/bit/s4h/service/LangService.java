package lt.bit.s4h.service;

import java.util.List;

import lt.bit.s4h.entity.Language;

public interface LangService {

	List<Language> findAllLanguages();

	List<Language> findAllByProvId(Integer provId);

	Language findByLangId(Integer langId);

	Language jobDone(Language lang);

	void saveLanguage(Language lang);

	void deleteLanguage(Integer langId);

//	List<Provider> findAllFreeProviders();

}
