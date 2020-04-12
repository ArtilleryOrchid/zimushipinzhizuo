package com.keyi.zimushipinzhizuo.ui.activity.mine;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;

public class About_US_Activity extends BaseActivity implements View.OnClickListener {
    private ImageView about_us_back;
    private TextView user_agreement, privacy_policy;
    private Intent intent;

    @Override
    public int layoutID() {
        return R.layout.activity_about__u_s_;
    }

    @Override
    public void initView() {
        about_us_back = findViewById(R.id.about_us_back);
        about_us_back.setOnClickListener(this::onClick);
        user_agreement = findViewById(R.id.user_agreement);
        user_agreement.setOnClickListener(this::onClick);
        privacy_policy = findViewById(R.id.privacy_policy);
        privacy_policy.setOnClickListener(this::onClick);
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
            case R.id.about_us_back:
                finish();
                break;
            case R.id.user_agreement:
            case R.id.privacy_policy:
                if (v.getId() == R.id.user_agreement) {
                    intent = new Intent(this, HtmlActivity.class);
                    intent.putExtra("html", "user_agreement");
                } else if (v.getId() == R.id.privacy_policy) {
                    intent = new Intent(this, HtmlActivity.class);
                    intent.putExtra("html", "privacy_policy");
                }
                startActivity(intent);
                break;
        }
    }
}
