package com.ffmdb.familyfriendlymdb.tmdbJSON;

import com.ffmdb.familyfriendlymdb.dtos.MovieDTO;

import java.util.List;

public class TmdbMovie {
    private Integer page;
    private List<MovieDTO> results;

    public TmdbMovie(){}

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<MovieDTO> getResults() {
        return results;
    }

    public void setResults(List<MovieDTO> results) {
        this.results = results;
    }
}
