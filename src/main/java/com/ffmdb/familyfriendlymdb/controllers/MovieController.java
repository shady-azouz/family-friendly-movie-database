package com.ffmdb.familyfriendlymdb.controllers;

import com.ffmdb.familyfriendlymdb.dtos.RatingDTO;
import com.ffmdb.familyfriendlymdb.entities.Genre;
import com.ffmdb.familyfriendlymdb.entities.Movie;
import com.ffmdb.familyfriendlymdb.entities.Rating;
import com.ffmdb.familyfriendlymdb.services.MovieService;
import com.ffmdb.familyfriendlymdb.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private RatingService ratingService;

    @RequestMapping(value = "/topMovies", method = RequestMethod.GET)
    public List<Movie> getTopMovies() {
        return movieService.getAllMovies();
    }

    @RequestMapping(value = "/getRecommendations/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Set<Movie> getRecommendedMovies(@PathVariable("id") String userId) {
        List<Rating> ratings = ratingService.getByUserId(userId);
        Set<Movie> likedMovies = new HashSet<>();
        Set<Genre> likedGenres = new HashSet<>();
        for (Rating rating : ratings) {
            if (rating.getStars() > 7.0) {
                Movie movie = movieService.getMovieById(rating.getMovieId());
                likedMovies.add(movie);
                for (Genre genre : movie.getGenres()) {
                    likedGenres.add(genre);
                }
            }
        }
        for (Genre genre : likedGenres) {
            List<Movie> genreMovies = movieService.getMoviesByGenre(genre.getId());
            for (Movie movie : genreMovies) {
                likedMovies.add(movie);
            }
        }
        return likedMovies;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteMovie/{id}")
    @ResponseBody
    public String deleteMovie(@PathVariable("id") Integer movie_id) {
        return movieService.deleteMovie(movie_id);
    }

    @RequestMapping(value = "/addFlag/{id}")
    @ResponseBody
    public String addFlagToMovie(@PathVariable("id") Integer movieId) {
        int flags = movieService.flagMovie(movieId);
        if (flags >= 10) {
            deleteMovie(movieId);
            return "Movie Has Been Deleted; contains more than 10 flags";
        }
        if (flags > 0) {
            return "Movie Flag Added";
        }
        return "Invalid Movie ID";
    }

    @PostMapping("/addRating")
    @ResponseBody
    public String addRating(@RequestBody RatingDTO ratingDTO) {
        Rating rating = new Rating(ratingDTO);
        Movie movie = movieService.getMovieById(rating.getMovieId());
        if (movie != null) {
            movie.getRatings().add(rating);
            Double voteAverage = movie.getVoteAverage();
            int numOfVotes = movie.getNumberOfVotes();
            Double newAverage = (voteAverage * numOfVotes + rating.getStars()) / (numOfVotes + 1);
            movie.setVoteAverage(newAverage);
            movie.setNumberOfVotes(numOfVotes + 1);
            ratingService.addRating(rating);
            return "Rating Added Successfully";
        }
        return "Invalid Movie ID!";
    }
}
