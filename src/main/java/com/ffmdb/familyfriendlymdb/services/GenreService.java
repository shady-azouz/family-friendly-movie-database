package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.entities.Genre;
import com.ffmdb.familyfriendlymdb.repositories.GenreRepository;
import com.ffmdb.familyfriendlymdb.tmdbJSON.TmdbGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {
    @Autowired
    GenreRepository genreRepository;

    @PostConstruct
    public void loadGenres() {
        System.out.println("Entered into loadGenres()");
        RestTemplate restTemplate = new RestTemplate();
        String key = "a8bd7f3d0cff0c86e330f635ea81ce95";
        TmdbGenre response =
                restTemplate.getForObject(
                        "https://api.themoviedb.org/3/genre/movie/list"
                                + "?api_key=" + key
                                + "&language=en-US",
                        TmdbGenre.class);
        for(Genre genre : response.getGenres()){
            genreRepository.save(genre);
        }
    }

    public List<Genre> getAllGenres(){
        List<Genre> genres = new ArrayList<>();
        genreRepository.findAll().forEach(genres::add);
        return genres;
    }

    public Genre getGenreById(Integer id){
        return genreRepository.findById(id).orElse(null);
    }
}