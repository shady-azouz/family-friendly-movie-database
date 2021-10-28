package com.ffmdb.familyfriendlymdb.entities;

import com.ffmdb.familyfriendlymdb.dtos.RatingDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rating")
public class Rating implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "stars")
    private Double stars;

    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "user_id")
    private String userId;

    public Rating(Double stars, Integer movieId, String comment, String userId) {
        this.stars = stars;
        this.movieId = movieId;
        this.comment = comment;
        this.userId = userId;
    }

    public Rating(RatingDTO ratingDTO) {
        this.stars = ratingDTO.getStars();
        this.movieId = ratingDTO.getMovieId();
        this.comment = ratingDTO.getComment();
        this.userId = ratingDTO.getUserId();
    }

    public Rating() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", stars=" + stars +
                ", movieId=" + movieId +
                ", comment='" + comment + '\'' +
                ", userId=" + userId +
                '}';
    }
}
