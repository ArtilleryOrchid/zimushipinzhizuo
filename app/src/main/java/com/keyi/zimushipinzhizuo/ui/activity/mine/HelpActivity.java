package com.keyi.zimushipinzhizuo.ui.activity.mine;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;

public class HelpActivity extends BaseActivity implements View.OnClickListener {
    private TextView message_all;
    private ImageButton backBtn;
    private TextView mToolbarTitle;

    @Override
    public int layoutID() {
        return R.layout.activity_help;
    }

    @Override
    public void initView() {
        message_all = findViewById(R.id.message_all);
        mToolbarTitle = findViewById(R.id.toolbar_title);
        mToolbarTitle.setText(getResources().getString(R.string.activity_title_help_feedback));
        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(this::onClick);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String problem = intent.getStringExtra("problem");
        message_all.setText(problem);
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
            case R.id.back_btn:
                finish();
                break;
        }
    }
}
