package com.ffmdb.familyfriendlymdb.dtos;

import com.ffmdb.familyfriendlymdb.entities.Rating;

public class RatingDTO {
    private Integer id;
    private Short stars;
    private Integer movieId;
    private String comment;

    public RatingDTO(Integer id, Short stars, Integer movieId, String comment) {
        this.id = id;
        this.stars = stars;
        this.movieId = movieId;
        this.comment = comment;
    }

    public RatingDTO(Rating rating) {
        this.id = rating.getId();
        this.stars = rating.getStars();
        this.movieId = rating.getMovieId();
        this.comment = rating.getComment();
    }

    public RatingDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getStars() {
        return stars;
    }

    public void setStars(Short stars) {
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

    @Override
    public String toString() {
        return "RatingDTO{" +
                "id=" + id +
                ", stars=" + stars +
                ", movieId=" + movieId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
