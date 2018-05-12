package com.naple.hldemo.base;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.naple.hldemo.utils.Loger;
import com.squareup.leakcanary.LeakCanary;

/**
 *  created by hl at 2018/5/12
 *  MyApplication
 */

public class MyApplication extends Application {
  private static MyApplication app;
  private boolean canShowLog = true;

  public static Context getAppContext() {
    return app;
  }

  public static Resources getAppResources() {
    return app.getResources();
  }


  @Override
  protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
  }

  @Override
  public void onCreate() {
    super.onCreate();
    app = this;
    initView();


    initLeakCanary();
  }

  private void initView() {
    Loger.openDebutLog(canShowLog);
  }

  /**
   * 初始化内存检测工具
   */
  private void initLeakCanary() {
    if (LeakCanary.isInAnalyzerProcess(this)) {
      return;
    }
    LeakCanary.install(this);
  }
}
