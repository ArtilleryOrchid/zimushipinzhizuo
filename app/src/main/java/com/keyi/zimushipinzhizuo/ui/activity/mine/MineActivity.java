package com.keyi.zimushipinzhizuo.ui.activity.mine;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.huopaolan.lib_core.Base.BaseEntity;
import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.bean.AppEntity;
import com.keyi.zimushipinzhizuo.compont.DaggerMineComponent;
import com.keyi.zimushipinzhizuo.contract.MineContract;
import com.keyi.zimushipinzhizuo.modules.MineModules;
import com.keyi.zimushipinzhizuo.presenter.MinePresenter;
import com.keyi.zimushipinzhizuo.ui.activity.home.HomeActivity;
import com.keyi.zimushipinzhizuo.ui.activity.login.LoginActivity;
import com.keyi.zimushipinzhizuo.utils.DeviceIdUtils;
import com.keyi.zimushipinzhizuo.utils.PackageUtils;
import com.keyi.zimushipinzhizuo.utils.SPUtils;
import com.keyi.zimushipinzhizuo.utils.SystemUtil;

public class MineActivity extends BaseActivity<MinePresenter> implements MineContract.MineIView, View.OnClickListener {
    private ImageView mine_back;
    private TextView login, login_vip, login_morn;
    private LinearLayout help;
    private LinearLayout about_us;
    private LinearLayout memory_close;
    private RelativeLayout user_message;
    private String loginId;
    private boolean refreshActivity = false;

    @Override
    public int layoutID() {
        return R.layout.activity_mine;
    }

    @Override
    public void initView() {
        mine_back = findViewById(R.id.mine_back);
        mine_back.setOnClickListener(this);
        login = findViewById(R.id.login);
        login.setOnClickListener(this);
        help = findViewById(R.id.help);
        help.setOnClickListener(this::onClick);
        about_us = findViewById(R.id.about_us);
        about_us.setOnClickListener(this::onClick);
        memory_close = findViewById(R.id.memory_close);
        memory_close.setOnClickListener(this::onClick);
        login_vip = findViewById(R.id.login_vip);
        login_vip.setOnClickListener(this::onClick);
        login_morn = findViewById(R.id.login_morn);
        user_message = findViewById(R.id.user_message);
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void initData() {
        loginId = SPUtils.getInstance().getString("login", "");
        if (loginId.equals("NO")) {
            user_message.setVisibility(View.VISIBLE);
            login_morn.setText("会员ID:1000");
            login_vip.setText("立即开通vip");
            login.setText("退出登录");
            ColorStateList dark_color = getResources().getColorStateList(R.color.logout_color);
            login.setTextColor(dark_color);
            Drawable drawable = getResources().getDrawable(R.drawable.mine_out_background, null);
            login.setBackground(drawable);
        } else {
            user_message.setVisibility(View.GONE);
            login_morn.setText("登录开通更多权限");
            login_vip.setText("登录开通权限");
            login.setText("点击登录");
            ColorStateList color = getResources().getColorStateList(R.color.close_color);
            login.setTextColor(color);
            Drawable drawable = getResources().getDrawable(R.drawable.dialog_btn_agree_bg, null);
            login.setBackground(drawable);
        }
    }

    @Override
    public void setUpDagger() {
        DaggerMineComponent.builder().mineModules(new MineModules(this)).build().inject(this);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_back:
                finish();
                break;
            case R.id.login:
            case R.id.login_vip:
                if (!refreshActivity && loginId.equals("NO")) {
                    if (TextUtils.equals(login_vip.getText().toString(), "立即开通vip") && v.getId() == R.id.login_vip) {
                        startActivity(new Intent(this, VIPActivity.class));
                    } else {
                        refreshActivity = true;
                        user_message.setVisibility(View.GONE);
                        login_morn.setText("登录开通更多权限");
                        login_vip.setText("登录开通权限");
                        login.setText("点击登录");
                        ColorStateList color = getResources().getColorStateList(R.color.close_color);
                        login.setTextColor(color);
                        Drawable drawable = getResources().getDrawable(R.drawable.dialog_btn_agree_bg, null);
                        login.setBackground(drawable);
                        SPUtils.getInstance().putString("login", "OFF");
                        String deviceId = DeviceIdUtils.getDeviceId(getApplication());
                        String accountId = SPUtils.getInstance().getString("accountId", "");
                        p.LogoutRequest(accountId, "ZIMUSHIPINZHIZUO_KEYI", SystemUtil.getDeviceBrand(), "", SystemUtil.getSystemModel(), "ANDROID", "", deviceId, PackageUtils.getVersionName(this));
                    }
                } else {
                    SPUtils.getInstance().getBoolean("first", true);
                    startActivity(new Intent(this, LoginActivity.class));
                }
                break;
            case R.id.help:
                startActivity(new Intent(this, HelpAndFeedBackActivity.class));
                break;
            case R.id.about_us:
                startActivity(new Intent(this, About_US_Activity.class));
                break;
            case R.id.memory_close:
                break;
        }
    }

    @Override
    public void logoutSuccess(BaseEntity<AppEntity> entity) {
        if (entity.success == true) {
            SPUtils.getInstance().putString("login", "OFF");
        }
    }

    @Override
    public void logoutError(String entity) {

    }
}
