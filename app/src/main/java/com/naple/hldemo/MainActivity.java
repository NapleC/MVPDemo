package com.naple.hldemo;

import android.os.Bundle;

import com.naple.hldemo.base.BaseActivity;
import com.naple.hldemo.mvp.ApiMethods;
import com.naple.hldemo.mvp.Movie;
import com.naple.hldemo.mvp.MyObserver;
import com.naple.hldemo.mvp.ObserverOnNextListener;
import com.naple.hldemo.utils.Loger;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        initToolbar(true, false, true).setMyTitle("主页").setMoreTitle("更多");

        initObserver();
    }

    private void initObserver() {

        ObserverOnNextListener<Movie> listener = movie -> {

            Loger.debug("onNext:" + movie.getTitle());
            List<Movie.Subjects> list = movie.getSubjects();
            for (Movie.Subjects sub:list){
                Loger.debug("onNext Subjects :" + "onNext: " + sub.getId() + "," + sub.getYear() + "," + sub.getTitle());
            }
        };

        ApiMethods.getTopMovie(new MyObserver<Movie>(this,listener),0,10);
    }
}
