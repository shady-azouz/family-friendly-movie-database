package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.entities.User;
import com.ffmdb.familyfriendlymdb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @PostConstruct
    private void createUsers(){
        User user = new User("Shady Azouz", "shady.azouz@gmail.com", "dummyPassword", "user");
        userRepository.save(user);
        user = new User("Hussain", "hussain@gmail.com", "dummyPassword", "admin");
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void signUp(User user){
        userRepository.save(user);
    }

    public User loadUserByUsername(String email){
        return userRepository.findById(email).orElse(null);
    }
}
