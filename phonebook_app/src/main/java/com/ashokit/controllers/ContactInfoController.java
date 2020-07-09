package com.ashokit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.models.Contact;
import com.ashokit.service.ContactService;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping(value= {"/","/loadform"})
	public String loadForm(Model model) {
		Contact c=new Contact();
		model.addAttribute("contact",c);
		return "contactInfo";
	}
	@PostMapping(value="/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact")Contact contact,RedirectAttributes attribute) {
		boolean isSaved = contactService.save(contact);
		if(isSaved) {
			Integer contactId = contact.getContactId();
			attribute.addFlashAttribute("succMsg", "contact Saved");
		}
		else {
			attribute.addFlashAttribute("errorMsg","Failed to save the contact");
		}
		
		return "redirect:/";
		
	}
	@GetMapping("/viewContacts1")
	public String handlingViewContactsLink(Model model) {
		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts",contacts);
		return "viewContacts";
	}
}
