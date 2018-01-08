package com.mahfuz.movietune;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    ImageView mImageView;
    TextView mTitleView,
            mGenresView,
            mVoteAvgView,
            mPopularityView,
            mDescriptionView,
            mProductionCompany,
            mProductionCountry,
            mBudgetView,
            mLanguage;
    RecyclerView mRecyclerView;

    List<String> genresList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();
        iniView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        String movieId = getIntent().getStringExtra("id");
        Log.d(MainActivity.TAG, "onCreate: "+movieId);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<SpecificData> call = apiInterface.getSpecificData(movieId);
        call.enqueue(new Callback<SpecificData>() {
            @Override
            public void onResponse(Call<SpecificData> call, Response<SpecificData> response) {
                SpecificData result = response.body();
                StringBuilder genres = new StringBuilder();
                String imagePath = "http://image.tmdb.org/t/p/w500/"
                        +result.getBackdrop_path()
                        +"?api_key="+MainActivity.API_KEY;

                if (result.getGenres().size() < 3){
                    for (int i=0; i<result.getGenres().size() ; i++){
                        genres.append(result.getGenres().get(i).getName()+",");
                        //Log.d(MainActivity.TAG, "onResponse: Genres: "+genres);
                    }
                }else {
                    for (int i = 0; i < 3; i++) {
                        genres.append(result.getGenres().get(i).getName() + ",");
                        //Log.d(MainActivity.TAG, "onResponse: Genres: "+genres);
                    }
                }

                double popularity = result.getPopularity();
                Picasso.with(getApplicationContext())
                        .load(imagePath).into(mImageView);
                mDescriptionView.setText(result.getOverview());
                mPopularityView.setText(""+popularity);
                mTitleView.setText(result.getOriginal_title());
                mLanguage.setText(result.getSpoken_languages().get(0).getName());
                mGenresView.setText(genres);
                mBudgetView.setText("$"+result.getBudget());
                mVoteAvgView.setText(result.getVote_average());
                mProductionCompany.setText(result.production_companies.get(0).getName());
                mProductionCountry.setText(result.production_countries.get(0).getName());
            }

            @Override
            public void onFailure(Call<SpecificData> call, Throwable t) {

            }
        });
    }

    private void iniView() {

        mImageView = findViewById(R.id.mainImage);
        mTitleView = findViewById(R.id.title);
        mGenresView = findViewById(R.id.genres);
        mVoteAvgView = findViewById(R.id.voteAvg);
        mPopularityView  = findViewById(R.id.popularity);
        mDescriptionView = findViewById(R.id.description);
        mProductionCompany = findViewById(R.id.productionCompany);
        mProductionCountry = findViewById(R.id.productionCountry);
        mBudgetView = findViewById(R.id.budget);
        mLanguage = findViewById(R.id.language);
        mRecyclerView = findViewById(R.id.recyclerView);
    }
}
