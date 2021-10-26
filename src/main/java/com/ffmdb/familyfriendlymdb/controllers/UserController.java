package com.ffmdb.familyfriendlymdb.controllers;

import com.ffmdb.familyfriendlymdb.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;


}