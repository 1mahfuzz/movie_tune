package com.mahfuz.movietune;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mahfuz on 7/1/18.
 */

public interface ApiInterface {

    @GET("now_playing?api_key="+MainActivity.API_KEY)
    Call<ApiResponse> getNewReleaseData();

}
