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

    ////Login Servicess
//    public Boolean loginWithEmail(String email, String password) {
//        user = userRepository.findByEmail(email);
//        if(user != null) {
//            if (user.getPassword().equals(password)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public Boolean loginWithUsername(String email, Date DOB) {
        user = userRepository.findByEmail(email);
        if(user != null) {
            if (user.getDOB().equals(DOB)) {
                sessionController.setAttribute(new HttpSession() {
                    @Override
                    public long getCreationTime() {
                        return 0;
                    }

                    @Override
                    public String getId() {
                        return null;
                    }

                    @Override
                    public long getLastAccessedTime() {
                        return 0;
                    }

                    @Override
                    public ServletContext getServletContext() {
                        return null;
                    }

                    @Override
                    public void setMaxInactiveInterval(int interval) {

                    }

                    @Override
                    public int getMaxInactiveInterval() {
                        return 0;
                    }

                    @Override
                    public Object getAttribute(String name) {
                        return null;
                    }

                    @Override
                    public Enumeration<String> getAttributeNames() {
                        return null;
                    }

                    @Override
                    public void setAttribute(String name, Object value) {

                    }

                    @Override
                    public void removeAttribute(String name) {

                    }

                    @Override
                    public void invalidate() {

                    }

                    @Override
                    public boolean isNew() {
                        return false;
                    }
                }, user.getEmail());
                return true;
            }
        }
        return false;
    }

    public Boolean loginWithUsername(String username, String password) {
        user = userRepository.findByUsername(username);
        if(user != null) {
            if (user.getPassword().equals(generateSHA256Hash(password))) {
                return true;
            }
        }
        return false;
    }

//    public Boolean loginWithUsername(String username, Date DOB) {
//        user = userRepository.findByUsername(username);
//        if(user != null) {
//            if (user.getDOB().equals(DOB)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
