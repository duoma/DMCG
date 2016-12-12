package com.duoma.dmcg.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.duoma.dmcg.R;
import com.duoma.dmcg.app.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab4Fragment extends BaseFragment {


    public Tab4Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab4, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.tab4_tool_bar);
        toolbar.setTitle(getString(R.string.main_tab_4));
        toolbar.setTitleTextColor(ContextCompat.getColor(getContext(), R.color.colorTextWhite));
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

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
