package com.keyi.zimushipinzhizuo.ui.activity.mine;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;

public class HelpActivity extends BaseActivity implements View.OnClickListener {
    private TextView message_all, id_editor_detail_font_count;
    private ImageButton backBtn;
    private TextView mToolbarTitle;
    private EditText id_editor_detail;

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
        id_editor_detail_font_count = findViewById(R.id.id_editor_detail_font_count);
        id_editor_detail = findViewById(R.id.id_editor_detail);
        id_editor_detail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                id_editor_detail_font_count.setText(String.valueOf(s.length()) + "/400");
                if (s.length() >= 400) {
                    Toast.makeText(HelpActivity.this, "上限了，亲", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
