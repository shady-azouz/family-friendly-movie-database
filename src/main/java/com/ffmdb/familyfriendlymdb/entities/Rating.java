package com.ffmdb.familyfriendlymdb.entities;

import javax.persistence.Id;

public class Rating {
    @Id
    private Integer id;
    private Short stars;
    private Integer movieId;
    private String comment;
}
