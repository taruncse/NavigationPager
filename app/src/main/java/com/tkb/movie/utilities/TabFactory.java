package com.tkb.movie.utilities;

import com.tkb.movie.entities.SongObject;
import com.tkb.movie.internet.model.MovieData;

import java.util.ArrayList;
import java.util.List;

public class TabFactory {

    public static List<MovieData>getTabItems(int position){
        /*switch (position){
            case 0 :
                return getTestData();
            case 1 :
                return getTestData2();
            case 2 :
                return getTestData3();
            default:
                return getTestData1();
        }*/
       return new ArrayList<>();
    }
    private static List<MovieData> getTestData() {
        List<MovieData> recentMovie = new ArrayList<>();
        for (int i = 0 ; i<20; i++){
            MovieData movieData = new MovieData();
            movieData.setTitle("Mala "+i);
            movieData.setReleaseDate("20-11-201"+i);
            recentMovie.add(movieData);
        }

        return recentMovie;
    }

    private static List<MovieData> getTestData1() {
        List<MovieData> recentMovie = new ArrayList<>();
        for (int i = 0 ; i<20; i++){
            MovieData movieData = new MovieData();
            movieData.setTitle("Kiron "+i);
            movieData.setReleaseDate("20-11-201"+i);
            recentMovie.add(movieData);
        }

        return recentMovie;
    }
    private static List<MovieData> getTestData2() {
        List<MovieData> recentMovie = new ArrayList<>();
        for (int i = 0 ; i<20; i++){
            MovieData movieData = new MovieData();
            movieData.setTitle("Barun "+i);
            movieData.setReleaseDate("20-11-201"+i);
            recentMovie.add(movieData);
        }

        return recentMovie;
    }
    private static List<MovieData> getTestData3() {
        List<MovieData> recentMovie = new ArrayList<>();
        for (int i = 0 ; i<20; i++){
            MovieData movieData = new MovieData();
            movieData.setTitle("Tarun "+i);
            movieData.setReleaseDate("20-11-201"+i);
            recentMovie.add(movieData);
        }

        return recentMovie;
    }
}
