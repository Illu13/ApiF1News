package com.example.demo.services;

import com.example.demo.model.DatosAltaUsuario;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityService {
	@Autowired
	UserRepositorio usRep;
	private final UserRepositorio repository;

	public UserEntityService(UserRepositorio repository) {
		this.repository = repository;
	}

	public Optional<User> findByEmail(String email) {
		return this.repository.findByEmail(email);
	}
	

	public Optional<User> findByUsername(String username) {
		return this.repository.findByUsername(username);
	}
	
	
	

	public User save(DatosAltaUsuario userDTO) throws Exception {
		User user = new User(

				userDTO.getName(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail()

		);
		Optional<User> userOpNa = usRep.findByUsername(user.getUsername());
		Optional<User> userOpEm = usRep.findByEmail(user.getEmail());
		if (userOpNa.isEmpty() == false || userOpEm.isEmpty() == false) {
			throw new Exception("Ya existe un usuario con esas credenciales");
		} else {
			return this.repository.save(user);
		}
	}
}
