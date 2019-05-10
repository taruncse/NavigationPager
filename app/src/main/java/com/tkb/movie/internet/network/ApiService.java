package com.tkb.movie.internet.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Wim on 6/2/17.
 */

public class ApiService {

    private ApiInterface apiInterface;

    int position;
    public ApiService(int position){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(builder())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.position = position;
        apiInterface = retrofit.create(ApiInterface.class);
    }

    private OkHttpClient builder() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();
        okHttpClient.connectTimeout(20, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(20, TimeUnit.SECONDS);
        okHttpClient.readTimeout(90, TimeUnit.SECONDS);

        okHttpClient.addInterceptor(interceptor());


        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url()
                        .newBuilder()
                        .addQueryParameter("api_key", Constant.API_KEY)
                        .addQueryParameter("language", Constant.LANG_EN)
                        .build();

                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        });

        return okHttpClient.build();
    }
    private static HttpLoggingInterceptor interceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }

    public void getData(int page, Callback callback){
        switch (position){
            case 0:
                getPopularMovies(page, callback);
               break;
            case 1:
                getTopRatedMovies(page,callback);
                break;
            case 2:
                getTopRatedMovies(page,callback);
                break;
            default:
                getPopularMovies(page, callback);

        }
    }
    public void getPopularMovies(int page, Callback callback) {
        apiInterface.popularMovies(page).enqueue(callback);
    }

    public void getTopRatedMovies(int page, Callback callback) {
        apiInterface.getTopRatedMovies(page).enqueue(callback);
    }


    public void getMovieDetail(int movieId, Callback callback) {
        apiInterface.movieDetail(movieId).enqueue(callback);
    }

    public void getTrailers(int movieId, Callback callback) {
        apiInterface.trailers(movieId).enqueue(callback);
    }

    public void getReviews(int movieId, Callback callback) {
        apiInterface.reviews(movieId).enqueue(callback);
    }
}
