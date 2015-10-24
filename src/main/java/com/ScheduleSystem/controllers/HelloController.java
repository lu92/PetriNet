package com.ScheduleSystem.controllers;

import com.ScheduleSystem.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	private AddressRepository addressRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		if (addressRepository == null)
			model.addAttribute("message", "addressRepository is null");
		else
			model.addAttribute("message", "Hello world3!");
		return "hello";
	}
}
