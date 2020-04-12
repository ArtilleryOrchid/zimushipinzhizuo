package com.keyi.zimushipinzhizuo.ui.activity.mine;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;

public class HelpActivity extends BaseActivity implements View.OnClickListener {
    private TextView message_all;
    private ImageView help_back;

    @Override
    public int layoutID() {
        return R.layout.activity_help;
    }

    @Override
    public void initView() {
        message_all = findViewById(R.id.message_all);
        help_back = findViewById(R.id.help_back);
        help_back.setOnClickListener(this::onClick);
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
            case R.id.help_back:
                finish();
                break;
        }
    }
}
