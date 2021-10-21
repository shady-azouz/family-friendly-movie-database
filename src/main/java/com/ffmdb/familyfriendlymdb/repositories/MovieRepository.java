package com.ffmdb.familyfriendlymdb.repositories;

import com.ffmdb.familyfriendlymdb.entities.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
