package com.duoma.dmcg.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duoma.dmcg.R;

import tools.niorgai.StatusBarCompat;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment {
    private static final String TAG = "DMCGTag";

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
        setHasOptionsMenu(true);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.tab1_tool_bar);
        toolbar.setTitle("首页");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        StatusBarCompat.setStatusBarColor(getActivity(), ContextCompat.getColor(getContext(), R.color.colorPrimary));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            StatusBarCompat.setStatusBarColor(getActivity(), ContextCompat.getColor(getContext(), R.color.colorPrimary));
        }
    }
}
