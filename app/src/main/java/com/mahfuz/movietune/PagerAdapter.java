package com.mahfuz.movietune;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by mahfuz on 7/1/18.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new NewRelease();
            case 1:
                return new TopRated();
            case 2:
                return new Upcoming();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "NEW RELEASE";
            case 1:
                return "TOP RATED";
            case 2:
                return "UPCOMING";
            default:
                return null;
        }
    }
}
