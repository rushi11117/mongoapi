package com.example.GameSchedule.services;

import com.example.GameSchedule.Models.User;
import com.example.GameSchedule.repo.UserRepository;
import com.example.GameSchedule.util.IdGenerator;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServices {

    private static UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean save(String name, String email, String DOB, String password) {

        IdGenerator idGenerator = new IdGenerator(userRepository);
        User user = new User(idGenerator.getLastestId(),null,null,null,null,null,null,null);
        if(name != null) {
            user.setName(name);
        }
        if (email != null) {
            user.setEmail(email);
        }
        if (password != null) {
            user.setPassword(password);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(DOB != null) {
            try {
                Date tmpDOB = dateFormat.parse(DOB);
                System.out.println(tmpDOB);
                System.out.println(tmpDOB.getClass());
                user.setDOB(tmpDOB);
            } catch (ParseException e) {
                System.out.println(e);
            }
        }

        user.setFirstModified();
        user.setLastModified();
        User userAdded = userRepository.save(user);
        if (user !=null) {
            return true;
        }
        return false;

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

    public static long numberOfUsers() {
        long numberOfUsers = userRepository.count();
        return numberOfUsers;
    }

    public User findByUserId(Long id) {
        return userRepository.findByUserId(id);
    }
}
