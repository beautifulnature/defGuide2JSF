package com.example.project.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class Spa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	@ManagedProperty("#{param.page}")
	private String page;

	/*
	 * @PostConstruct public void init() { page = "page1"; }
	 */
	
	@PostConstruct
	public void init() {
		
		page = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("page"); // This is the work around.
		
		if (page == null || page.isEmpty()) {
			page = "page1";
		}
	}

	public String getPage() {
		return page;
	}

	public void set(String page) {
		this.page = page;
	}
}