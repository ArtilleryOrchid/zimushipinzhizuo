package com.keyi.zimushipinzhizuo.ui.activity.mine;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.huopaolan.lib_core.Base.BaseEntity;
import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.bean.AppEntity;
import com.keyi.zimushipinzhizuo.compont.DaggerAppMessageComponent;
import com.keyi.zimushipinzhizuo.contract.AppMessageContract;
import com.keyi.zimushipinzhizuo.modules.AppMessageModules;
import com.keyi.zimushipinzhizuo.presenter.AppMessagePresenter;
import com.keyi.zimushipinzhizuo.utils.PackageUtils;

public class About_US_Activity extends BaseActivity<AppMessagePresenter> implements AppMessageContract.AppMessageIView, View.OnClickListener {
    private ImageButton about_us_back;
    private TextView user_agreement, privacy_policy, app_version;
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
        app_version = findViewById(R.id.app_version);
    }

    @Override
    public void initData() {
        app_version.setText("V " + PackageUtils.getVersionName(this));
        p.AppRequest("STORY", "apple", "appStore", "iPhone7", "IOS", "BDAF6B4D5DC04AEFBCF86C7EFC94DE97", "1.0.0");
    }

    @Override
    public void setUpDagger() {
        DaggerAppMessageComponent.builder().appMessageModules(new AppMessageModules(this)).build().inject(this);
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

    @Override
    public void AppMessageSuccess(BaseEntity<AppEntity> entity) {
        Toast.makeText(this, "" + entity.result.versionInfoVo.content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void AppMessageError(String error) {

    }
}
