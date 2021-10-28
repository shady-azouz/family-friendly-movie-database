package com.ffmdb.familyfriendlymdb.controllers;

import com.ffmdb.familyfriendlymdb.dtos.RatingDTO;
import com.ffmdb.familyfriendlymdb.entities.Genre;
import com.ffmdb.familyfriendlymdb.entities.Movie;
import com.ffmdb.familyfriendlymdb.entities.Rating;
import com.ffmdb.familyfriendlymdb.entities.User;
import com.ffmdb.familyfriendlymdb.services.MovieService;
import com.ffmdb.familyfriendlymdb.services.RatingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class MovieControllerTest {

    @InjectMocks
    private MovieController movieController;
    @Mock
    private MovieService movieService;
    @Mock
    private RatingService ratingService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("get top movies")
    void getTopMovies() {
        List<Movie> movies = Arrays.asList(
                new Movie()
        );
        when(movieService.getAllMovies()).thenReturn(movies);
        assertEquals(movies, movieController.getTopMovies());
    }

    @Test
    @DisplayName("get recommended movies")
    @Disabled
    void getRecommendedMovies() {
        Genre genre = new Genre();
        User user = new User();
        Rating rating = new Rating();
        Movie movie = new Movie();
        rating.setMovieId(movie.getId());
        rating.setStars(8.0);
        rating.setUserId(user.getEmail());
        List<Rating> ratings = Arrays.asList(
                rating
        );
        when(ratingService.getByUserId(anyString())).thenReturn(ratings);
        movie.setGenres(Arrays.asList(genre));
        List<Movie> movies = Arrays.asList(movie);
        when(movieService.getMovieById(anyInt())).thenReturn(movie);
        when(movieService.getMoviesByGenre(anyInt())).thenReturn(movies);
        assertEquals(movies, movieController.getRecommendedMovies(user.getEmail()));
    }

    @Test
    @DisplayName("delete movie")
    void deleteMovie() {
        String testString = "Movie Deleted Successfully";
        when(movieService.deleteMovie(anyInt())).thenReturn(testString);
        assertEquals(testString, movieController.deleteMovie(1));
    }

    @Test
    @DisplayName("add flag to movie")
    void addFlagToMovie() {
        when(movieService.flagMovie(1)).thenReturn(1);
        assertEquals("Movie Flag Added", movieController.addFlagToMovie(1));
        when(movieService.flagMovie(1)).thenReturn(10);
        assertEquals("Movie Has Been Deleted; contains more than 10 flags", movieController.addFlagToMovie(1));
        when(movieService.flagMovie(1)).thenReturn(0);
        assertEquals("Invalid Movie ID", movieController.addFlagToMovie(1));
    }

    @Test
    @DisplayName("add rating")
    void addRating() {
        Movie movie = new Movie();
        RatingDTO ratingDTO = new RatingDTO();
        ratingDTO.setMovieId(movie.getId());
        ratingDTO.setStars(7.0);
        movie.setRatings(new ArrayList<>());
        movie.setNumberOfVotes(5);
        movie.setVoteAverage(6.5);
        when(movieService.getMovieById(movie.getId())).thenReturn(movie);
        assertEquals("Rating Added Successfully", movieController.addRating(ratingDTO));
    }
}