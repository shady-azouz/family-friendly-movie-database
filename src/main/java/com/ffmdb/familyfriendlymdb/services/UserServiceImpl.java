package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.entities.User;
import com.ffmdb.familyfriendlymdb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @PostConstruct
    private void createUsers() {
        User user = new User("Shady Azouz", "shady.azouz@gmail.com", "dummyPassword", "ROLE_user");
        userRepository.save(user);
        user = new User("Hussain", "hussain@gmail.com", "dummyPassword", "ROLE_admin");
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void signUp(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findById(s).orElse(null);
    }

//    public User registerNewUserAccount(UserDTO userDto) throws UserAlreadyExistException {
//        if (emailExist(userDto.getEmail())) {
//            throw new UserAlreadyExistException("There is an account with that email address: "
//                    + userDto.getEmail());
//        }
//
//        // the rest of the registration operation
//    }
//    private boolean emailExist(String email) {
//        return userRepository.findByEmail(email) != null;
//    }

//    public User loadUserByUsername(String email){
//        return userRepository.findById(email).orElse(null);
//    }
}
