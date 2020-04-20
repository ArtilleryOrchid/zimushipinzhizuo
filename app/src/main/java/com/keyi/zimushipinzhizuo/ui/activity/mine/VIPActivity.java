package com.keyi.zimushipinzhizuo.ui.activity.mine;


import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;

public class VIPActivity extends BaseActivity implements View.OnClickListener {
    private ImageButton vip_back;
    private TextView vip_pay;

    @Override
    public int layoutID() {
        return R.layout.activity_v_i_p;
    }

    @Override
    public void initView() {
        vip_back = findViewById(R.id.vip_back);
        vip_back.setOnClickListener(this::onClick);
        vip_pay = findViewById(R.id.vip_pay);
        vip_pay.setOnClickListener(this::onClick);
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
            case R.id.vip_back:
                finish();
                break;
            case R.id.vip_pay:
                Toast.makeText(this, "敬请期待", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
