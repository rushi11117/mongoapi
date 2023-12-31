package com.example.GameSchedule.controllers;

import com.example.GameSchedule.Models.User;
import com.example.GameSchedule.services.UserServices;
import com.example.GameSchedule.services.UserServicesImpl;

import jakarta.servlet.http.HttpSession;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    private final UserServicesImpl userServices;

    @Autowired
    public UserController(UserServicesImpl userServices) {
        this.userServices = userServices;
    }

    @RequestMapping("/view/{id}")
    public String showUser(@PathVariable long id, @NotNull Model model) {

        User user = userServices.findByUserId(id);
//        System.out.println(user.getId());
        model.addAttribute("user", user);
        return "ShowUser";
    }



    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute User user, HttpSession session) {
        Boolean isSaved = userServices.save(user, session);
        ResponseEntity.ok("User Saved.");
        return "redirect:/register";
    }

    @RequestMapping("/getall")
    public String getUsers(@NotNull Model model) {

        System.out.println("Got Request");
        List<User> users = userServices.findAllUsers();
//        users.forEach(user -> {System.out.println(user.getId());});

        model.addAttribute("users", users);
        for (User person:users) {
            System.out.println(person.getName());
        }
        return "Userlist";
    }


    @RequestMapping("/update/{id}")
    public void updateUser(@PathVariable long id, @NotNull Model model) {
        userServices.updateUserUsingForm(model, id);
//        return "UpdateUser";
    }
    @RequestMapping("/delete/{id}")
    public void deleteUser(@PathVariable long id) {
        userServices.delete(userServices.findByUserId(id));
//        return "redirect:/user/getall";
    }

    @RequestMapping("/addintro")
    public void addIntro() {

    }
}
