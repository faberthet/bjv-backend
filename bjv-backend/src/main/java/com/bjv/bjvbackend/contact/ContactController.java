package com.bjv.bjvbackend.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	
	@Autowired
	EmailSenderService service;
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("")
	public void sendEmail(@RequestBody ContactModel contact){
		service.SendEmail("berthet-fabrice@hotmail.fr", contact.toString(), "contact from breizh jardin vivant");
		//System.out.println(contact);
	}
	
	 @GetMapping("")
	 public void testfdsfsdfet(){
		System.out.println("coucou");
	}
	
}
