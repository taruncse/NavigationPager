package com.tkb.movie.adapter;


import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tkb.movie.R;

public class PlaylistViewHolder extends RecyclerView.ViewHolder{

    public TextView playlistTitle;
    public TextView playlistTracks;
    public ImageView playlistCover;

    public PlaylistViewHolder(View itemView) {
        super(itemView);

        playlistTitle = itemView.findViewById(R.id.play_list_name);
        playlistTracks = itemView.findViewById(R.id.number_of_tracks);
        playlistCover = itemView.findViewById(R.id.play_list_cover);
    }
}
