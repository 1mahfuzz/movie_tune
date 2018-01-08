package com.mahfuz.movietune;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mahfuz on 1/8/2018.
 */

public class SpecificData {

    String title;
    @SerializedName("backdrop_path")
    String imagePath;
    String budget;
    @SerializedName("vote_average")
    int voteAvg;
    int popularity;
    List<Genres> genres = new ArrayList<>();
    @SerializedName("spoken_languages")
    List<Language> language = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public int getVoteAvg() {
        return voteAvg;
    }

    public void setVoteAvg(int voteAvg) {
        this.voteAvg = voteAvg;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public List<Language> getLanguage() {
        return language;
    }

    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    class Genres{

        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    class Language{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
