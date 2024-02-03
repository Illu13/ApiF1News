package com.example.demo.model;

public class Token {
	
	String token;
	String expirationDate;
	
	public Token(String token, String expirationDate) {
		super();
        this.token = token;
        this.expirationDate = expirationDate;
	}
	public Token() {
        super();
    }
	
	public String getToken() {
        return token;
    }
	public void setToken(String token) {
        this.token = token;
    }
	public String getExpirationDate() {
        return expirationDate;
    }
	public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

}
