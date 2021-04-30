package com.example.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import com.example.project.model.listener.MarkdownListener;

@Entity
@EntityListeners(MarkdownListener.class)
public class Messagemd implements Markdown, Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	@Lob
	private @NotNull String text;
	@Column(nullable = false)
	@Lob
	private String html;
	@Column(nullable = false, length = 8)
	private String version;

	public void setText(String text) {
		if (!text.equals(this.text)) {
			this.text = text;
			setVersion(null); // Trigger for MarkdownListener @PreUpdate.
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getText() {
		return text;
	}
}
