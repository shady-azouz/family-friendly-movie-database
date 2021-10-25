package com.ffmdb.familyfriendlymdb.tmdbJSON;

import com.ffmdb.familyfriendlymdb.entities.Movie;

import java.util.List;

public class TmdbMovie {
    private Integer page;
    private List<Movie> results;

    public TmdbMovie(){}

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
