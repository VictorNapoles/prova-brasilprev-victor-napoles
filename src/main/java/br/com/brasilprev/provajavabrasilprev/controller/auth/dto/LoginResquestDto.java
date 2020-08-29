package br.com.brasilprev.provajavabrasilprev.controller.auth.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginResquestDto {
    private String mail;
	private String password;
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsernamePasswordAuthenticationToken convert() {
		return new UsernamePasswordAuthenticationToken(mail, password);
	}
}
