package com.example.project.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Abean {
	
	private String text;
	private String text2;
	
	public void submit() {
		System.out.println("text: " +text);
	}
	
	public void submit2() {
		System.out.println("text2: " +text2);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}
}