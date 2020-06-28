package com.webapp.sysparking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.sysparking.domain.User;
import com.webapp.sysparking.repository.UserRepository;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public String getIndex() {
		return "index";
	}
	
	@GetMapping(value="/register")
	public String getRegister(Model model) {
		model.addAttribute("user", new User());
		return "registrar";
	}
	
	
	@PostMapping(value="/register")
	public String registrarUsuario(@ModelAttribute User user) {
	userRepository.save(user);
	return "registrar";
	}
	
	@GetMapping(value="/aboutus")
	public String getAboutUs() {
		return "sobre";
	}
	
	@GetMapping(value="/contactus")
	public String getContactUs() {
		return "contactus";
	}
	
	@GetMapping(value="/application")
	public String getApplication() {
		return "application";
	}
}
