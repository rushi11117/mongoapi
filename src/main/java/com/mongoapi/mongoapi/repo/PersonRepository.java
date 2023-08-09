package com.mongoapi.mongoapi.repo;


import com.mongoapi.mongoapi.model.Person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, ObjectId> {

}
