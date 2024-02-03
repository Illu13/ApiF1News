package com.example.demo.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

import jakarta.transaction.Transactional;

public interface UserRepositorio extends JpaRepository<User, Serializable> {
	
	
	public abstract Optional<User> findByEmail(String email);
	public abstract Optional<User> findByUsername(String username);
	public abstract Optional<User> findByUsernameAndPassword(String username, String password);
	
	@Transactional
	public abstract User save(User user);

}
