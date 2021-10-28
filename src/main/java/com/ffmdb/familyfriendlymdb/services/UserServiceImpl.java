package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.dtos.UserDTO;
import com.ffmdb.familyfriendlymdb.entities.User;
import com.ffmdb.familyfriendlymdb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @PostConstruct
    private void createUsers() {
        User user = new User("Shady Azouz", "shady.azouz@gmail.com", "dummyPassword", "ROLE_user");
        userRepository.save(user);
        user = new User("Hussain", "hyahya@sumerge.com", "dummyPassword", "ROLE_admin");
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findById(s).orElse(null);
    }

    public String registerNewUserAccount(UserDTO userDto) {
        if (emailExist(userDto.getEmail())) {
            return "Email: " + userDto.getEmail() + " Already Registered";
        }
        if (userDto.getPassword().matches(userDto.getMatchingPassword())) {
            User newUser = new User(userDto);
            userRepository.save(newUser);
            return "User: " + userDto.getEmail() + " Registered";
        }
        return "Password doesn't match Repeated Password";
    }

    private boolean emailExist(String email) {
        return !userRepository.findById(email).isEmpty();
    }

//    public User loadUserByUsername(String email){
//        return userRepository.findById(email).orElse(null);
//    }
}
