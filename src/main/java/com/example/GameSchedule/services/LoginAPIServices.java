package com.example.GameSchedule.services;

import com.example.GameSchedule.Models.User;
import com.example.GameSchedule.repo.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class LoginAPIServices {

    private static UserRepository userRepository;
    private static User user;

    ////Login Servicess
    public Boolean loginWithEmail(String email, String password) {
        user = userRepository.findByEmail(email);
        if(user != null) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Boolean loginWithEmail(String email, Date DOB) {
        user = userRepository.findByEmail(email);
        if(user != null) {
            if (user.getDOB().equals(DOB)) {
                return true;
            }
        }
        return false;
    }

    public Boolean loginWithUsername(String username, String password) {
        user = userRepository.findByUsername(username);
        if(user != null) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Boolean loginWithUsername(String username, Date DOB) {
        user = userRepository.findByUsername(username);
        if(user != null) {
            if (user.getDOB().equals(DOB)) {
                return true;
            }
        }
        return false;
    }
}
