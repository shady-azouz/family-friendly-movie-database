package com.ffmdb.familyfriendlymdb.dtos;

import com.ffmdb.familyfriendlymdb.entities.Rating;

public class RatingDTO {
    private Double stars;
    private Integer movieId;
    private String comment;
    private Integer userId;

    public RatingDTO(Double stars, Integer movieId, String comment, Integer userId) {
        this.stars = stars;
        this.movieId = movieId;
        this.comment = comment;
        this.userId = userId;
    }

    public RatingDTO(Rating rating) {
        this.stars = rating.getStars();
        this.movieId = rating.getMovieId();
        this.comment = rating.getComment();
    }

    public RatingDTO() {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RatingDTO{" +
                "stars=" + stars +
                ", movieId=" + movieId +
                ", comment='" + comment + '\'' +
                ", userId=" + userId +
                '}';
    }
}
