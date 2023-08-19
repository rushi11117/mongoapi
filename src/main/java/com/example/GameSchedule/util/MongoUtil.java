package com.example.GameSchedule.util;

import com.example.GameSchedule.Models.User;
import com.example.GameSchedule.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class MongoUtil {

    private final UserRepository userRepository;

    @Autowired
    public MongoUtil(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getLastestUpdateDocument() {

        //Query to Get Lasted Updated Document if TimeStamp not set
//        Query query = new Query().with(Sort.by(
//                Sort.Direction.DESC,"Updated At"
//        )).limit(1);

        if (userRepository.findTopByOrderByFirstModifiedDesc() == null) {
//            return new User(new Long(1920001),null,null,null,null,null,null,null);
            return null;
        } else {
            return userRepository.findTopByOrderByFirstModifiedDesc();
        }
    }

}
