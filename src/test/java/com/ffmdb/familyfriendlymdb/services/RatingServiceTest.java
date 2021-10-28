package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.entities.Rating;
import com.ffmdb.familyfriendlymdb.repositories.RatingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class RatingServiceTest {

    @InjectMocks
    private RatingService ratingService;
    @Mock
    private RatingRepository ratingRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("get all ratings")
    void getAllRatings() {
        List<Rating> ratings = Arrays.asList(
                new Rating(8.5, 1, "no Comment", "shady.azouz@gmail.com")
        );
        when(ratingRepository.findAll()).thenReturn(ratings);
        assertEquals(ratings, ratingService.getAllRatings());
    }

    @Test
    @DisplayName("get rating by userId")
    void getByUserId() {
        Rating rating = new Rating(8.5, 1, "no Comment", "shady.azouz@gmail.com");
        List<Rating> ratings = Arrays.asList(
                rating
        );
        when(ratingRepository.findAll()).thenReturn(ratings);
        assertEquals(ratings, ratingService.getByUserId(rating.getUserId()));
    }

    @Test
    @DisplayName("Add Rating")
    void addRating() {
        Rating rating = new Rating(8.5, 1, "no Comment", "shady.azouz@gmail.com");
        assertEquals("Rating Added Successfully", ratingService.addRating(rating));
    }
}