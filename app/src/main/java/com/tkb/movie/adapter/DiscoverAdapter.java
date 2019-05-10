package com.tkb.movie.adapter;


import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkb.movie.R;
import com.tkb.movie.entities.PlaylistObject;

import java.util.List;

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverViewHolder>{

    private static final String TAG = DiscoverAdapter.class.getSimpleName();

    private Context context;
    private List<PlaylistObject> playlists;

    public DiscoverAdapter(Context context, List<PlaylistObject> playlists) {
        this.context = context;
        this.playlists = playlists;
    }

    @Override
    public DiscoverViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_discover, parent, false);
        return new DiscoverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DiscoverViewHolder holder, int position) {
        PlaylistObject playlistObject = playlists.get(position);
        holder.playlistTitle.setText(playlistObject.getPlaylistTitle());
        holder.playlistTracks.setText(playlistObject.getPlaylistTracks());

    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }
}
