package com.tkb.movie.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.processors.PublishProcessor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tkb.movie.R;
import com.tkb.movie.adapter.SongPagingAdapter;
import com.tkb.movie.entities.SongObject;
import com.tkb.movie.internet.model.Movie;
import com.tkb.movie.internet.model.MovieData;
import com.tkb.movie.internet.network.ApiService;
import com.tkb.movie.utilities.TabFactory;

import org.reactivestreams.Publisher;

import java.net.SocketTimeoutException;
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
    private ApiService apiService;
    private int page = 1;
    private int limit = 20;

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

                    progressBar.setVisibility(View.VISIBLE);
                    loadData();
                }
            }
        });
    }
    private void subscribeForData() {

      /*  Disposable disposable = paginator
                .onBackpressureDrop()
                .concatMap((Function<Integer, Publisher<List<MovieData>>>) page -> {
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

        compositeDisposable.add(disposable);*/
        loading = true;
        progressBar.setVisibility(View.VISIBLE);
        paginator.onNext(pageNumber);

        loadData();
    }

    /**
     * Simulation of network data
     */
   /* private Flowable<List<MovieData>> dataFromNetwork(final int page) {
        return Flowable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .map(value -> {
                    List<MovieData> movieList = new ArrayList<>();
                    List<String> items = new ArrayList<>();
                    for (int i = 1; i <= 10; i++) {
                        MovieData movieData = new MovieData();
                        movieData.setTitle("New"+i);
                        movieData.setReleaseDate("10-10-10"+i);
                        movieList.add(movieData);

                    }
                   // loadData();
                    return movieList;
                });
    }*/

    private void laod(){


        apiService = new ApiService(position);
        apiService.getData(pageNumber, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Movie movie = (Movie) response.body();

                if(movie != null) {
                    if(paginationAdapter != null) {
                        paginationAdapter.addItems(movie.getResults());
                    }
                }else{
                    Toast.makeText(getContext(), "No Data!", Toast.LENGTH_LONG).show();
                }
                paginationAdapter.notifyDataSetChanged();
                loading = false;
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                if(t instanceof SocketTimeoutException) {
                    Toast.makeText(getContext(), "Request Timeout. Please try again!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(), "Connection Error!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private void loadData(){
        SongViewModel model = ViewModelProviders.of(this).get(SongViewModel.class);
        model.getMovie(position,pageNumber).observe(this, movieList -> {

            paginationAdapter.addItems(movieList);

            paginationAdapter.notifyDataSetChanged();
            loading = false;
            progressBar.setVisibility(View.INVISIBLE);
        });
    }
}
