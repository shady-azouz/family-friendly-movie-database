package com.ffmdb.familyfriendlymdb.tmdbJSON;

import com.ffmdb.familyfriendlymdb.entities.Genre;

import java.util.List;

public class TmdbGenre {
    private List<Genre> genres;

    public TmdbGenre(){}

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
