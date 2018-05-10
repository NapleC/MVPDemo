package com.naple.devmvp.mvp.presenter;

import android.content.Context;

import com.naple.devmvp.mvp.base.BasePresenter;
import com.naple.devmvp.mvp.contract.CMusic;
import com.naple.devmvp.mvp.model.MMusicImpl;


/**
 * Created by HL on 2017/12/21.
 *
 * @author naple
 */

public class PMusicImpl extends BasePresenter<CMusic.IVMusic, MMusicImpl> implements CMusic.IPMusic {


    public PMusicImpl(Context mContext, CMusic.IVMusic mView) {
        super(mContext, mView, new MMusicImpl());
    }

}
