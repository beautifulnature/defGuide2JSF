package com.example.project.view;

import java.util.List;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.example.project.model.Message;
import com.example.project.service.MessageService;

@Named
@RequestScoped
public class HelloWorldDb {

	private Message message = new Message();
	private List<Message> messages;
	
	public HelloWorldDb() {
		super();
	}

	@Inject
	private MessageService messageService;
	
	@PostConstruct
	public void init() {
		messages = messageService.list();
	}
	
	public void submit() {
		messageService.create(message);
		messages.add(message);
	}

	public Message getMessage() {
		return message;
	}

	public List<Message> getMessages() {
		return messages;
	}
}