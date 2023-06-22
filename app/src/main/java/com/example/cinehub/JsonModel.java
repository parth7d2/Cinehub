package com.example.cinehub;

import java.util.ArrayList;

public class JsonModel {
    ArrayList<MovieModel> results;

    public JsonModel(ArrayList<MovieModel> results) {
        this.results = results;
    }

    public ArrayList<MovieModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<MovieModel> results) {
        this.results = results;
    }

}
