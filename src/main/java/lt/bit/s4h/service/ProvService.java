package lt.bit.s4h.service;

import lt.bit.s4h.entity.Provider;

import java.time.LocalDate;
import java.util.List;

public interface ProvService {
	Provider getProviderById(Integer id);

	void saveProvider(Provider provider);

	void updateProvider(Integer id, Provider provider);

	void deleteProvider(Integer id);

	List<Provider> getProviders(String viewType);

	List<Provider> findAllFree();

	List<Provider> findByFreeBeforeOrderByFree(LocalDate today);
}
