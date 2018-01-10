package com.mahfuz.movietune.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mahfuz.movietune.R;
import com.mahfuz.movietune.adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity {

    public static final String sAPI_KEY = "c37d3b40004717511adb2c1fbb15eda4";
    public static final String sBASE_URL = "https://api.themoviedb.org/3/movie/";
    public static final String sTAG = "MovieTune";

    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.layout_toolbar);
        getSupportActionBar().setElevation(0);

        iniView();

        mViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                finish();
//                startActivity(new Intent(MainActivity.this,DetailActivity.class));
//            }
//        },2500);
    }

    private void iniView() {

        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);
    }
}
