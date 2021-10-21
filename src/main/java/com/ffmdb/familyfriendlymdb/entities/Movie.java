package com.ffmdb.familyfriendlymdb.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "votes_average")
    private Double votesAverage;

    @Column(name = "poster_path")
    private String posterPath;

    @Column(name = "language")
    private String language;

    @Column(name = "number_of_votes")
    private Integer numberOfVotes;

    @Column(name = "summary")
    private String summary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private Rating rating;

    public Movie(String name, Double votesAverage, String posterPath, String language, Integer numberOfVotes, String summary, Rating rating) {
        this.name = name;
        this.votesAverage = votesAverage;
        this.posterPath = posterPath;
        this.language = language;
        this.numberOfVotes = numberOfVotes;
        this.summary = summary;
        this.rating = rating;
    }

    public Movie() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getVotesAverage() {
        return votesAverage;
    }

    public void setVotesAverage(Double votesAverage) {
        this.votesAverage = votesAverage;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(Integer numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
