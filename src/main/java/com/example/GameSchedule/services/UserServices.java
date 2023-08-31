package com.example.GameSchedule.services;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.ui.Model;

import com.example.GameSchedule.Models.User;

import jakarta.servlet.http.HttpSession;

public interface UserServices {

	public Boolean save(User user, HttpSession session);

	public User findByUserId(Long id);

	public  long numberOfUsers();

	public String updateUserUsingForm(@NotNull Model model, long id);

	public void delete(User user);

	public List<User> findAllUsers();
}
