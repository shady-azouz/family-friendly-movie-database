package com.ffmdb.familyfriendlymdb.controllers;

import com.ffmdb.familyfriendlymdb.dtos.UserDTO;
import com.ffmdb.familyfriendlymdb.entities.User;
import com.ffmdb.familyfriendlymdb.repositories.UserRepository;
import com.ffmdb.familyfriendlymdb.security.JwtUtil;
import com.ffmdb.familyfriendlymdb.security.models.AuthenticationRequest;
import com.ffmdb.familyfriendlymdb.security.models.AuthenticationResponse;
import com.ffmdb.familyfriendlymdb.services.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @InjectMocks
    private UserController userController;
    @Mock
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtUtil jwtUtil;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("sign up")
    void signUp() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("shady.azouz@gmail.com");
        when(userService.registerNewUserAccount(userDTO)).thenReturn("User: shady.azouz@gmail.com Registered");
        assertEquals("User: shady.azouz@gmail.com Registered", userController.signUp(userDTO));
    }

    @Test
    @DisplayName("create authentication token")
    @Disabled
    void createAuthenticationToken() throws Exception {
        when(authenticationManager.authenticate(
                any(UsernamePasswordAuthenticationToken.class)
        )).thenAnswer(i -> i.getArguments()[0]);
        when(jwtUtil.generateToken(any(UserDetails.class))).thenReturn("token");
        User user = new User();
        when(userRepository.findById(anyString())).thenReturn(Optional.of(user));
        AuthenticationRequest form = new AuthenticationRequest("test", "test");
        AuthenticationResponse response = new AuthenticationResponse("token");
        assertEquals(response, userController.createAuthenticationToken(form).getBody());
    }
}