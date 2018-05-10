package com.naple.devmvp.utils.rxhelper;

import com.naple.devmvp.mvp.base.IDevMvpCallBack;
import com.naple.devmvp.utils.Loger;
import com.naple.devmvp.utils.ToastUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by HL on 2017/12/21.
 */

public abstract class RxObservable<T> implements Observer<T>, IDevMvpCallBack<T> {

    public RxObservable() {
    }


//    /**
//     * 失败回调
//     *
//     * @param errorMsg 错误信息
//     */
//    protected abstract void onError(String errorMsg);
//
//    /**
//     * 成功回调
//     *
//     * @param data 结果
//     */
//    protected abstract void onSuccess(T data);
//


    @Override
    public void onSubscribe(Disposable d) {
        Loger.debug("onSubscribe RxObservable : "+d);
    }

    @Override
    public void onError(Throwable e) {
        String error = RxException.handleException(e).getMessage();
        ToastUtils.showShortSafe(error);
//        onError(error);
        this.onFail(error);
    }


    @Override
    public void onNext(T value) {
        //可以根据需求对code统一处理
//        onSuccess(value);
        this.onSuccess(value);
    }


    @Override
    public void onComplete() {
    }
}
