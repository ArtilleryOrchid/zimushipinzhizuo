package com.keyi.zimushipinzhizuo.ui.activity.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;

public class AddProjectActivity extends BaseActivity implements View.OnClickListener {
    private RelativeLayout add_product;
    private RecyclerView recycler;
    private TextView titleView;
    private ImageButton imageButton;

    @Override
    public int layoutID() {
        return R.layout.activity_add_project;
    }

    @Override
    public void initView() {
        add_product = findViewById(R.id.add_product);
        add_product.setOnClickListener(this::onClick);
        recycler = findViewById(R.id.recycler);
        titleView = findViewById(R.id.toolbar_title);
        titleView.setText(getResources().getString(R.string.activity_title_project));
        imageButton = findViewById(R.id.back_btn);
        imageButton.setOnClickListener(this);

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
            case R.id.back_btn:
                finish();
            case R.id.add_product:

                break;
        }
    }
}
