package com.ecommarce.demo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class EcommarceUser {
    
    @Id
    private String userId;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String address;
    private String city;
    private int zip;
    private List<ProductItem> productItems;

    public List<ProductItem> getProductItems() {
        return productItems;
    }
    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }
    public EcommarceUser() {
    }
    public EcommarceUser(String userId, String email, String password, String address, String city, int zip,List<ProductItem> productItems) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.productItems = productItems;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }  
    public String getEmail() {
        return email;
    }   
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }   
    @Override
    public String toString() {
        return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", address=" + address
                + ", city=" + city + ", zip=" + zip+ ", productItems=" + productItems + "]";
    }
}