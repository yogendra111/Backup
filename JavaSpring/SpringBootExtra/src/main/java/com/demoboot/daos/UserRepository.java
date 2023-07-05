package com.demoboot.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demoboot.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	
}
