package com.keyi.zimushipinzhizuo.ui.activity.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;
import com.wangjie.shadowviewhelper.ShadowProperty;
import com.wangjie.shadowviewhelper.ShadowViewHelper;

public class HomeActivity extends BaseActivity {

    @Override
    public int layoutID() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        ShadowViewHelper.bindShadowHelper(
                new ShadowProperty()
                        .setShadowDx(0x77FF0000)
                        .setShadowDy(3)
                , findViewById(R.id.shadow_back));
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
