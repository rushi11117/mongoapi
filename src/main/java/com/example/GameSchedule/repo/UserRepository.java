package com.example.GameSchedule.repo;

import com.example.GameSchedule.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    @Query("{ 'id' : ?0 }")
    User findByUserId(long id);

    @Query("{}")
    long collectionCount();

    Optional<User> findTopByOrderByFirstModifiedDesc();

    }
