package lt.bit.s4h.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.bit.s4h.entity.Provider;

@Repository
public interface AuthRepository extends JpaRepository<Provider, Integer> {

	Optional<Provider> findByNameAndPassw(String name, String passw);
	Optional<Provider> findByName(String username);
}
