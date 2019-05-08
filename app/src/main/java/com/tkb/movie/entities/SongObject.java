package com.tkb.movie.entities;

public class SongObject {

    private String rating;
    private String movieTitle;
    private String releasedYear;
    //private String movieUrl;

    public SongObject(String movieTitle, String releasedYear, String rating) {
        this.rating = rating;
        this.releasedYear = releasedYear;
        this.movieTitle = movieTitle;
    }

    public String getRating() {
        return rating;
    }

    public String getReleasedYear() {
        return releasedYear;
    }

    public String getMovieTitle() {
        return movieTitle;
    }
}
