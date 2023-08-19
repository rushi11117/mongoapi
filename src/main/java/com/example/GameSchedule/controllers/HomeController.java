package com.example.GameSchedule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class HomeController {

	@GetMapping("/")
	public String getHomePage() {
		return "Home";
	}

	@GetMapping("/error")
	public String error() {
		return "Error";
	}

	@GetMapping("/login")
	public String getLoginForm() {
		return "LogginForm";
	}

}
