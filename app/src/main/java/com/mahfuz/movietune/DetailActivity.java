package com.mahfuz.movietune;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();
        iniView();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);


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
