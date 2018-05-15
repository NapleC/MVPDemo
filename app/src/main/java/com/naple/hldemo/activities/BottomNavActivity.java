package com.naple.hldemo.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.naple.hldemo.R;
import com.naple.hldemo.base.CompatStatusBarActivity;
import com.naple.hldemo.fragment.TitleBlueFragment;
import com.naple.hldemo.fragment.TitleImageFragment;
import com.naple.hldemo.fragment.TitleRedFragment;
import com.naple.hldemo.fragment.TitleWhiteFragment;
import com.naple.hldemo.utils.ToastUtils;
import com.naple.hldemo.widget.BottomNavigationViewEx;

import java.util.ArrayList;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class BottomNavActivity extends CompatStatusBarActivity {

    private BottomNavigationViewEx bnve;
    private QBadgeView mBadgeView;
    private TitleBlueFragment mTitleBlueFragment;
    private TitleRedFragment mTitleRedFragment;
    private TitleWhiteFragment mTitleWhiteFragment;
    private TitleImageFragment mTitleImageFragment;
    private ArrayList<Fragment> mFragments;
    private FragmentManager mSupportFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private Fragment mLastFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setStatusBarPlaceVisible(true);
                    setViewColorStatusBar(true, getResources().getColor(R.color.colorPrimary));
                    selectFragment(0);
                    return true;
                case R.id.navigation_auction:
                    setStatusBarPlaceVisible(true);
                    setViewColorStatusBar(true, getResources().getColor(R.color.black));
                    selectFragment(1);
                    return true;

                case R.id.i_empty: {
                    ToastUtils.showShort("发布一些图片吧");
                    return true;
                }
                case R.id.navigation_message:
                    setStatusBarPlaceVisible(true);
                    setViewColorStatusBar(false, Color.WHITE);
                    selectFragment(2);
                    return true;
                case R.id.navigation_person:
                    setStatusBarPlaceVisible(false);
                    setViewColorStatusBar(true, Color.WHITE);
                    selectFragment(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        initFragment();

        bnve = findViewById(R.id.navigation);
        bnve.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);

        addBadgeAt(3, 99);
    }

    private void initFragment() {
        mTitleBlueFragment = new TitleBlueFragment();
        mTitleRedFragment = new TitleRedFragment();
        mTitleWhiteFragment = new TitleWhiteFragment();
        mTitleImageFragment = new TitleImageFragment();
        mFragments = new ArrayList<>();
        mFragments.add(mTitleBlueFragment);
        mFragments.add(mTitleRedFragment);
        mFragments.add(mTitleWhiteFragment);
        mFragments.add(mTitleImageFragment);
        mSupportFragmentManager = getSupportFragmentManager();
        //默认显示第一个
        setViewColorStatusBar(true, getResources().getColor(R.color.colorPrimary));
        selectFragment(0);
    }

    private Badge addBadgeAt(int position, int number) {

        if (mBadgeView == null) {
            mBadgeView = new QBadgeView(this);
        }
        // add badge
        return mBadgeView
                .setBadgeNumber(number)
                .setGravityOffset(12, 2, true)
                .bindTarget(bnve.getBottomNavigationItemView(position))
                .setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                    @Override
                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                        if (Badge.OnDragStateChangedListener.STATE_SUCCEED == dragState) {
                            // 移除回掉
                        }
                    }
                });
    }

    private void selectFragment(int index) {
        if (mFragments != null && mFragments.size() > 0) {
            mFragmentTransaction = mSupportFragmentManager.beginTransaction();
            Fragment baseFragment = mFragments.get(index);
            if (mLastFragment != null) {
                mFragmentTransaction.hide(mLastFragment);
            }
            if (mFragmentTransaction != null) {
                if (baseFragment.isAdded()) {
                    mFragmentTransaction.show(baseFragment);
                } else {
                    mFragmentTransaction.add(R.id.fragment_status_bar_content, baseFragment);
                }
            }
            mFragmentTransaction.commitAllowingStateLoss();
            mLastFragment = baseFragment;
        }
    }

}
