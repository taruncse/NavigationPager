package com.tkb.movie.internet.network;

import com.tkb.movie.model.Movie;
import com.tkb.movie.model.MovieDetail;
import com.tkb.movie.model.Review;
import com.tkb.movie.model.Trailer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Wim on 6/2/17.
 */

public interface ApiInterface {

    @GET(Constant.MOVIE_PATH + "/popular")
    Call<Movie> popularMovies(
            @Query("page") int page);

    @GET(Constant.MOVIE_PATH + "/{movie_id}")
    Call<MovieDetail> movieDetail(
            @Path("movie_id") int movieId);

    @GET(Constant.MOVIE_PATH + "/{movie_id}/" + Constant.VIDEOS)
    Call<Trailer> trailers(
            @Path("movie_id") int movieId);

    @GET(Constant.MOVIE_PATH + "/{movie_id}/" + Constant.REVIEWS)
    Call<Review> reviews(
            @Path("movie_id") int movieId);


    @GET(Constant.MOVIE_PATH + "/top_rated")
    Call<Movie> getTopRatedMovies(@Query("page") int page);

}
