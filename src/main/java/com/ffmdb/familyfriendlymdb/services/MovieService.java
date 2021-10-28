package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.dtos.MovieDTO;
import com.ffmdb.familyfriendlymdb.entities.Genre;
import com.ffmdb.familyfriendlymdb.entities.Movie;
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
    private void loadMovies() {
        RestTemplate restTemplate = new RestTemplate();
        String key = "a8bd7f3d0cff0c86e330f635ea81ce95";
        boolean isFull = false;
        int i = 1;
        int count = 0;
        while (!isFull) {
            if (count < 100) {
                TmdbMovie response =
                        restTemplate.getForObject(
                                "https://api.themoviedb.org/3/movie/top_rated"
                                        + "?api_key=" + key
                                        + "&page=" + i
                                        + "&language=en-US",
                                TmdbMovie.class);
                for (MovieDTO movieDTO : response.getResults()) {
                    Movie movie = new Movie(movieDTO);
                    if (!movie.isAdult()) {
                        for (Integer genre_id : movieDTO.getGenre_ids()) {
                            movie.getGenres().add(genreService.getGenreById(genre_id));
                        }
                        movieRepository.save(movie);
                        count++;
                        i++;
                    }
                }
            } else {
                isFull = true;
            }
        }
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> getMoviesByGenre(Integer genreId) {
        List<Movie> returnMovies = new ArrayList<>();
        for (Movie movie : movieRepository.findAll()) {
            boolean hasGenre = false;
            for (Genre genre : movie.getGenres()) {
                if (genre.getId() == genreId) {
                    hasGenre = true;
                    break;
                }
            }
            if (hasGenre) {
                returnMovies.add(movie);
            }
        }
        return returnMovies;
    }

    public Integer flagMovie(Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if (movie != null) {
            movie.setFlags(movie.getFlags() + 1);
            movieRepository.save(movie);
            return movie.getFlags();
        }
        return 0;
    }

    public String deleteMovie(Integer movieId) {
        if (movieRepository.findById(movieId).isEmpty()) {
            return "Movie doesn't exist";
        }
        movieRepository.deleteById(movieId);
        return "Movie Deleted Successfully";
    }
}
