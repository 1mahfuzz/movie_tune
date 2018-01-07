package com.mahfuz.movietune;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahfuz on 7/1/18.
 */

public class ApiResponse {

    private List<Result> result = new ArrayList<>();

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    class Result{

        private int id;
        private String poster_path;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }
    }
}
