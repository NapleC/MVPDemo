package com.naple.hldemo.base;


/**
 * Author: 海晨忆
 * Date: 2018/2/23
 * Desc:
 */
public abstract class BaseMvpActivity<T extends BasePresenter>  extends BaseActivity{

  protected T basePresenter;

  @Override
  @SuppressWarnings("unchecked")
  protected void initView() {
    super.initView();
    if (null != basePresenter) {
      basePresenter.attachView(this);
    }
  }

  @Override
  protected void onDestroy() {
    if (null != basePresenter) {
      basePresenter.detachView();
      basePresenter = null;
    }
    super.onDestroy();
  }
}
