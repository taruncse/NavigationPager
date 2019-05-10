package com.tkb.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkb.movie.R;
import com.tkb.movie.model.MovieData;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AllMovieAdapter extends RecyclerView.Adapter<AllMovieViewHolder>{

    private Context context;
    private List<MovieData> allMovies = new ArrayList<>();

    public AllMovieAdapter(Context context) {
        this.context = context;
    }
    public void addItems(List<MovieData> items) {
        this.allMovies.addAll(items);
    }
    public void addSingleItem(MovieData item) {
        this.allMovies.add(item);
    }
    @Override
    public AllMovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_movie, parent, false);
        return new AllMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AllMovieViewHolder holder, int position) {
        MovieData songs = allMovies.get(position);
        holder.textTitle.setText(songs.getTitle());
        holder.textReleased.setText(songs.getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return allMovies.size();
    }

}
