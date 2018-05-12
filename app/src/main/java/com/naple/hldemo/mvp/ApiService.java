package com.naple.hldemo.mvp;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * created by hl at 2018/5/12
 * com.naple.hldemo.mvp
 */
public interface ApiService {

    @GET("top250")
    Observable<Movie> getTopMovie(@Query("start") int start, @Query("count") int count);

}
