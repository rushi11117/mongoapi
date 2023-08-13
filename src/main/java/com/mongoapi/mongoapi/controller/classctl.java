package com.mongoapi.mongoapi.controller;

import com.mongoapi.mongoapi.model.*;
import com.mongoapi.mongoapi.services.DBServices;
import com.sun.jdi.ClassType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public class classctl <Model, Id> {


    private static MongoRepository mongoRepository;
    private static DBServices dbServices;
    @GetMapping("/{id}")
    public <T> Optional<T> getById(@RequestBody Long id) {
        T userFound = (T)(dbServices.getItemById(id));
        return (Optional<T>) (userFound);
    }

    public <T> Optional<T> saveItem(Class<T> returnType) {


        return (Optional<T>) savedUser;
    }
}
