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
import android.widget.Toast;

import com.duoma.dmcg.Adapter.ViewPagerAdapter;
import com.duoma.dmcg.R;
import com.duoma.dmcg.app.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends BaseFragment {

    public Tab1Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /**
         * 设置 Toolbar 开始
         */
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.tab1_tool_bar);
        toolbar.setTitle(getString(R.string.main_tab_1));
        toolbar.setTitleTextColor(ContextCompat.getColor(getContext(), R.color.colorTextWhite));
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        /**
         * 设置 Toolbar 结束
         */

        /**
         * 设置 ViewPager 开始
         */
        ViewPager pager1 = (ViewPager) view.findViewById(R.id.pager_tab1);
        TabLayout tabs1 = (TabLayout) view.findViewById(R.id.tablayout_tab1);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());

        pager1.setAdapter(adapter);//给ViewPager设置适配器
        tabs1.setupWithViewPager(pager1);//将TabLayout和ViewPager关联起来。
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
        inflater.inflate(R.menu.base_toolbar_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(getActivity(), R.string.menu_search, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_notification:
                Toast.makeText(getActivity(), R.string.menu_notifications, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_item1:
                Toast.makeText(getActivity(), R.string.item_01, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_item2:
                Toast.makeText(getActivity(), R.string.item_02, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /**
     * Toolbar 菜单选项 结束
     */
}
