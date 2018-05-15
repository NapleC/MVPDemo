package com.naple.hldemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naple.hldemo.R;

/**
 *  created by hl at 2018/5/8
 *  TitleRedFragment
 */

public class TitleRedFragment extends Fragment {
    private ViewGroup mTitleLayout;
    private TextView mTitleText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_red, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mTitleLayout = (ViewGroup) view.findViewById(R.id.fragment_title_bg_layout);
        mTitleText = (TextView) view.findViewById(R.id.fragment_title_text);
        mTitleLayout.setBackgroundColor(getResources().getColor(R.color.black));
    }
}
