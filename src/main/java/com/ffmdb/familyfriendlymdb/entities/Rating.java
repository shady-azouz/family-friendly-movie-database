package com.ffmdb.familyfriendlymdb.entities;

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
    private Short stars;

    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "comment")
    private String comment;

    public Rating(Short stars, Integer movieId, String comment) {
        this.stars = stars;
        this.movieId = movieId;
        this.comment = comment;
    }

    public Rating(){}

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
        return "Rating{" +
                "id=" + id +
                ", stars=" + stars +
                ", movieId=" + movieId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
