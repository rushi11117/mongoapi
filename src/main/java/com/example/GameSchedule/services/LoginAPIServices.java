package com.example.GameSchedule.services;

import com.example.GameSchedule.Models.User;
import com.example.GameSchedule.controllers.SessionController;
import com.example.GameSchedule.repo.UserRepository;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Enumeration;

import static com.example.GameSchedule.util.Hash.generateSHA256Hash;

@Service
public class LoginAPIServices {

    private static UserRepository userRepository;
    private static User user;
    private static SessionController sessionController;
    
    

}
