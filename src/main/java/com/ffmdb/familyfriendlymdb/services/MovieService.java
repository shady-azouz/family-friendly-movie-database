package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.entities.Movie;
import com.ffmdb.familyfriendlymdb.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }
//    public
}
