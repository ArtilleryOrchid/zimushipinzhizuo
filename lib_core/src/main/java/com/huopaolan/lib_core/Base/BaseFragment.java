package com.huopaolan.lib_core.Base;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.huopaolan.lib_core.Mvp.Presenter.IPresenter;
import com.huopaolan.lib_core.Mvp.View.IView;
import com.huopaolan.lib_core.utils.StatusBarUtils;

import javax.inject.Inject;

/**
 * Fragment封装
 */
public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IFragment, IView {
    protected int page = 1;
    //dagger2注入
    @Inject
    protected P p;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createView(inflater);
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtils.setRootViewFitsSystemWindows(getActivity(), true);
        //设置状态栏透明
        StatusBarUtils.setTranslucentStatus(getActivity());
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtils.setStatusBarDarkTheme(getActivity(), true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtils.setStatusBarColor(getActivity(), 0x55000000);
        }
        setUpDagger();
        initView(view);
        initData();
        return view;
    }

    //透明状态栏
//    public static void makeStatusBarTransparent(Activity activity) {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
//            return;
//        }
//        Window window = activity.getWindow();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            int option = window.getDecorView().getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
//            window.getDecorView().setSystemUiVisibility(option);
//            window.setStatusBarColor(Color.TRANSPARENT);
//        } else {
//            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
//    }

    @Override
    public void onDestroy() {
        if (p != null) {
            p.destroy();
        }
        p = null;
        super.onDestroy();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
