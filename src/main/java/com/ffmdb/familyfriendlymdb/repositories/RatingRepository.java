package com.ffmdb.familyfriendlymdb.repositories;

import com.ffmdb.familyfriendlymdb.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
