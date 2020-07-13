package com.ashokit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ashokit.exceptions.PhoneBookExceptionHandler;

@Controller
@ControllerAdvice
public class PhoneBookExceptionsController {

	@ExceptionHandler(value=PhoneBookExceptionHandler.class)
	public String handlingAllExceptionsInPhoneBook(Model model) {
		model.addAttribute("errorMsg","WE REGRET TO THE INCONCVINIECE OUR ENGINEERS WORKING ON IT");
		return "error";
	}
}
