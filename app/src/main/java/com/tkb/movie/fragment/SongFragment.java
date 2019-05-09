package com.tkb.movie.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.processors.PublishProcessor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.tkb.movie.R;
import com.tkb.movie.adapter.SongPagingAdapter;
import com.tkb.movie.entities.SongObject;
import com.tkb.movie.utilities.TabFactory;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SongFragment extends Fragment {
    private PublishProcessor<Integer> paginator = PublishProcessor.create();
    private boolean loading = false;
    private ProgressBar progressBar;
    SongPagingAdapter paginationAdapter;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private int pageNumber = 1;
    private int lastVisibleItem, totalItemCount;
    private GridLayoutManager gridLayoutManager;
    private final int VISIBLE_THRESHOLD = 1;

    RecyclerView songRecyclerView;
    int position;
    public SongFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song, container, false);

        progressBar = view.findViewById(R.id.progressBar);


        getActivity().setTitle("Songs"+position);
        songRecyclerView = view.findViewById(R.id.song_list);
        gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        songRecyclerView.setLayoutManager(gridLayoutManager);
        songRecyclerView.setHasFixedSize(true);


      /*  int position = getArguments().getInt("position");

        paginationAdapter = new SongPagingAdapter(getActivity(), TabFactory.getTabItems(position));
        songRecyclerView.setAdapter(paginationAdapter);
        setUpLoadMoreListener();
        subscribeForData();*/
        return view;
    }

    /**
     * Create a new instance of CountingFragment, providing "num"
     * as an argument.
     */
    public static SongFragment newInstance(int num) {
        SongFragment f = new SongFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("position", num);
        f.setArguments(args);

        return f;
    }
    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments() != null ? getArguments().getInt("position") : 1;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       /* setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, Cheeses.sCheeseStrings));*/
        //int position = getArguments().getInt("position");

        paginationAdapter = new SongPagingAdapter(getActivity(), TabFactory.getTabItems(position));
        songRecyclerView.setAdapter(paginationAdapter);
        setUpLoadMoreListener();
        subscribeForData();
    }



    private void setUpLoadMoreListener() {
        songRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView,
                                   int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount = gridLayoutManager.getItemCount();
                lastVisibleItem = gridLayoutManager
                        .findLastVisibleItemPosition();
                if (!loading
                        && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {
                    pageNumber++;
                    paginator.onNext(pageNumber);
                    loading = true;
                }
            }
        });
    }
    private void subscribeForData() {

        Disposable disposable = paginator
                .onBackpressureDrop()
                .concatMap((Function<Integer, Publisher<List<SongObject>>>) page -> {
                    loading = true;
                    progressBar.setVisibility(View.VISIBLE);
                    return dataFromNetwork(page);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(items -> {
                    paginationAdapter.addItems(items);
                    paginationAdapter.notifyDataSetChanged();
                    loading = false;
                    progressBar.setVisibility(View.INVISIBLE);
                });

        compositeDisposable.add(disposable);

        paginator.onNext(pageNumber);

    }

    /**
     * Simulation of network data
     */
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
