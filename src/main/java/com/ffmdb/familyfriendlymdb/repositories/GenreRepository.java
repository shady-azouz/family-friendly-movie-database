package com.ffmdb.familyfriendlymdb.repositories;

import com.ffmdb.familyfriendlymdb.entities.Genre;
import com.ffmdb.familyfriendlymdb.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
