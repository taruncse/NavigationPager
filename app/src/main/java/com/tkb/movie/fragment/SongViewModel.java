package com.tkb.movie.fragment;

import com.tkb.movie.entities.SongObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Flowable;

public class SongViewModel extends ViewModel {
    private MutableLiveData<List<SongObject>> users;
    public LiveData<List<SongObject>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<List<SongObject>>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {

    }

    private Flowable<List<SongObject>> dataFromNetwork(final int page) {
        return Flowable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .map(value -> {
                    List<SongObject> recentSongs = new ArrayList<SongObject>();
                    //List<String> items = new ArrayList<>();
                    for (int i = 1; i <= 10; i++) {
                        //items.add("Item " + (page * 10 + i));
                        recentSongs.add(new SongObject("Adele"+(page * 10 + i), "Someone Like You", ""));

                    }
                    return recentSongs;
                });
    }
}