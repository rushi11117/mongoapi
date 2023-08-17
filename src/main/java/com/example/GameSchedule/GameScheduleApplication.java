package com.example.GameSchedule;

import com.example.GameSchedule.Models.User;
import com.example.GameSchedule.repo.UserRepository;
import com.example.GameSchedule.services.UserServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameScheduleApplication {

	private static UserRepository userRepository;
	public static UserServices userServices = new UserServices(userRepository);

	public static void main(String[] args) {
		SpringApplication.run(GameScheduleApplication.class, args);
		System.out.println("Hello");

	}

}
