package com.ffmdb.familyfriendlymdb.services;

import com.ffmdb.familyfriendlymdb.entities.Rating;
import com.ffmdb.familyfriendlymdb.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {
    @Autowired
    RatingRepository ratingRepository;

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public List<Rating> getByUserId(Integer userId) {
        List<Rating> returnRatings = new ArrayList<>();
        for (Rating rating : getAllRatings()) {
            if (rating.getUserId() == userId) {
                returnRatings.add(rating);
            }
        }
        return returnRatings;
    }

    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }
}
