package com.keyi.zimushipinzhizuo.ui.activity.mine;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.ui.widget.span.MyClickText;

public class HtmlActivity extends BaseActivity implements View.OnClickListener {
    private WebView web_html;
    private String privacy_policy = "file:///android_asset/privacy.html";
    private String user_agreement = "file:///android_asset/network.html";
    private Toolbar toolbar;
    private TextView titleView;
    private ImageButton backBtn;

    @Override
    public int layoutID() {
        return R.layout.activity_html;
    }

    @Override
    public void initView() {
        web_html = findViewById(R.id.web_html);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        titleView = toolbar.findViewById(R.id.toolbar_title);
        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(this);
        Intent intent = getIntent();
        String html = intent.getStringExtra("html");
        //支持js交互
        web_html.getSettings().setJavaScriptEnabled(true);
        web_html.getSettings().setDomStorageEnabled(true);
        //自适应屏幕
        web_html.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        web_html.getSettings().setLoadWithOverviewMode(true);
        web_html.setWebViewClient(new WebViewClient());
        switch (html) {
            case "user_agreement":
                titleView.setText(MyClickText.USER_AGREENMENT);
                web_html.loadUrl(user_agreement);
                web_html.evaluateJavascript("javascript:setAppName(\'" + "视频制作" + "\')", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String value) {
//                        Toast.makeText(HtmlActivity.this, "" + value, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case "privacy_policy":
                titleView.setText(MyClickText.PRIVACY_POLICY);
                web_html.loadUrl(privacy_policy);
                break;
        }
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
            case R.id.back_btn :
                finish();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}
