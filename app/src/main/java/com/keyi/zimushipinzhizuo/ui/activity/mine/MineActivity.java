package com.keyi.zimushipinzhizuo.ui.activity.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.ui.activity.home.HomeActivity;
import com.keyi.zimushipinzhizuo.ui.activity.login.LoginActivity;
import com.keyi.zimushipinzhizuo.utils.SPUtils;

public class MineActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mine_back;
    private TextView login, login_vip;
    private LinearLayout help;
    private LinearLayout about_us;
    private LinearLayout memory_close;

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
    }

    @Override
    public void initData() {

    }

    @Override
    public void setUpDagger() {

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_back:
                finish();
                break;
            case R.id.login:
            case R.id.login_vip:
                SPUtils.getInstance().getBoolean("first", true);
                startActivity(new Intent(this, LoginActivity.class));
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
}
