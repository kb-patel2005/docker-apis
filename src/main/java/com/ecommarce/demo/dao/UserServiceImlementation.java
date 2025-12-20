package com.ecommarce.demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ecommarce.demo.entity.EcommarceUser;
import org.springframework.dao.DuplicateKeyException;

@Service
public class UserServiceImlementation implements UserServices{

    @Autowired
    UserRepo u;

    @Override
    @Transactional
    public String signUpUser(EcommarceUser user) {
        try{
            u.insert(user);
            return "register successfully";
        }catch(DuplicateKeyException e){
            return "email is duplicate....";
        }
        
    }

    @Override
    public EcommarceUser loginUser(String username, String password) {
        EcommarceUser user=u.searchUser(username, password);
        if(user == null){
            return null;
        }
        else{
            return user;
        }
    }

    @Override
    public void logOutUser(String uid) {
        u.deleteById(uid);
    }

    @Override
    public Optional<EcommarceUser> getUser(String uid) {
        return u.findById(uid);
    }

    @Override
    public void updateUserDetail(EcommarceUser user) {
        System.out.println(user);
        Optional<EcommarceUser> existing = u.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            EcommarceUser user1 = existing.get();
            user1.setAddress(user.getAddress());
            user1.setCity(user.getCity());
            user1.setZip(user.getZip());
            user1.setPassword(user.getPassword());
            user1.setProductItems(user.getProductItems());
            u.save(user1); 
        } else {
        }
    }

    @Override
    public EcommarceUser updateByemail(String email) {
        EcommarceUser e= u.searchByEmail(email);
        return e;
    }
    
}
