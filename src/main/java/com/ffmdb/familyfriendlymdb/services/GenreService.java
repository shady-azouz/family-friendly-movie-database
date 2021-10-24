package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.entities.Genre;
import com.ffmdb.familyfriendlymdb.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class GenreService {
    @Autowired
    GenreRepository genreRepository;

    @PostConstruct
    public void loadGenres() {
        RestTemplate restTemplate = new RestTemplate();
        String key = "a8bd7f3d0cff0c86e330f635ea81ce95";
        ResponseEntity<Genre[]> response =
                restTemplate.getForEntity(
                        "https://api.themoviedb.org/3/genre/movie/list"
                                + "?api_key=" + key
                                + "&language=en-US",
                        Genre[].class);
        Genre[] genres = response.getBody();
        for(Genre genre : genres){
            genreRepository.save(genre);
        }
    }

    public List<Genre> getAllGenres(){
        List<Genre> genres = new ArrayList<>();
        genreRepository.findAll().forEach(genres::add);
        return genres;
    }
}
