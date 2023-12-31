package com.example.GameSchedule.repo;

import com.example.GameSchedule.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, Long> {
    @Query("{ 'id' : ?0 }")
    User findByUserId(long id);

    @Query("{}")
    long collectionCount();

    @Query("{'email' : ?0}")
    User findByEmail(String email);

//    User findTopByOrderByFirstModifiedDesc();

    }
