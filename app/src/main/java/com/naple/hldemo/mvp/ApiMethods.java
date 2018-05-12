package com.naple.hldemo.mvp;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * created by hl at 2018/5/12
 * com.naple.hldemo.mvp
 */
public class ApiMethods {

    public static void ApiSubscribe(Observable observable, Observer observer){
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     *
     */
    public static void getTopMovie(Observer<Movie> observer,int start,int count){
        ApiSubscribe(Api.getApiService().getTopMovie(start,count),observer);
    }

}
