package com.keyi.zimushipinzhizuo.ui.activity.mine;

import android.content.Intent;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;

public class HtmlActivity extends BaseActivity {
    private WebView web_html;
    private String privacy_policy = "file:///android_asset/privacy.html";
    private String user_agreement = "file:///android_asset/network.html";

    @Override
    public int layoutID() {
        return R.layout.activity_html;
    }

    @Override
    public void initView() {
        web_html = findViewById(R.id.web_html);
        Intent intent = getIntent();
        String html = intent.getStringExtra("html");
        //支持js交互
        web_html.getSettings().setJavaScriptEnabled(true);
        //自适应屏幕
        web_html.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
        web_html.getSettings().setLoadWithOverviewMode(true);
        web_html.setWebViewClient(new WebViewClient());
        switch (html) {
            case "user_agreement":
                web_html.loadUrl(user_agreement);
                break;
            case "privacy_policy":
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
}
