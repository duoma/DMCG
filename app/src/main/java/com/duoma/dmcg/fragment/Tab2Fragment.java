package com.duoma.dmcg.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.duoma.dmcg.Adapter.ViewPagerAdapter;
import com.duoma.dmcg.R;
import com.duoma.dmcg.app.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2Fragment extends BaseFragment {

    public Tab2Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /**
         * 设置 Toolbar 开始
         */
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.tab2_tool_bar);
        toolbar.setTitle(getString(R.string.main_tab_2));
        toolbar.setVisibility(View.GONE);
        toolbar.setTitleTextColor(ContextCompat.getColor(getContext(), R.color.colorTextWhite));
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        /**
         * 设置 Toolbar 结束
         */

        /**
         * 设置 ViewPager 开始
         */
        ViewPager pager2 = (ViewPager) view.findViewById(R.id.pager_tab2);
        TabLayout tabs2 = (TabLayout) view.findViewById(R.id.tablayout_tab2);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());

        pager2.setAdapter(adapter);//给ViewPager设置适配器
        tabs2.setupWithViewPager(pager2);//将TabLayout和ViewPager关联起来。
        /**
         * 设置 ViewPager 结束
         */
    }

    /**
     * Toolbar 菜单选项 开始
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();//即先clear()一下, 这样按钮就只有Fragment中设置的自己的了, 不会有Activity中的按钮.
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    /**
     * Toolbar 菜单选项 结束
     */
}
