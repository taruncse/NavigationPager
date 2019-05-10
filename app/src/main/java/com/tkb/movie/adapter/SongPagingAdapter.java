package com.tkb.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkb.movie.R;
import com.tkb.movie.entities.SongObject;
import com.tkb.movie.internet.model.MovieData;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class SongPagingAdapter extends RecyclerView.Adapter<SongViewHolder>{

    private Context context;
    private List<MovieData> allSongs;

    public SongPagingAdapter(Context context, List<MovieData> allSongs) {
        this.context = context;
        this.allSongs = allSongs;
    }
    public void addItems(List<MovieData> items) {
        this.allSongs.addAll(items);
    }
    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_movie, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        MovieData songs = allSongs.get(position);
        holder.textTitle.setText(songs.getTitle());
        holder.textReleased.setText(songs.getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return allSongs.size();
    }

}
