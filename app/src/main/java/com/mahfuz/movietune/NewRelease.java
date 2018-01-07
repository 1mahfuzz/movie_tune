package com.mahfuz.movietune;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewRelease extends Fragment {

    RecyclerView mRecyclerView;
    List<Integer> id;
    List<String> poster_path;


    public NewRelease() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_release, container, false);
        iniView(view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        ApiInterface apiInterface = new ApiClient().getClient().create(ApiInterface.class);
        Call<ApiResponse> call = apiInterface.getNewReleaseData();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                ApiResponse apiResponse = response.body();
                for (int i=0; i<apiResponse.getResult().size(); i++){
                    int list_id = apiResponse.getResult().get(i).getId();
                    String path = "http://image.tmdb.org/t/p/w500/"
                            +apiResponse.getResult().get(i).getPoster_path()
                            +"?api_key="+MainActivity.API_KEY;
                    id.add(list_id);
                    poster_path.add(path);
                }
                mRecyclerView.setAdapter(new RecyclerAdapter(getContext(),id,poster_path));
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d(MainActivity.TAG, "onFailure: ");
            }
        });

        return view;
    }

    private void iniView(View view) {

        mRecyclerView = view.findViewById(R.id.recyclerView);
    }

}
