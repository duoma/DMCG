package com.duoma.dmcg.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duoma.dmcg.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerFragment extends Fragment {
    private static final String ARG_POSITION = "position";
    private int position;

    public PagerFragment() {
    }

    /**
     * 获取实例并传递参数
     */
    public static PagerFragment newInstance(int position) {
        PagerFragment f = new PagerFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);//设置页数
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt(ARG_POSITION);//获取页数
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView frag_tab = (TextView) view.findViewById(R.id.tv_frag_tab);
        frag_tab.setText("页数：" + position);

    }
}
