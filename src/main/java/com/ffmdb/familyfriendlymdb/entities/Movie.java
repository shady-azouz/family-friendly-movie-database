package com.ffmdb.familyfriendlymdb.entities;

import javax.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "votes_average")
    private Double votesAverage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private Rating rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_details_id", referencedColumnName = "id")
    private MovieDetails movieDetails;
}
