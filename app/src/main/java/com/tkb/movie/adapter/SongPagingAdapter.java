package com.tkb.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkb.movie.R;
import com.tkb.movie.entities.SongObject;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class SongPagingAdapter extends RecyclerView.Adapter<SongViewHolder>{

    private Context context;
    private List<SongObject> allSongs;

    public SongPagingAdapter(Context context, List<SongObject> allSongs) {
        this.context = context;
        this.allSongs = allSongs;
    }
    public void addItems(List<SongObject> items) {
        this.allSongs.addAll(items);
    }
    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_list_layout, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        SongObject songs = allSongs.get(position);
        holder.songTitle.setText(songs.getSongTitle());
        holder.songAuthor.setText(songs.getSongAuthor());
    }

    @Override
    public int getItemCount() {
        return allSongs.size();
    }

}
