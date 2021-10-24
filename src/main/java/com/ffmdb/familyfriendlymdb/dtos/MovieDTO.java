package com.ffmdb.familyfriendlymdb.dtos;

import com.ffmdb.familyfriendlymdb.entities.Movie;
import com.ffmdb.familyfriendlymdb.entities.Rating;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class MovieDTO {
    private Integer id;
    private String name;
    private Double votesAverage;
    private String posterPath;
    private String language;
    private Integer numberOfVotes;
    private String summary;
    private Short averageRating;

    public MovieDTO(Integer id, String name, Double votesAverage, String posterPath, String language, Integer numberOfVotes, String summary, Short averageRating) {
        this.id = id;
        this.name = name;
        this.votesAverage = votesAverage;
        this.posterPath = posterPath;
        this.language = language;
        this.numberOfVotes = numberOfVotes;
        this.summary = summary;
        this.averageRating = averageRating;
    }

    public MovieDTO(Movie movie){
        this.id = movie.getId();
        this.name = movie.getName();
        this.votesAverage = movie.getVotesAverage();
        this.posterPath = movie.getPosterPath();
        this.language = movie.getLanguage();
        this.numberOfVotes = movie.getNumberOfVotes();
        this.summary = movie.getSummary();
        this.averageRating = movie.getAverageRating();
    }

    public MovieDTO() {}

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

    public Short getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Short averageRating) {
        this.averageRating = averageRating;
    }
}
