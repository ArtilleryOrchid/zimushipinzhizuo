package com.huopaolan.lib_core.Base;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.huopaolan.lib_core.Mvp.Presenter.IPresenter;
import com.huopaolan.lib_core.Mvp.View.IView;
import com.huopaolan.lib_core.utils.StatusBarUtils;

import javax.inject.Inject;

/**
 * Activity封装
 */
public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IActivity, IView {
    //Dagger2注入
    @Inject
    protected P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtils.setRootViewFitsSystemWindows(this, true);
        //设置状态栏透明
        StatusBarUtils.setTranslucentStatus(this);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtils.setStatusBarDarkTheme(this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtils.setStatusBarColor(this, 0x55000000);
        }
        setContentView(layoutID());
        setUpDagger();
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        if (p != null)
            p.destroy();
        p = null;
        if (!isFinishing()) {
            finish();
        }
        super.onDestroy();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
