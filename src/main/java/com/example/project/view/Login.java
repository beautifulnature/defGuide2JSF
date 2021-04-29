package com.example.project.view;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class Login {

	private String email;
	private String password;

	public String submit() {
		if(email.equals(password))
			return "/hello.xhtml?faces-redirect=true";
		else {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("Authentication failed");
			//context.addMessage("login:submit", message);
			context.addMessage(null, message);
			return null;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}