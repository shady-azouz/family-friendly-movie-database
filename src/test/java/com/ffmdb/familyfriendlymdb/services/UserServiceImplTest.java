package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.dtos.UserDTO;
import com.ffmdb.familyfriendlymdb.entities.User;
import com.ffmdb.familyfriendlymdb.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("get all users")
    void getAllUsers() {
        List<User> users = Arrays.asList(
                new User("shady", "shady.azouz@gmail.com", "dummyPassword", "ROLE_user")
        );
        when(userRepository.findAll()).thenReturn(users);
        assertEquals(users, userService.getAllUsers());
    }

    @Test
    @DisplayName("load user by name")
    void loadUserByUsername() {
        User user = new User("shady", "shady.azouz@gmail.com", "dummyPassword", "ROLE_user");
        when(userRepository.findById(anyString())).thenReturn(Optional.of(user));
        assertEquals(user, userService.loadUserByUsername(user.getUsername()));
    }

    @Test
    @DisplayName("sign Up")
    void registerNewUserAccount() {
        UserDTO userDTO = new UserDTO("Shady", "dummyPassword", "dummyPassword", "shady.azouz@gmail.com", "ROLE_user");
        User emptyUser = null;
        User user = new User(userDTO);
        when(userRepository.findById(anyString())).thenReturn(Optional.empty());
        String testString = "User: shady.azouz@gmail.com Registered";
        assertEquals(testString, userService.registerNewUserAccount(userDTO));
    }

//    @Test
//    void signUp() {
//        User user = new User();
//        when(userRepository.findById(anyString())).thenReturn(Optional.of(user));
//        when(userRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);
//        assertEquals(user, userService.signUp(user));
//    }
//
//    @Test
//    void signIn() throws Exception {
//        when(authenticationManager.authenticate(
//                any(UsernamePasswordAuthenticationToken.class)
//        )).thenAnswer(i -> i.getArguments()[0]);
//        when(jwtUtil.generateToken(any(UserDetails.class))).thenReturn("token");
//        User user = new User();
//        when(userRepository.findById(anyString())).thenReturn(Optional.of(user));
//        AuthorizationRequest form = new AuthorizationRequest("test", "test");
//        AuthorizationResponse response = new AuthorizationResponse("token");
//        areEqual(response, userService.signIn(form).getBody());
//    }
}