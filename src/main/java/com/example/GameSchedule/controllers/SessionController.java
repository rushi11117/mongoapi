package com.example.GameSchedule.controllers;

import jakarta.servlet.http.HttpSession;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/session")
public class SessionController {

    @RequestMapping("/set")
    public String setAttribute(@NotNull HttpSession session, String username) {
        session.setAttribute("username", username);
        return "Session Set";
    }

    @RequestMapping("/get")
    public String getAttribute(@NotNull HttpSession session) {
        return (String) (session.getAttribute("usename"));
    }

    public String invalidate(HttpSession session) {
        session.invalidate();
        return "Session Ended";
    }

}
