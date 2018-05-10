package com.naple.devmvp.mvp.view.fragment;

import android.os.Bundle;

import com.naple.devmvp.R;
import com.naple.devmvp.mvp.base.BaseFragment;
import com.naple.devmvp.mvp.contract.CMusic;
import com.naple.devmvp.mvp.presenter.PMusicImpl;


/**
 *  created by hl at 2018/5/9
 *  MusicFragment
 */

public class MusicFragment extends BaseFragment<PMusicImpl> implements CMusic.IVMusic {


    public static MusicFragment newInstance() {
        MusicFragment fragment = new MusicFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView() {


    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_music;
    }

    @Override
    public void createPresenter() {
        mPresenter = new PMusicImpl(mContext, this);
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

}
