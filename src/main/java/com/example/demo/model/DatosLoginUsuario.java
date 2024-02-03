package com.example.demo.model;

public class DatosLoginUsuario {

	String username;
	String password;

	public DatosLoginUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatosLoginUsuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String token) {
		this.password = token;
	}

	public String toString() {
		return "DatosLoginUsuario [username=" + username + ", password=" + password + "]";
	}

}
