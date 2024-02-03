package com.example.demo.model;

public class DatosIdentificacionUsuario {

	String username;
	String token;

	public DatosIdentificacionUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatosIdentificacionUsuario(String username, String token) {
		super();
		this.username = username;
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
