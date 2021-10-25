package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.entities.Movie;
import com.ffmdb.familyfriendlymdb.repositories.MovieRepository;
import com.ffmdb.familyfriendlymdb.tmdbJSON.TmdbMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @PostConstruct
    public void loadMovies() {
        RestTemplate restTemplate = new RestTemplate();
        String key = "a8bd7f3d0cff0c86e330f635ea81ce95";
        for(int i=1;i<6;i++){
            TmdbMovie response =
                    restTemplate.getForObject(
                            "https://api.themoviedb.org/3/movie/top_rated"
                                    + "?api_key=" + key
                                    + "&page=" + i
                                    + "&language=en-US",
                            TmdbMovie.class);
            for(Movie movie : response.getResults()){
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
