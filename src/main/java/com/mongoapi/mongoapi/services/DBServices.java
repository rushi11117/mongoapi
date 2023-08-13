package com.mongoapi.mongoapi.services;

import com.mongoapi.mongoapi.model.Person;
import com.mongoapi.mongoapi.repo.GenericRepository;
import com.mongoapi.mongoapi.repo.PersonRepository;

public class DBServices {

    private static GenericRepository genericRepository;
    public Person getItemById(Class<T>, Long id) {

        return genericRepository.findItemById(id);
    }
}
