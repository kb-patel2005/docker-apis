package com.ecommarce.demo.dao;

import java.util.List;

import com.ecommarce.demo.entity.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface ProductRepo extends MongoRepository<Product, String> {

    // Find userId by email and password
    @Query(value = "{ 'email' : ?0, 'password' : ?1 }", fields = "{ 'user_id' : 1 }")
    String searchByUsernameAndPassword(String username, String password);

    // Find userId by email
    @Query(value = "{ 'email' : ?0 }", fields = "{ 'user_id' : 1 }")
    String searchByUserId(String username);

    // Find product by title and userId
    @Query(value = "{ 'title' : ?0, 'user_user_id' : ?1 }")
    Product searchProduct(String pTitle, String uid);

    // Find all products by userId
    @Query(value = "{ 'user_user_id' : ?0 }")
    List<Product> searchProducts(String uid);
}
