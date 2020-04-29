package com.keyi.zimushipinzhizuo.ui.activity.mine;


import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.huopaolan.lib_core.Base.BaseActivity;
import com.huopaolan.lib_core.Base.BaseEntity;
import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.bean.AppEntity;
import com.keyi.zimushipinzhizuo.compont.DaggerAppComponent;
import com.keyi.zimushipinzhizuo.contract.AppContract;
import com.keyi.zimushipinzhizuo.modules.AppModules;
import com.keyi.zimushipinzhizuo.pay.alipay.AuthResult;
import com.keyi.zimushipinzhizuo.pay.alipay.PayDemoActivity;
import com.keyi.zimushipinzhizuo.pay.alipay.PayResult;
import com.keyi.zimushipinzhizuo.presenter.ProductPresenter;
import com.keyi.zimushipinzhizuo.utils.DeviceIdUtils;
import com.keyi.zimushipinzhizuo.utils.PackageUtils;
import com.keyi.zimushipinzhizuo.utils.PayWayDialog;
import com.keyi.zimushipinzhizuo.utils.SPUtils;
import com.keyi.zimushipinzhizuo.utils.SystemUtil;

import java.util.ArrayList;
import java.util.Map;

public class VIPActivity extends BaseActivity<ProductPresenter> implements AppContract.ProductIView, View.OnClickListener {
    private ImageButton back_btn;
    private TextView vip_pay, one_month, one_month_money, one_month_discount, one_season, one_season_money, one_season_discount, one_year, one_year_money, one_year_discount;
    private PayWayDialog payWayDialog;
    private TextView titleView;
    private LinearLayout get_month, get_season, get_year;
    private String id = null;
    private String one_productId, two_productId, three_productId;

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    private String money;

    @Override
    public int layoutID() {
        return R.layout.activity_v_i_p;
    }

    @Override
    public void initView() {
        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(this::onClick);
        vip_pay = findViewById(R.id.vip_pay);
        titleView = findViewById(R.id.toolbar_title);
        titleView.setText(getResources().getString(R.string.vip));
        vip_pay.setOnClickListener(this::onClick);
        one_month = findViewById(R.id.one_month);
        one_month_money = findViewById(R.id.one_month_money);
        one_month_discount = findViewById(R.id.one_month_discount);
        one_season = findViewById(R.id.one_season);
        one_season_money = findViewById(R.id.one_season_money);
        one_season_discount = findViewById(R.id.one_season_discount);
        one_year = findViewById(R.id.one_year);
        one_year_money = findViewById(R.id.one_year_money);
        one_year_discount = findViewById(R.id.one_year_discount);
        get_month = findViewById(R.id.get_month);
        get_month.setOnClickListener(this::onClick);
        get_season = findViewById(R.id.get_season);
        get_season.setOnClickListener(this::onClick);
        get_year = findViewById(R.id.get_year);
        get_year.setOnClickListener(this::onClick);
    }

    @Override
    public void initData() {
        String deviceId = DeviceIdUtils.getDeviceId(getApplication());
        String accountId = SPUtils.getInstance().getString("accountId", "");
        p.productRequest(accountId, "ZIMUSHIPINZHIZUO_KEYI", SystemUtil.getDeviceBrand(), "", SystemUtil.getSystemModel(), "ANDROID", "", deviceId, PackageUtils.getVersionName(this));
    }

