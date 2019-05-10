package com.tkb.movie.internet.network;


import com.tkb.movie.BuildConfig;

import java.util.ArrayList;

/**
 * Created by Wim on 5/29/17.
 */

public class Constant {

    public static final String BASE_URL = BuildConfig.BASE_URL;
    public static final String IMG_URL = BuildConfig.IMG_URL;
    public static final String API_KEY = BuildConfig.MOVIE_API_KEY;
    public static final String VERSION = "/3";
    public static final String MOVIE = "/movie";
    public static final String VIDEOS = "videos";
    public static final String REVIEWS = "reviews";
    public static final String LANG_EN = "en-US";

    public static final String MOVIE_PATH = VERSION + MOVIE;


    public static ArrayList<String> getFragments(){

        ArrayList<String> fragmentList = new ArrayList<>();
        fragmentList.add("Action");
        fragmentList.add("Adventure");
        fragmentList.add("Animation");
        fragmentList.add("Crime");
        fragmentList.add("Documentary");
        fragmentList.add("Drama");
        fragmentList.add("Family");
        fragmentList.add("Fantasy");
        fragmentList.add("Horror");
        fragmentList.add("Music");
        fragmentList.add("Mystery");
        fragmentList.add("Romance");
        fragmentList.add("Science Fiction");
        fragmentList.add("TV Movie");
        fragmentList.add("War");
        fragmentList.add("Western");

        return fragmentList;
    }

}
