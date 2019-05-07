package com.tkb.movie.adapter;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.tkb.movie.fragment.SongFragment;

import java.util.ArrayList;
import java.util.List;

public class CustomFragmentPageAdapter extends FragmentPagerAdapter{

    private static final String TAG = CustomFragmentPageAdapter.class.getSimpleName();

    private static final int FRAGMENT_COUNT = 4;

    private static List<String> fragmentList = new ArrayList<String>();


    public CustomFragmentPageAdapter(FragmentManager fm) {
        super(fm);
        if (fragmentList.size()== 0 ){

            fragmentList.add("Songs");
            fragmentList.add("Playlists");
            fragmentList.add("Albums");
            fragmentList.add("Artists");
            fragmentList.add("Tarun");
            fragmentList.add("Barun");
        }

    }

    @Override
    public Fragment getItem(int position) {
        /*switch (position){
            case 0:
                return new SongFragment();
            case 1:
                return new PlaylistFragment();
            case 2:
                return new SongFragment();
            case 3:
                return new SongFragment();
        }*/
        Fragment fragment =  new SongFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        /*switch (position){
            case 0:
                return "Songs";
            case 1:
                return "Playlists";
            case 2:
                return "Albums";
            case 3:
                return "Artists";
        }*/

        return fragmentList.get(position);
    }
}
