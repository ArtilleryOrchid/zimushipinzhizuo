package com.keyi.zimushipinzhizuo.ui.activity.home;

import android.content.DialogInterface;
import android.widget.Toast;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.ui.widget.dialog.CustomDialog;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.keyi.zimushipinzhizuo.ui.activity.mine.MineActivity;
import com.wangjie.shadowviewhelper.ShadowProperty;
import com.wangjie.shadowviewhelper.ShadowViewHelper;

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    private ImageView my;

    @Override
    public int layoutID() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        CustomDialog.Builder builder = new CustomDialog.Builder(HomeActivity.this);
        builder.setMessage(getBaseContext().getString(R.string.dialog_content));
        builder.setTitle(getBaseContext().getString(R.string.dialog_title));

        builder.setPositiveButton(getBaseContext().getString(R.string.dialog_agree_btn_text)
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(HomeActivity.this, "同意", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.setNegativeButton(getBaseContext().getString(R.string.dialog_disagree_tv_text)
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(HomeActivity.this, "拒绝", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();
        ShadowViewHelper.bindShadowHelper(
                new ShadowProperty()
                        .setShadowDx(0x77FF0000)
                        .setShadowDy(3)
                , findViewById(R.id.shadow_back));
        my = findViewById(R.id.my);
        my.setOnClickListener(this);
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
        }
    }
}
