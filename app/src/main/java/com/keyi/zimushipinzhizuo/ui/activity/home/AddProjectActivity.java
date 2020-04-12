package com.keyi.zimushipinzhizuo.ui.activity.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;

public class AddProjectActivity extends BaseActivity implements View.OnClickListener {
    private ImageView add_back;
    private RelativeLayout add_product;
    private RecyclerView recycler;

    @Override
    public int layoutID() {
        return R.layout.activity_add_project;
    }

    @Override
    public void initView() {
        add_back = findViewById(R.id.add_back);
        add_back.setOnClickListener(this::onClick);
        add_product = findViewById(R.id.add_product);
        add_product.setOnClickListener(this::onClick);
        recycler = findViewById(R.id.recycler);
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
            case R.id.add_back:
                finish();
                break;
            case R.id.add_product:
                break;
        }
    }
}
