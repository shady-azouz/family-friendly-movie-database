package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.entities.Genre;
import com.ffmdb.familyfriendlymdb.entities.Movie;
import com.ffmdb.familyfriendlymdb.repositories.MovieRepository;
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
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;
    @Mock
    private MovieRepository movieRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("get all movies")
    void getAllMovies() {
        List<Movie> movies = Arrays.asList(
                new Movie()
        );
        when(movieRepository.findAll()).thenReturn(movies);
        assertEquals(movies, movieService.getAllMovies());
    }

    @Test
    @DisplayName("get movie by id")
    void getMovieById() {
        Movie movie = new Movie();
        when(movieRepository.findById(anyInt())).thenReturn(Optional.of(movie));
        assertEquals(movie, movieService.getMovieById(1));
    }

    @Test
    @DisplayName("get movie by genre")
    void getMoviesByGenre() {
        Movie movie = new Movie();
        List<Movie> genreMovies = Arrays.asList(
                movie
        );
        Genre genre = new Genre("Horror", genreMovies);
        List<Genre> genres = Arrays.asList(
                genre
        );
        movie.setGenres(genres);
        List<Movie> movies = Arrays.asList(
                movie
        );
        when(movieRepository.findAll()).thenReturn(movies);
        assertEquals(movies, movieService.getMoviesByGenre(genre.getId()));
    }

    @Test
    @DisplayName("flag movie")
    void flagMovie() {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setFlags(0);
        when(movieRepository.findById(movie.getId())).thenReturn(Optional.of(movie));
        assertEquals(1, movieService.flagMovie(movie.getId()));
    }

    @Test
    @DisplayName("delete movie")
    void deleteMovie() {
        Movie movie = new Movie();
        when(movieRepository.findById(movie.getId())).thenReturn(Optional.of(movie));
        assertEquals("Movie Deleted Successfully", movieService.deleteMovie(movie.getId()));
    }
}