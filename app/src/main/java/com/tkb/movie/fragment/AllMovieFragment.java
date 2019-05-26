package com.tkb.movie.fragment;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.processors.PublishProcessor;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.tkb.movie.R;
import com.tkb.movie.adapter.AllMovieAdapter;

import java.util.HashMap;

public class AllMovieFragment extends Fragment {
    private PublishProcessor<Integer> paginator = PublishProcessor.create();
    private boolean loading = false;
    private ProgressBar progressBar;
    AllMovieAdapter paginationAdapter;
    private int pageNumber = 1;
    private int lastVisibleItem, totalItemCount;
    private GridLayoutManager gridLayoutManager;
    private final int VISIBLE_THRESHOLD = 1;
    AllMovieViewModel model;
    RecyclerView songRecyclerView;
    int position;

    private static HashMap<Integer,AllMovieFragment> fragmentHashMap = new HashMap<>();

    public AllMovieFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_movie, container, false);

        progressBar = view.findViewById(R.id.progressBar);


       // getActivity().setTitle(Constant.getFragments().get(position));
        songRecyclerView = view.findViewById(R.id.song_list);
        gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        songRecyclerView.setLayoutManager(gridLayoutManager);
        songRecyclerView.setHasFixedSize(true);

        return view;
    }

    public static AllMovieFragment newInstance(int num) {

        if (fragmentHashMap.get(num) != null){
            return fragmentHashMap.get(num);
        }else {
            AllMovieFragment f = new AllMovieFragment();

            // Supply num input as an argument.
            Bundle args = new Bundle();
            args.putInt("position", num);
            f.setArguments(args);
            fragmentHashMap.put(num,f);
            return f;
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments() != null ? getArguments().getInt("position") : 1;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        paginationAdapter = new AllMovieAdapter(getActivity());
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
        loading = true;
        progressBar.setVisibility(View.VISIBLE);
        paginator.onNext(pageNumber);

        loadData();
    }

    private void loadData(){
        model = ViewModelProviders.of(this).get(AllMovieViewModel.class);
        model.getMovie(position,pageNumber).observe(this, movieList -> {

            paginationAdapter.addItems(movieList.get(position));

            paginationAdapter.notifyDataSetChanged();
            loading = false;
            progressBar.setVisibility(View.INVISIBLE);
        });
    }
}
