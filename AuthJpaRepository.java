package lt.bit.s4h.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.bit.s4h.entity.Provider;

@Repository
public interface AuthJpaRepository extends JpaRepository<Provider, Integer> {

	Optional<Provider> findByUsernameAndPassword(String username, String password);
	Optional<Provider> findByUsername(String username);
}
