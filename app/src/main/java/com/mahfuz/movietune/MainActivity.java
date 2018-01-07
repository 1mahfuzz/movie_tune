package com.mahfuz.movietune;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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
    }

    private void iniView() {

        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);
    }
}
