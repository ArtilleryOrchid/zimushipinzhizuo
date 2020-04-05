package com.keyi.zimushipinzhizuo.ui.activity.mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.ui.activity.login.LoginActivity;

public class MineActivity extends BaseActivity implements View.OnClickListener {
    private ImageView mine_back;
    private TextView login;

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
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
    }
}
