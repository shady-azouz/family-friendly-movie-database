package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.entities.Genre;
import com.ffmdb.familyfriendlymdb.entities.Movie;
import com.ffmdb.familyfriendlymdb.repositories.GenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class GenreServiceTest {

    @InjectMocks
    private GenreService genreService;
    @Mock
    private GenreRepository genreRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Get All Genres")
    void getAllGenres() {
        List<Movie> movies = Arrays.asList(
                new Movie()
        );
        List<Genre> genres = Arrays.asList(
                new Genre("Horror", movies)
        );
        when(genreRepository.findAll()).thenReturn(genres);
        assertEquals(genres, genreService.getAllGenres());
    }

    @Test
    @DisplayName("Get Genre By Id")
    void getGenreById() {
        List<Movie> movies = Arrays.asList(
                new Movie()
        );
        Genre genre = new Genre("Horror", movies);
        when(genreRepository.findById(genre.getId())).thenReturn(Optional.of(genre));
        assertEquals(genre, genreService.getGenreById(genre.getId()));
    }
}