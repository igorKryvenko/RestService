package com.restservice.repository;

import com.restservice.model.Role;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Igor on 07.03.2017.
 */
@Repository
public interface RoleRepository extends MongoRepository<Role,ObjectId> {
    Role findByName(String name);
}
