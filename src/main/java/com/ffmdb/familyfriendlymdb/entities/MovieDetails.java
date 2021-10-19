package com.ffmdb.familyfriendlymdb.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class MovieDetails {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;


}
