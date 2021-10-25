package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.dtos.MovieDTO;
import com.ffmdb.familyfriendlymdb.entities.Genre;
import com.ffmdb.familyfriendlymdb.entities.Movie;
import com.ffmdb.familyfriendlymdb.repositories.GenreRepository;
import com.ffmdb.familyfriendlymdb.repositories.MovieRepository;
import com.ffmdb.familyfriendlymdb.tmdbJSON.TmdbMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GenreService genreService;

    @PostConstruct
    public void loadMovies() {
        RestTemplate restTemplate = new RestTemplate();
        String key = "a8bd7f3d0cff0c86e330f635ea81ce95";
        boolean isFull = false;
        int i = 1;
        int count = 0;
        while(!isFull){
            if(count < 100){
                TmdbMovie response =
                        restTemplate.getForObject(
                                "https://api.themoviedb.org/3/movie/top_rated"
                                        + "?api_key=" + key
                                        + "&page=" + i
                                        + "&language=en-US",
                                TmdbMovie.class);
                for(MovieDTO movieDTO : response.getResults()){
                    Movie movie = new Movie(movieDTO);
                    if(!movie.isAdult()){
                        for(Integer genre_id : movieDTO.getGenre_ids()) {
                            movie.getGenres().add(genreService.getGenreById(genre_id));
                        }
                        movieRepository.save(movie);
                        count++; i++;
                    }
                }
            } else {
                isFull = true;
            }
        }
    }

    public List<Movie> getAllMovies(){
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }
}
