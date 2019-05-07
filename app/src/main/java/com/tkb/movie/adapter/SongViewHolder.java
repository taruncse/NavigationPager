package com.tkb.movie.adapter;


import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tkb.movie.R;


public class SongViewHolder extends RecyclerView.ViewHolder{

    public TextView songTitle;
    public TextView songAuthor;
    public ImageView songImage;

    public SongViewHolder(View itemView, TextView songTitle, TextView songAuthor, ImageView songImage) {
        super(itemView);
        this.songTitle = songTitle;
        this.songAuthor = songAuthor;
        this.songImage = songImage;
    }

    public SongViewHolder(View itemView) {
        super(itemView);

        songTitle = itemView.findViewById(R.id.song_title);
        songAuthor = itemView.findViewById(R.id.song_author);
        songImage = itemView.findViewById(R.id.song_cover);
    }
}
