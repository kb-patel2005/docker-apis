package com.ecommarce.demo.dao;

import java.util.Optional;

import com.ecommarce.demo.entity.EcommarceUser;

public interface UserServices {
    
    public String signUpUser(EcommarceUser u);

    public EcommarceUser loginUser(String username,String password);

    public void logOutUser(String uid);

    public Optional<EcommarceUser> getUser(String uid);

    public void updateUserDetail(EcommarceUser u);

    public EcommarceUser updateByemail(String email);

}
