package com.tkb.movie.fragment;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tkb.movie.internet.model.Movie;
import com.tkb.movie.internet.model.MovieData;
import com.tkb.movie.internet.network.ApiService;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SongViewModel extends ViewModel {

    private String TAG = SongViewModel.class.getSimpleName();
    Handler handler = new Handler(); // new handler
    private MutableLiveData<List<MovieData>> movieList;
    int i = 0;
    int position, pageNumber;
    LiveData<List<MovieData>> getMovie(int position, int pageNumber) {
        this.position = position;
        this.pageNumber = pageNumber;

        if (movieList == null) {
            movieList = new MutableLiveData<>();
            loadData();
        }
        return movieList;


    }

    /*private void callAgain(){

        handler.postDelayed(runnable, 1000*20); // 10 mins int.
    }
*/
    private Runnable runnable = () -> {

        //loadFruits();

    };

    /*private void loadFruits() {
        // do async operation to fetch users
        Handler myHandler = new Handler();
        myHandler.postDelayed(() -> {
            List<String> fruitsStringList = new ArrayList<>();
            fruitsStringList.add("Mango"+i);
            fruitsStringList.add("Apple"+i);
            fruitsStringList.add("Orange"+i);
            fruitsStringList.add("Banana"+i);
            fruitsStringList.add("Grapes"+i);
            long seed = System.nanoTime();
            Collections.shuffle(fruitsStringList, new Random(seed));

            fruitList.setValue(fruitsStringList);
            i++;
        }, 2000);





    }*/

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
                    movieList.setValue(movie.getResults());
                }/*else{
                    Toast.makeText(getContext(), "No Data!", Toast.LENGTH_LONG).show();
                }
                paginationAdapter.notifyDataSetChanged();
                loading = false;
                progressBar.setVisibility(View.INVISIBLE);*/
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