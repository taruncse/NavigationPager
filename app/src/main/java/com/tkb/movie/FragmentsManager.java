package com.tkb.movie;

import com.tkb.movie.fragment.LibraryFragment;
import com.tkb.movie.fragment.PlaylistFragment;

import androidx.fragment.app.Fragment;

public class FragmentsManager {

    public static Fragment getFragment (int id){
        if (id == R.id.popular_movies) {
           return new LibraryFragment();
        } else if (id == R.id.discover_movies) {
            return new PlaylistFragment();
        } else if (id == R.id.upcoming_movies) {
            return new PlaylistFragment();

        } else if (id == R.id.now_playing) {
            return new PlaylistFragment();

        }else if (id == R.id.top_rated) {
            return new PlaylistFragment();
        }
        return null;
    }
}
