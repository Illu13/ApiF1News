package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.example.demo.model.DatosAltaUsuario;
import com.example.demo.model.DatosIdentificacionUsuario;
import com.example.demo.model.DatosLoginUsuario;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepositorio;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.services.UserEntityService;

import jakarta.servlet.http.HttpServletRequest;

//import com.example.demo.auth.GenerateToken;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepositorio usRep;
	@Autowired
	UserEntityService ues;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@CrossOrigin
	@PostMapping(path = "insertar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public DatosAltaUsuario register(@RequestBody DatosAltaUsuario usuario, HttpServletRequest request) {

		try {
			User userRegistrado = ues.save(usuario);
			return new DatosAltaUsuario(userRegistrado.getEmail(), userRegistrado.getUsername(),
					userRegistrado.getPassword(), userRegistrado.getName());

		} catch (Exception e) {
			return new DatosAltaUsuario("Usuario ya existente", null, null, null);
		}
	}

	@CrossOrigin
	@PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public DatosIdentificacionUsuario login(@RequestBody DatosLoginUsuario loginDTO) {
//		Authentication authDTO = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
//				loginDTO.getPassword());

		try {
//			Authentication authentication = this.authManager.authenticate(authDTO);
			System.out.println(loginDTO.toString());
			User user = null;
			try {
				user = this.usRep.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword()).get();
			} catch (Exception e) {

			}
			if (user == null) {
				return new DatosIdentificacionUsuario("Usuario incorrecto", null);
			}
			String token = this.jwtTokenProvider.generateToken(user);
			return new DatosIdentificacionUsuario(user.getUsername(), token);
		} catch (AuthenticationException e) {
			// Manejar la excepción, imprimir el mensaje de error o realizar acciones
			// específicas de manejo de errores.
			e.printStackTrace();
		}

		return null;

	}
}
