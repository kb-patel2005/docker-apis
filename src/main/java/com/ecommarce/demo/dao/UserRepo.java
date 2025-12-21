package com.ecommarce.demo.dao;
import com.ecommarce.demo.entity.EcommarceUser;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface UserRepo extends MongoRepository<EcommarceUser, String> {

    Optional<EcommarceUser> findByEmail(String email);

    // Find user by email and password
    @Query("{ 'email' : ?0, 'password' : ?1 }")
    EcommarceUser searchUser(String email, String password);

    // Find user_id by email (assuming user_id is stored as a field in the document)
    @Query(value="{ 'email' : ?0 }", fields="{ 'user_id' : 1 }")
    EcommarceUser searchUser(String email);

    // Find user by email
    @Query("{ 'email' : ?0 }")
    EcommarceUser searchByEmail(String email);
}