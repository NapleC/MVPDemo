package com.naple.devmvp.mvp.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.naple.devmvp.R;
import com.naple.devmvp.mvp.base.BaseActivity;
import com.naple.devmvp.mvp.bean.BookBean;
import com.naple.devmvp.mvp.bean.TestBean;
import com.naple.devmvp.mvp.contract.CBook;
import com.naple.devmvp.mvp.presenter.PBookImpl;
import com.naple.devmvp.utils.Loger;
import com.naple.devmvp.utils.MsgEvent;
import com.naple.devmvp.utils.RxBus;
import com.naple.devmvp.utils.RxBusWithBackPressure;

import org.reactivestreams.Subscription;

import io.reactivex.functions.Consumer;


/**
 * Created by HL on 2017/12/21.
 * V层 用于数据和页面UI展示（Fragment Dialog 同理）
 */

public class BookActivity extends BaseActivity<PBookImpl> implements CBook.IVBook {

    private TextView mTv;
    private Button mBtn;
    private Subscription subscription;

    @Override
    protected void initView() {
        super.initView();
        mBtn = findViewById(R.id.btn);
        mTv = findViewById(R.id.tv);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.pBook();
                RxBusWithBackPressure.getInstance().post(new MsgEvent("今天天气很好", 11, 45));
                TestBean testBean = new TestBean("这是一本书", 128, 4524);
                RxBus.getInstance().post(new MsgEvent(testBean));
            }
        });
        initTest();

    }

    private void initTest() {
        RxBusWithBackPressure.getInstance().toObservable(MsgEvent.class)
                .subscribe(new Consumer<MsgEvent>() {
                    @Override
                    public void accept(MsgEvent msg) throws Exception {
                        // do your things
                        Loger.debug("RxBusWithBackPressure==" + msg.toString());
                    }
                });


        RxBus.getInstance().toObservable(MsgEvent.class)
                .subscribe(new Consumer<MsgEvent>() {
                    @Override
                    public void accept(MsgEvent msg) throws Exception {
                        // do your things
                        Loger.debug("RxBus==" + msg.toString());
                    }
                });
    }


    @Override
    public int setContentViewId() {
        return R.layout.activity_book;
    }

    @Override
    public void createPresenter() {
        mPresenter = new PBookImpl(mContext, this);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void vBookSuccess(BookBean bean) {
        mTv.setText("网络请求成功：" + bean.getFemale().get(0).toString());
    }

    @Override
    public void vBookError(String reason) {
        mTv.setText(reason);
    }

}
