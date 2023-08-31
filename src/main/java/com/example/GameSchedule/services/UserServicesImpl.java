package com.example.GameSchedule.services;

import com.example.GameSchedule.Models.User;
import com.example.GameSchedule.repo.UserRepository;
import com.example.GameSchedule.util.Hash;

import jakarta.servlet.http.HttpSession;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.GameSchedule.util.Hash.generateSHA256Hash;

@Service
public class UserServicesImpl implements UserServices {

    private static UserRepository userRepository;

    public Boolean save(User user ,HttpSession session) {
    	userRepository.findByEmail(user.getEmail());
    	if(userRepository.findByEmail(user.getEmail())!=null) {
    		session.setAttribute("msg", "User Already Exists!!");
    		return false;
    	}
    	user.setPassword(Hash.generateSHA256Hash(user.getPassword()));
    	User savedUser = userRepository.save(user);
    	if(savedUser!=null) {
    		session.setAttribute("msg","User Added!!");
        	return true;
    	} else {
    		session.setAttribute("msg","Something Wrong On Server Side");
    		return false;
    	}
    }

    public List<User> findAllUsers(){

        return userRepository.findAll();
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public String updateUserUsingForm(@NotNull Model model, long id) {
        User user = userRepository.findByUserId(id);
        model.addAttribute("user", user);
        return "UpdateUser";
    }

    public long numberOfUsers() {
        long numberOfUsers = userRepository.count();
        return numberOfUsers;
    }

    public User findByUserId(Long id) {
        return userRepository.findByUserId(id);
    }
}
