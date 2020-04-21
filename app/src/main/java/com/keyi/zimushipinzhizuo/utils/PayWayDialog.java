package com.keyi.zimushipinzhizuo.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.api.api;
import com.keyi.zimushipinzhizuo.pay.alipay.PayDemoActivity;
import com.keyi.zimushipinzhizuo.pay.wxapi.WXEntryActivity;

public class PayWayDialog extends Dialog implements View.OnClickListener {

    private LinearLayout zhi_fu_bao_pay;

    private LinearLayout wechat_pay;

    private ImageView close_pay;

    private CheckBox choose_zhi_fu_bao, choose_wechat;

    private TextView pya_money, pya_button;

    private Context context;

    private static int PAY_TYPE = api.ALIPAY;

    /**
     * 如果ifRecharge 传入true 则是充值,就隐藏掉我的钱包, 否则则显示
     *
     * @param context
     * @param themeResId
     */
    public PayWayDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_pay);
        initView();
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = AbsListView.LayoutParams.MATCH_PARENT;
        lp.y = 0;//设置Dialog距离底部的距离
        dialogWindow.setAttributes(lp);
    }

    private void initView() {
        zhi_fu_bao_pay = findViewById(R.id.zhi_fu_bao_pay);
        wechat_pay = findViewById(R.id.wechat_pay);
        close_pay = findViewById(R.id.close_pay);
        choose_zhi_fu_bao = findViewById(R.id.choose_zhi_fu_bao);
        choose_wechat = findViewById(R.id.choose_wechat);
        pya_money = findViewById(R.id.pya_money);
        pya_button = findViewById(R.id.pya_button);
        zhi_fu_bao_pay.setOnClickListener(this::onClick);
        wechat_pay.setOnClickListener(this::onClick);
        close_pay.setOnClickListener(this::onClick);
        pya_button.setOnClickListener(this::onClick);
        PAY_TYPE = api.ALIPAY;
    }


    /**
     * 设置充值金额
     *
     * @param num
     */
    public void setRechargeNum(String num) {
        pya_money.setText("支付金额： " + num);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.close_pay:
                PAY_TYPE = api.ALIPAY;
                dismiss();
                break;
            case R.id.zhi_fu_bao_pay:
                choose_zhi_fu_bao.setChecked(true);
                choose_wechat.setChecked(false);
                PAY_TYPE = api.ALIPAY;
                break;
            case R.id.wechat_pay:
                choose_zhi_fu_bao.setChecked(false);
                choose_wechat.setChecked(true);
                PAY_TYPE = api.WECHAT;
                break;
            case R.id.pya_button:
                switch (PAY_TYPE) {
                    case api.ALIPAY:
                        context.startActivity(new Intent(context, PayDemoActivity.class));
                        break;
                    case api.WECHAT:
                        context.startActivity(new Intent(context, WXEntryActivity.class));
                        break;
                }
                break;
        }
    }
}
