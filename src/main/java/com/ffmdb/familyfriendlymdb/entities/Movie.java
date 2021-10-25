package com.ffmdb.familyfriendlymdb.entities;

import javax.persistence.*;
import java.io.Serializable;
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

    @Column(name = "average_rating")
    private Short averageRating;

    @OneToMany(targetEntity = Rating.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private List<Rating> ratings;

    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Genre> genres;

    public Movie(String name, Double votesAverage, String posterPath, String language, Integer numberOfVotes, String summary, Short averageRating, List<Rating> ratings, List<Genre> genres) {
        this.name = name;
        this.votesAverage = votesAverage;
        this.posterPath = posterPath;
        this.language = language;
        this.numberOfVotes = numberOfVotes;
        this.summary = summary;
        this.averageRating = averageRating;
        this.ratings = ratings;
        this.genres = genres;
    }

    public Movie(){}

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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", votesAverage=" + votesAverage +
                ", posterPath='" + posterPath + '\'' +
                ", language='" + language + '\'' +
                ", numberOfVotes=" + numberOfVotes +
                ", summary='" + summary + '\'' +
                ", averageRating=" + averageRating +
                ", ratings=" + ratings +
                ", genres=" + genres +
                '}';
    }
}
