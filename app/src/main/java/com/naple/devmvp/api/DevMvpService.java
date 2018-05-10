package com.naple.devmvp.api;

import com.naple.devmvp.mvp.bean.BookBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by HL on 2017/9/1.
 */

public interface DevMvpService {


    @GET(Url.BOOK_CLASSIFY)
    Observable<BookBean> bookClassify();

}
