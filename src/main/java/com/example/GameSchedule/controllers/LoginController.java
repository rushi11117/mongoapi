package com.example.GameSchedule.controllers;

import com.example.GameSchedule.services.LoginAPIServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/loginapi")
public class LoginController {

    private static LoginAPIServices loginAPIServices;
    @PostMapping("/userlogin")
    public ResponseEntity<String> userLogin(
            @RequestParam(required = false) String usernameOrEmail,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password,
            @RequestParam(required = false)Date DOB
            ){
//        if (usernameOrEmail == null || password ==null){
//            return ResponseEntity.badRequest().body("Email Or Username Not Entered");
//        } else if ( password == null || DOB == null) {
//            return ResponseEntity.badRequest().body("Password Or DOB Not Entered");
//        }
         if (usernameOrEmail==null && password==null) {

            loginAPIServices.loginWithUsername(username, DOB);

        } else if (usernameOrEmail==null && password==null) {

            loginAPIServices.loginWithEmail(usernameOrEmail,DOB);

        }else if (usernameOrEmail==null && password==null) {

            loginAPIServices.loginWithUsername(username,password);

        }else if (usernameOrEmail==null && password==null) {

            loginAPIServices.loginWithEmail(usernameOrEmail,password);

        }
        return ResponseEntity.ok("Login Succesfull!!");
    }

}
