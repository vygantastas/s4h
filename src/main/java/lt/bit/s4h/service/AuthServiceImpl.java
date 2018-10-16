package lt.bit.s4h.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.bit.s4h.entity.Provider;
import lt.bit.s4h.repository.AuthRepository;

@Service
@Transactional
public class AuthServiceImpl {

	private AuthRepository rep;

//	private PasswordEncoder passwordEncoder;

	public AuthServiceImpl(AuthRepository rep) { // , PasswordEncoder passwordEncoder) {
		this.rep = rep;
//		this.passwordEncoder = passwordEncoder;
	}

//	Optional<Provider> findByUsernameAndPassword(String username, String password) {
//		List<Provider> allProviders = rep.findAll();
//		for (Provider provider : allProviders) {
//			if (provider.getName().equals(username) && provider.getPassw().equals(password)) {
//				return Optional.ofNullable(provider);
//			}
//		}
//		return Optional.empty();
//
//	}

	public boolean authenticateProvider(String username, String password) {
		if (rep.findByNameAndPassw(username, password).isPresent()) {
			return true;
		} 
		return false;
	}

	public boolean registerUser(String username, String password) {
		if (rep.findByName(username).isPresent()) {
			return false;
		} else {
			Provider user = new Provider().setName(username).setPassw(password);
//					.setPassword(passwordEncoder.encode(password))
//					.setRoles(Set.of(Roles.CUSTOMER));
			rep.save(user);
			return true;
		}

	}

}
