package com.naple.hldemo.mvp.presenter.impl;

import com.naple.hldemo.mvp.api.BookApi;
import com.naple.hldemo.mvp.bean.Movie;
import com.naple.hldemo.mvp.presenter.IGetBookPresenter;
import com.naple.hldemo.mvp.util.ParseErrorMsgUtil;
import com.naple.hldemo.mvp.util.RetrofitUtil;
import com.naple.hldemo.mvp.view.IBookView;
import com.naple.hldemo.utils.Loger;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * created by hl at 2018/5/14
 * com.naple.hldemo.mvp.presenter.impl
 */
public class GetBookPresenterImpl implements IGetBookPresenter {

    private IBookView iBookView;

    public GetBookPresenterImpl(IBookView iBookView) {
        this.iBookView = iBookView;
    }

    @Override
    public void getBook(int start, int count) {

        RetrofitUtil.create(BookApi.class).getTopMovie(start,count)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Movie>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Movie value) {
                        iBookView.getBookSuccess(value);

                    }

                    @Override
                    public void onError(Throwable e) {
                        iBookView.getBookFailed(ParseErrorMsgUtil.getErrorCode(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