    @Override
    public void setUpDagger() {
        DaggerAppComponent.builder().appModules(new AppModules(null, this)).build().inject(this);
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
            case R.id.back_btn:
                finish();
                break;
            case R.id.vip_pay:
                String deviceId = DeviceIdUtils.getDeviceId(getApplication());
                String accountId = SPUtils.getInstance().getString("accountId", "");
                p.CreatePayRequest(accountId, "ZIMUSHIPINZHIZUO_KEYI", SystemUtil.getDeviceBrand(), "", SystemUtil.getSystemModel(), "ANDROID", "", id, deviceId, PackageUtils.getVersionName(this));
                break;
            case R.id.get_month:
                id = one_productId;
                money = one_month_money.getText().toString();
                break;
            case R.id.get_season:
                id = two_productId;
                money = one_season_money.getText().toString();
                break;
            case R.id.get_year:
                id = three_productId;
                money = one_year_money.getText().toString();
                break;
        }
    }

    @Override
    public void ProductSuccess(BaseEntity<ArrayList<AppEntity.Data>> entity) {
        if (entity.success == true) {
            one_productId = entity.result.get(0).productId;
            one_month.setText(entity.result.get(0).productName + "vip");
            one_month_money.setText("￥" + entity.result.get(0).price);
            String one_money = "" + entity.result.get(0).discountPrice;
            SpannableString one = new SpannableString(one_money);
            one.setSpan(new StrikethroughSpan(), 0, one_money.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            one_month_discount.setText(one);

            two_productId = entity.result.get(1).productId;
            one_season.setText(entity.result.get(1).productName + "vip");
            one_season_money.setText("￥" + entity.result.get(1).price);
            String two_money = "" + entity.result.get(1).discountPrice;
            SpannableString two = new SpannableString(two_money);
            two.setSpan(new StrikethroughSpan(), 0, two_money.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            one_season_discount.setText(two);

            three_productId = entity.result.get(2).productId;
            one_year.setText(entity.result.get(2).productName + "vip");
            one_year_money.setText("￥" + entity.result.get(2).price);
            String three_money = "" + entity.result.get(2).discountPrice;
            SpannableString three = new SpannableString(three_money);
            three.setSpan(new StrikethroughSpan(), 0, three_money.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            one_year_discount.setText(one);
        }
    }

    @Override
    public void ProductError(String error) {

    }

    @Override
    public void CreatePaySuccess(BaseEntity<String> entity) {
        if (entity.success == true) {
            SPUtils.getInstance().putString("orderId", entity.result);
            String deviceId = DeviceIdUtils.getDeviceId(getApplication());
            String accountId = SPUtils.getInstance().getString("accountId", "");
            p.PayRequest(accountId, "ZIMUSHIPINZHIZUO_KEYI", SystemUtil.getDeviceBrand(), "", SystemUtil.getSystemModel(), "ANDROID", "", deviceId, PackageUtils.getVersionName(this));
        }
    }

    @Override
    public void CreatePayError(String error) {

    }

    @Override
    public void PaySuccess(BaseEntity<ArrayList<AppEntity.Pay>> entity) {
        if (entity.success == true) {
            ArrayList<AppEntity.Pay> result = entity.result;
            initPayDialog(result);
        }
    }

    @Override
    public void PayError(String error) {

    }

    @Override
    public void SubmitSuccess(BaseEntity<AppEntity.Submit> entity) {
        if (entity.success == true) {
            final Runnable payRunnable = new Runnable() {
                @Override
                public void run() {
                    PayTask alipay = new PayTask(VIPActivity.this);
                    Map<String, String> result = alipay.payV2(entity.result.payInfo, true);
                    Log.i("msp", result.toString());

                    Message msg = new Message();
                    msg.what = SDK_PAY_FLAG;
                    msg.obj = result;
                    mHandler.sendMessage(msg);
                }
            };
            // 必须异步调用
            Thread payThread = new Thread(payRunnable);
            payThread.start();
        }
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(VIPActivity.this, getString(R.string.pay_success) + payResult, Toast.LENGTH_SHORT).show();
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(VIPActivity.this, getString(R.string.pay_failed) + payResult, Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();

                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        Toast.makeText(VIPActivity.this, getString(R.string.auth_success) + authResult, Toast.LENGTH_SHORT).show();
                    } else {
                        // 其他状态值则为授权失败
                        Toast.makeText(VIPActivity.this, getString(R.string.auth_failed) + authResult, Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                default:
                    break;
            }
        }

        ;
    };

    @Override
    public void SubmitError(String error) {

    }

    private void initPayDialog(ArrayList<AppEntity.Pay> result) {
        payWayDialog = new PayWayDialog(this, result, p, R.style.recharge_pay_dialog);
        payWayDialog.show();
        payWayDialog.setRechargeNum(money);
    }
}
