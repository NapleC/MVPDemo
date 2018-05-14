package com.naple.hldemo.mvp.view;

import com.naple.hldemo.mvp.bean.Movie;
import com.naple.hldemo.mvp.util.IShowAndHideDialog;
import com.naple.hldemo.mvp.util.ParseErrorMsgUtil;

/**
 * created by hl at 2018/5/14
 * com.naple.hldemo.mvp.view
 */
public interface IBookView extends IShowAndHideDialog {

    void getBookSuccess(Movie value);
    void getBookFailed(ParseErrorMsgUtil.ErrorMessage errorMessage);
}
