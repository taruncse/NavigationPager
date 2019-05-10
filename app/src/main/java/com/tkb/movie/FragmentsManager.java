package com.tkb.movie;

import com.tkb.movie.fragment.PopularMovieFragment;
import com.tkb.movie.fragment.DiscoverFragment;

import androidx.fragment.app.Fragment;

public class FragmentsManager {

    public static Fragment getFragment (int id){
        if (id == R.id.popular_movies) {
           return new PopularMovieFragment();
        } else if (id == R.id.discover_movies) {
            return new DiscoverFragment();
        } else if (id == R.id.upcoming_movies) {
            return new DiscoverFragment();

        } else if (id == R.id.now_playing) {
            return new DiscoverFragment();

        }else if (id == R.id.top_rated) {
            return new DiscoverFragment();
        }
        return null;
    }
}
