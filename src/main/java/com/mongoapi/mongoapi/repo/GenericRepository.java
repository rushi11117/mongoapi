package com.mongoapi.mongoapi.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface GenericRepository<T, Long> extends MongoRepository<T, Long> {

    @Query("{'id' : ?0}")
    <T> Optional<T> findItemById(Long id, Class<T> ReturnedType);

}
