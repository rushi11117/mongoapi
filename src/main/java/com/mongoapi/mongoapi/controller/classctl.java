package com.mongoapi.mongoapi.controller;

import com.mongoapi.mongoapi.repo.PersonRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class classctl <Model, Id> {


    private static MongoRepository mongoRepository;
    @GetMapping("/{id}")
    public getById(@RequestBody long id) {

    }
}
