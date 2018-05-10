package com.naple.devmvp.mvp.base;

import com.naple.devmvp.api.DevMvpApi;
import com.naple.devmvp.api.DevMvpService;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by HL on 2017/12/21.
 */

public abstract class BaseModel {


    public CompositeDisposable mDisposable = new CompositeDisposable();

    /**
     * 初始化调用网络请求
     * @return
     */
    public DevMvpService apiService() {
        return DevMvpApi.createApi().create(DevMvpService.class);
    }
    /**
     * 取消网络请求
     */
    public void onDestroy() {

        if (mDisposable != null) {
            mDisposable.dispose();
            mDisposable.clear();
        }
    }
}
