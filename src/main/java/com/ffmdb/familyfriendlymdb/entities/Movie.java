package com.ffmdb.familyfriendlymdb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ffmdb.familyfriendlymdb.dtos.MovieDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "vote_average")
    private Double voteAverage;

    @Column(name = "poster_path")
    private String posterPath;

    @Column(name = "language")
    private String language;

    @Column(name = "number_of_votes")
    private Integer numberOfVotes;

    @Column(name = "summary", columnDefinition = "TEXT")
    private String summary;

    @Column(name = "adult")
    private boolean adult;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "flags")
    private Integer flags;

    @OneToMany(targetEntity = Rating.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private List<Rating> ratings;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Genre> genres;

    public Movie(MovieDTO movieDTO) {
        this.name = movieDTO.getTitle();
        this.voteAverage = movieDTO.getVote_average();
        this.posterPath = movieDTO.getPoster_path();
        this.language = movieDTO.getOriginal_language();
        this.numberOfVotes = movieDTO.getVote_count();
        this.summary = movieDTO.getOverview();
        this.adult = movieDTO.isAdult();
        this.releaseDate = movieDTO.getRelease_date();
        this.flags = 0;
        this.genres = new ArrayList<>();
    }

    public Movie() {
    }

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

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
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

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }
}
