package com.ecommarce.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommarce.demo.dao.UserServices;
import com.ecommarce.demo.dao.loginUser;
import com.ecommarce.demo.entity.EcommarceUser;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServices serv;

    //done........
    @PostMapping("/signup")
    public boolean addUser(@RequestBody EcommarceUser u){
        String answer = serv.signUpUser(u);
        if(answer.equals("register successfully")){
            return true;
        }
        else{
            return false;
        }
    }

    //done........
    @PostMapping("/login")
    public EcommarceUser loginuser(@RequestBody loginUser user){
        String e=user.getEmail();
        String pass=user.getPassword();
        EcommarceUser user1=serv.loginUser(e,pass);
        if(user1 == null){
            return null;
        }
        return user1;
    }

    // done.........
    @PutMapping("/")
    public void updateUser(@RequestBody EcommarceUser u){
        serv.updateUserDetail(u);
    }

}
