package com.naple.hldemo.mvp;

import android.content.Context;

import com.naple.hldemo.utils.Loger;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * created by hl at 2018/5/12
 * com.naple.hldemo.mvp
 */
public class MyObserver<T> implements Observer<T> {

    private Context context;
    private ObserverOnNextListener listener;

    public MyObserver(Context context, ObserverOnNextListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {
        Loger.debug("onSubscribe");
    }

    @Override
    public void onNext(T t) {
        listener.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        Loger.debug("onError:"+e);
    }

    @Override
    public void onComplete() {
        Loger.debug("onComplete");
    }
}
