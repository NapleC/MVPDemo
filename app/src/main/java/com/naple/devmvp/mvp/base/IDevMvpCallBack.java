package com.naple.devmvp.mvp.base;

/**
 * Created by HL on 2017/9/8.
 */

public interface IDevMvpCallBack<T> {

    void onSuccess(T t);

    void onFail(String reason);
}
