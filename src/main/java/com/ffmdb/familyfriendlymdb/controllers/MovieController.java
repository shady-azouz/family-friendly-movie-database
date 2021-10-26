package com.ffmdb.familyfriendlymdb.controllers;

import com.ffmdb.familyfriendlymdb.entities.Movie;
import com.ffmdb.familyfriendlymdb.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/topmovies")
    public List<Movie> getTopMovies(){
        return movieService.getAllMovies();
    }
}
