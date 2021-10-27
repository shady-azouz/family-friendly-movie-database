package com.ffmdb.familyfriendlymdb.controllers;

import com.ffmdb.familyfriendlymdb.entities.Movie;
import com.ffmdb.familyfriendlymdb.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/getMovies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/topMovies", method = RequestMethod.GET)
    public List<Movie> getTopMovies(){
        return movieService.getAllMovies();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletemovie/{id}")
    public void deleteMovie(@PathVariable Integer movie_id){
        movieService.deleteMovie(movie_id);
    }
}