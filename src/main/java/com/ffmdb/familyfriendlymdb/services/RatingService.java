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

    public List<Rating> getAllRatings(){
        List<Rating> ratings = new ArrayList<>();
        ratingRepository.findAll().forEach(ratings::add);
        return ratings;
    }

    public void addRating(Rating rating){
        ratingRepository.save(rating);
    }
}
