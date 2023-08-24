package com.example.GameSchedule.controllers;

import com.example.GameSchedule.services.LoginAPIServices;
import com.example.GameSchedule.util.DateTimeUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping("/loginapi")
public class LoginController {

    DateTimeUtil dateTimeUtil = new DateTimeUtil();
     LoginAPIServices loginAPIServices = new LoginAPIServices();
    @PostMapping("/userlogin")
    public ResponseEntity<String> userLogin(
            @RequestParam(required = false) String usernameOrEmail,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String password,
            @RequestParam(required = false)  String dob
            ) throws ParseException {
        System.out.println(usernameOrEmail+"  "+username+"  "+password);
        System.out.println(dob);


//        if (usernameOrEmail != null || password !=null){
//            return ResponseEntity.badRequest().body("Email Or Username Not Entered");
//        } else if ( password != null || dob != null) {
//            return ResponseEntity.badRequest().body("Password Or dob Not Entered");
//        }

        Date DOB = null;
        try {
            if(dob.equals("")==false){
                System.out.println("String Date --> Util.Date Date");
                DOB = dateTimeUtil.stringToDate(dob);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println(DOB);

        if (usernameOrEmail!=null && dob.equals("")==false) {
            System.out.println("email and dob");
            loginAPIServices.loginWithUsername(usernameOrEmail,DOB);

        } else if (usernameOrEmail!=null && password.equals("")==false && password.equals("null")==false) {
             System.out.println("email and password");
             loginAPIServices.loginWithUsername(usernameOrEmail, password);

        }



//        else if (usernameOrEmail!=null && password!=null) {
//             System.out.println("username and password");
//            loginAPIServices.loginWithUsername(username,password);
//
//        }else if (usernameOrEmail!=null && password!=null) {
//             System.out.println("email and password");
//            loginAPIServices.loginWithEmail(usernameOrEmail,password);
//
//        }
        return ResponseEntity.ok("Login Succesfull!!");
    }

}
