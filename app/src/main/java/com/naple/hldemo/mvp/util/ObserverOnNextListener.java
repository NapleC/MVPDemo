package com.naple.hldemo.mvp.util;

/**
 * created by hl at 2018/5/12
 * com.naple.hldemo.mvp
 */
public interface ObserverOnNextListener<T> {
    void onNext(T t);
    void onFailed(ParseErrorMsgUtil.ErrorMessage errorMessage);
}
