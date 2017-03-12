package com.restservice.repository;

import com.restservice.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Igor on 13.01.2017.
 */
@Repository
public interface UserRepository extends MongoRepository<User,ObjectId> {

    public Optional<User> findByEmail(String email);
}
