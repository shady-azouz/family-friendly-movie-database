package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.entities.User;
import com.ffmdb.familyfriendlymdb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void addUser(User user){
        userRepository.save(user);
    }
}
