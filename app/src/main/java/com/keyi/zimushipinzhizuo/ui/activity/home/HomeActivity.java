package com.keyi.zimushipinzhizuo.ui.activity.home;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.ui.widget.dialog.CustomDialog;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.keyi.zimushipinzhizuo.ui.activity.mine.MineActivity;
import com.wangjie.shadowviewhelper.ShadowProperty;
import com.wangjie.shadowviewhelper.ShadowViewHelper;

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    private ImageButton my;
    private RelativeLayout add_file_button;

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
        my = findViewById(R.id.my);
        my.setOnClickListener(this);
        add_file_button = findViewById(R.id.add_file_button);
        add_file_button.setOnClickListener(this::onClick);
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
            case R.id.my:
                startActivity(new Intent(this, MineActivity.class));
                break;
            case R.id.add_file_button:
                startActivity(new Intent(this, AddProjectActivity.class));
                break;
        }
    }
}
