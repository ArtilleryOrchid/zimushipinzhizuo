package com.keyi.zimushipinzhizuo.ui.activity.mine;


import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.utils.PayWayDialog;

public class VIPActivity extends BaseActivity implements View.OnClickListener {
    private ImageButton vip_back;
    private TextView vip_pay;
    private PayWayDialog payWayDialog;
    private TextView titleView;

    @Override
    public int layoutID() {
        return R.layout.activity_v_i_p;
    }

    @Override
    public void initView() {
        vip_back = findViewById(R.id.vip_back);
        vip_back.setOnClickListener(this::onClick);
        vip_pay = findViewById(R.id.vip_pay);
        titleView = findViewById(R.id.toolbar_title);
        titleView.setText(getResources().getString(R.string.vip));
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
                initPayDialog();
                break;
        }
    }

    private void initPayDialog() {
        payWayDialog = new PayWayDialog(this, R.style.recharge_pay_dialog);
        payWayDialog.show();
        payWayDialog.setRechargeNum("198");
    }
}
