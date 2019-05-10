package com.tkb.movie.fragment;

import android.os.Handler;
import android.util.Log;

import com.tkb.movie.model.Movie;
import com.tkb.movie.model.MovieData;
import com.tkb.movie.internet.network.ApiService;

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongViewModel extends ViewModel {

    private String TAG = SongViewModel.class.getSimpleName();
    Handler handler = new Handler(); // new handler

    private MutableLiveData<HashMap<Integer,List<MovieData>>> movieList;
    HashMap<Integer,List<MovieData>> singleData = new HashMap<>();
    int i = 0;
    int position, pageNumber;
    LiveData<HashMap<Integer,List<MovieData>>> getMovie(int position, int pageNumber) {
        this.position = position;
        this.pageNumber = pageNumber;

        Log.d(TAG,position+"");
        if (movieList == null) {
            movieList = new MutableLiveData<>();
            loadData();
        }
        return movieList;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "on cleared called");
    }


    private void loadData(){


     ApiService apiService = new ApiService(position);
        apiService.getData(pageNumber, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Movie movie = (Movie) response.body();

                if(movie != null) {
                    singleData.put(position,movie.getResults());
                    movieList.setValue(singleData);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                if(t instanceof SocketTimeoutException) {
                    //Toast.makeText(getContext(), "Request Timeout. Please try again!", Toast.LENGTH_LONG).show();
                }else{
                    //Toast.makeText(getContext(), "Connection Error!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}