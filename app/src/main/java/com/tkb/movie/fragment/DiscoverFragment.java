package com.tkb.movie.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkb.movie.R;
import com.tkb.movie.adapter.DiscoverAdapter;
import com.tkb.movie.entities.PlaylistObject;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment {


    public DiscoverFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        RecyclerView playlisRecyclerView = view.findViewById(R.id.your_play_list);
        GridLayoutManager gridLayout = new GridLayoutManager(getActivity(), 2);
        playlisRecyclerView.setLayoutManager(gridLayout);
        playlisRecyclerView.setHasFixedSize(true);

        DiscoverAdapter mAdapter = new DiscoverAdapter(getActivity(), getTestData());
        playlisRecyclerView.setAdapter(mAdapter);

        return view;
    }

    public List<PlaylistObject> getTestData() {
        List<PlaylistObject> trackList = new ArrayList<PlaylistObject>();
        trackList.add(new PlaylistObject("Falling over", "12 tracks", ""));
        trackList.add(new PlaylistObject("Falling over", "12 tracks", ""));
        trackList.add(new PlaylistObject("Falling over", "12 tracks", ""));
        trackList.add(new PlaylistObject("Falling over", "12 tracks", ""));
        trackList.add(new PlaylistObject("Falling over", "12 tracks", ""));
        trackList.add(new PlaylistObject("Falling over", "12 tracks", ""));
        trackList.add(new PlaylistObject("Falling over", "12 tracks", ""));
        trackList.add(new PlaylistObject("Falling over", "12 tracks", ""));
        return trackList;
    }
}
