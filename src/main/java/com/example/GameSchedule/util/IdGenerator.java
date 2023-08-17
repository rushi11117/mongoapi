package com.example.GameSchedule.util;

import com.example.GameSchedule.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class IdGenerator {

    private final UserRepository userRepository;

    public IdGenerator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long getLastestId() {
        MongoUtil mongoUtil = new MongoUtil(userRepository);
        System.out.println(
                mongoUtil.getLastestUpdateDocument()
        );
        Long getLastestId = mongoUtil.getLastestUpdateDocument().getId();
        return getLastestId+1;
    }
}
