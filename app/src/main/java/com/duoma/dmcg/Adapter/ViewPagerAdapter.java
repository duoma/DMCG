package com.duoma.dmcg.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.duoma.dmcg.fragment.PagerFragment;

/**
 * Created by Administrator on 2016/12/12.
 *  适配器
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES = {"TAB0", "TAB1", "TAB2", "TAB3", "TAB4", "TAB5", "TAB6", "TAB7"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        return PagerFragment.newInstance(position);
    }

}