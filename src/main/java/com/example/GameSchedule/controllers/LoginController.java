package com.example.GameSchedule.controllers;

import com.example.GameSchedule.Models.User;
import com.example.GameSchedule.repo.UserRepository;
import com.example.GameSchedule.services.LoginAPIServices;
import com.example.GameSchedule.util.DateTimeUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.text.ParseException;
import java.util.Date;
import com.example.GameSchedule.util.Hash;

@Controller
@RequestMapping("/loginapi")
public class LoginController {
	
	private static UserRepository userRepository;
	public LoginController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@PostMapping("login")
    public String userLogin(@ModelAttribute User user, HttpSession session) {
//        LoginAPIServices.
        User foundUser = userRepository.findByEmail(user.getEmail());
        System.out.println("    ");
        System.out.println(foundUser.getPassword());
        System.out.println(Hash.generateSHA256Hash(user.getPassword()));
        if(foundUser.getPassword().equals(Hash.generateSHA256Hash(user.getPassword()))) {
        	session.setAttribute("logedin", user.getEmail());
        	ResponseEntity.ok("Login Success!!");
        	return "redirect:/admin/";
        } else {
        	ResponseEntity.ok("Invalid Password!!");
        	return "redirect:/signup";
        }
    }
}
