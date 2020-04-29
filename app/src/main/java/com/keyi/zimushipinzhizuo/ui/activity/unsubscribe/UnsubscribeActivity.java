package com.keyi.zimushipinzhizuo.ui.activity.unsubscribe;


import android.view.View;
import android.widget.TextView;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;

public class UnsubscribeActivity extends BaseActivity implements View.OnClickListener {
    private TextView close_logout;

    @Override
    public int layoutID() {
        return R.layout.activity_logout;
    }

    @Override
    public void initView() {
        close_logout = findViewById(R.id.close_logout);
        close_logout.setOnClickListener(this::onClick);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close_logout:
                finish();
                break;
        }
    }
}
