package com.mahfuz.movietune;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahfuz on 7/1/18.
 */

public class ApiResponse {

    private List<Result> results = new ArrayList<>();

    public List<Result> getResult() {
        return results;
    }

    public void setResult(List<Result> result) {
        this.results = result;
    }

    class Result{

        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        private String poster_path;


        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }
    }
}
