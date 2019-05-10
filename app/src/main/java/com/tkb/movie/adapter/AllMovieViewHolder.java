package com.tkb.movie.adapter;


import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tkb.movie.R;


public class AllMovieViewHolder extends RecyclerView.ViewHolder{

    public TextView textTitle;
    public TextView textReleased;
    public TextView textRating;
    public ImageView movieThum;

    public AllMovieViewHolder(View itemView, TextView textTitle, TextView textReleased, ImageView movieThum, TextView textRating) {
        super(itemView);
        this.textTitle = textTitle;
        this.textReleased = textReleased;
        this.movieThum = movieThum;
        this.textRating = textRating;
    }

    public AllMovieViewHolder(View itemView) {
        super(itemView);

        textTitle = itemView.findViewById(R.id.txt_title);
        textReleased = itemView.findViewById(R.id.txt_released);
        movieThum = itemView.findViewById(R.id.img_thumnail);
        textRating = itemView.findViewById(R.id.txt_rating);
    }
}
