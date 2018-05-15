package com.naple.hldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.naple.hldemo.activities.BottomNavActivity;
import com.naple.hldemo.adpater.NormalRecyclerViewAdapter;
import com.naple.hldemo.base.BaseActivity;
import com.naple.hldemo.mvp.api.BookApi;
import com.naple.hldemo.mvp.bean.Movie;
import com.naple.hldemo.mvp.presenter.IGetBookPresenter;
import com.naple.hldemo.mvp.presenter.impl.GetBookPresenterImpl;
import com.naple.hldemo.mvp.util.MyObserver;
import com.naple.hldemo.mvp.util.ObserverOnNextListener;
import com.naple.hldemo.mvp.util.ParseErrorMsgUtil;
import com.naple.hldemo.mvp.util.RetrofitUtil;
import com.naple.hldemo.mvp.view.IBookView;
import com.naple.hldemo.utils.Loger;
import com.naple.hldemo.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.naple.hldemo.mvp.util.ApiMethods.ApiSubscribe;

public class MainActivity extends BaseActivity implements IBookView{

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private NormalRecyclerViewAdapter mAdapter;
    List<Movie.SubjectsBean> mData;

    private IGetBookPresenter iGetBookPresenter;
    private BaseActivity baseActivity;

    @Override
    protected int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        ButterKnife.bind(this);
        baseActivity = initToolbar(true, false, true);
        baseActivity.setMyTitle("主页").setMoreTitle("更多");

        initActivityView();
        initObserver();
    }

    private void initActivityView() {
        iGetBookPresenter = new GetBookPresenterImpl(this);
        iGetBookPresenter.getBook(10, 10);

        mData = new ArrayList<>();
        mAdapter = new NormalRecyclerViewAdapter(R.layout.item_book, mData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));//这里用线性宫格显示 类似于grid view
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));//这里用线性宫格显示 类似于瀑布流
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick({R.id.fl_toolbar_more, R.id.tv_title_base_activity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fl_toolbar_more:
                startActivity(new Intent(MainActivity.this, BottomNavActivity.class));
                break;
            case R.id.tv_title_base_activity:
                ToastUtils.showShort("点击了主页");
                break;
        }
    }

    private void initObserver() {
        ObserverOnNextListener<Movie> listener = new ObserverOnNextListener<Movie>() {
            @Override
            public void onNext(Movie movie) {
                Loger.debug("onNext:" + movie.getTitle());
                List<Movie.SubjectsBean> list = movie.getSubjects();
                for (Movie.SubjectsBean sub : list) {
                    Loger.debug("onNext SubjectsBean :" + "onNext: " + sub.getId() + "," + sub.getYear() + "," + sub.getTitle());
                }
                mAdapter.addData(list);
            }

            @Override
            public void onFailed(ParseErrorMsgUtil.ErrorMessage errorMessage) {

            }
        };


        ApiSubscribe(RetrofitUtil.create(BookApi.class).getTopMovie(0, 10),
                new MyObserver<Movie>(listener));
    }

    @Override
    public void getBookSuccess(Movie value) {
        Loger.debug("getBookSuccess:" + value.getTitle());
    }

    @Override
    public void getBookFailed(ParseErrorMsgUtil.ErrorMessage errorMessage) {
        Loger.debug("getBookFailed:" + errorMessage);
    }

    @Override
    public void showDialog(String title, String content) {
        showLoading();
    }

    @Override
    public void hideDialog() {
        hideLoading();
    }
}
