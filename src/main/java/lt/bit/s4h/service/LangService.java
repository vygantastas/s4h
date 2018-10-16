package lt.bit.s4h.service;

import lt.bit.s4h.entity.Language;
import lt.bit.s4h.entity.Provider;

import java.time.LocalDate;
import java.util.List;

public interface LangService {

	List<Language> findAllByProvId(Integer provId);

//	List<Provider> findAllFreeProviders();
	
	
}
