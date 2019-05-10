package com.tkb.movie.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.tkb.movie.fragment.SongFragment;

import java.util.ArrayList;
import java.util.List;

public class CustomFragmentPageAdapter extends FragmentStatePagerAdapter {

    private static List<String> fragmentList = new ArrayList<>();
    public CustomFragmentPageAdapter(FragmentManager fm, List<String> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {

        SongFragment fragment = SongFragment.newInstance(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return fragmentList.get(position);
    }
}
