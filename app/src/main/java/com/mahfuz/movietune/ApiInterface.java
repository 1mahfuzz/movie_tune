package com.mahfuz.movietune;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mahfuz on 7/1/18.
 */

public interface ApiInterface {

    @GET("now_playing?api_key="+MainActivity.API_KEY)
    Call<ApiResponse> getNewReleaseData();

    @GET("top_rated?api_key="+MainActivity.API_KEY)
    Call<ApiResponse> getTopRatedData();

    @GET("upcoming?api_key="+MainActivity.API_KEY)
    Call<ApiResponse> getUpcomingData();

    @GET("{movieID}?api_key="+MainActivity.API_KEY)
    Call<SpecificData> getSpecificData(@Path("movieID") String movieId);

    @GET("{movieID}/similar?api_key="+MainActivity.API_KEY)
    Call<ApiResponse> getSimilarMovieData(@Path("movieID") String movieID);

}
