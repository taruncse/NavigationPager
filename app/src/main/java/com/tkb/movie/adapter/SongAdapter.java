package com.tkb.movie.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkb.movie.R;
import com.tkb.movie.entities.SongObject;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongViewHolder>{

    private Context context;
    private List<SongObject> allSongs;

    public SongAdapter(Context context, List<SongObject> allSongs) {
        this.context = context;
        this.allSongs = allSongs;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_list_layout, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        SongObject songs = allSongs.get(position);
        holder.textTitle.setText(songs.getMovieTitle());
        holder.textReleased.setText(songs.getReleasedYear());
    }

    @Override
    public int getItemCount() {
        return allSongs.size();
    }

}
