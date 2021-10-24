package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.entities.Movie;
import com.ffmdb.familyfriendlymdb.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @PostConstruct
    public void loadMovies() {
        RestTemplate restTemplate = new RestTemplate();
        String key = "a8bd7f3d0cff0c86e330f635ea81ce95";
        for(int i=1;i<6;i++){
            ResponseEntity<Movie[]> response =
                    restTemplate.getForEntity(
                            "https://api.themoviedb.org/3/movie/top_rated"
                                    + "?api_key=" + key
                                    + "?page=" + i
                                    + "&language=en-US",
                            Movie[].class);
            Movie[] movies = response.getBody();
            for(Movie movie : movies){
                movieRepository.save(movie);
            }
        }
    }

    public List<Movie> getAllMovies(){
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }
}
