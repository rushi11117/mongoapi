package com.example.GameSchedule.util;

import com.example.GameSchedule.Models.User;
import com.example.GameSchedule.repo.UserRepository;
import com.example.GameSchedule.services.UserServices;
import org.springframework.stereotype.Service;

@Service
public class IdGenerator {

    private final UserRepository userRepository;

    public IdGenerator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long getLastestId() {
        MongoUtil mongoUtil = new MongoUtil(userRepository);
        User lastestUser = mongoUtil.getLastestUpdateDocument();
        if (lastestUser == null) {
            return 19200001L;
        } else {
            return lastestUser.getId() + UserServices.numberOfUsers();
        }
    }
}
