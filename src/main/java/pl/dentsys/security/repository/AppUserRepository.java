package pl.dentsys.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.dentsys.security.domain.AppUser;


public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser findOneByUsername(String username);
}
