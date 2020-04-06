package com.keyi.zimushipinzhizuo.ui.activity.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.bean.LoginEntity;
import com.keyi.zimushipinzhizuo.compont.DaggerLoginComponent;
import com.keyi.zimushipinzhizuo.contract.LoginContract;
import com.keyi.zimushipinzhizuo.modules.LoginModules;
import com.keyi.zimushipinzhizuo.presenter.LoginPresenter;
import com.keyi.zimushipinzhizuo.ui.activity.home.HomeActivity;
import com.keyi.zimushipinzhizuo.ui.widget.dialog.CustomDialog;
import com.keyi.zimushipinzhizuo.ui.widget.span.CountdownButton;
import com.keyi.zimushipinzhizuo.ui.widget.span.MyClickText;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginIView, View.OnClickListener {
    private Button login_button;
    private EditText phone;
    private EditText access;
    private CountdownButton get_access;
    private ImageView login_back;

    @Override
    public int layoutID() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        final CustomDialog.Builder builder = new CustomDialog.Builder(this);
        showAgreeDialog(builder);
        login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(this::onClick);
        phone = findViewById(R.id.phone);
        access = findViewById(R.id.access);
        get_access = findViewById(R.id.get_access);
        get_access.setOnClickListener(this::onClick);
        login_back = findViewById(R.id.login_back);
        login_back.setOnClickListener(this::onClick);
    }

    private void showAgreeDialog(final CustomDialog.Builder builder) {
        builder.setMessage(getBaseContext().getString(R.string.dialog_content));
        builder.setTitle(getBaseContext().getString(R.string.dialog_title));
        builder.setPositiveButton(getBaseContext().getString(R.string.dialog_agree_btn_text)
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton(getBaseContext().getString(R.string.dialog_disagree_tv_text)
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        showIsExitAppDialog(builder);
                    }
                });
        CustomDialog customDialog = builder.create();
        setSpan(builder.getMessageView());
        customDialog.show();
    }

    private void showIsExitAppDialog(final CustomDialog.Builder builder) {
        builder.setTitle(getBaseContext().getString(R.string.dialog_exit_title));
        builder.setMessage(getBaseContext().getString(R.string.dialog_exit_nessage));
        builder.setPositiveButton(getBaseContext().getString(R.string.dialog_exit_positive)
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        showAgreeDialog(builder);
                    }
                });
        builder.setNegativeButton(getBaseContext().getString(R.string.dialog_exit_negative)
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });

        builder.create().show();
    }

    private void setSpan(TextView messageView) {

        SpannableString str = new SpannableString(getBaseContext().getString(R.string.dialog_content));
        int[] spanIndexs = getSpanIndexs(str.toString());
        int index = 0;
        for (int i = 0; i < spanIndexs.length / 2; i++) {
            str.setSpan(new MyClickText(this, str.toString()
                            .substring(spanIndexs[index + i], spanIndexs[index + i + 1] + 1))
                    , spanIndexs[index + i], spanIndexs[index + i + 1] + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            messageView.setMovementMethod(LinkMovementMethod.getInstance());
            messageView.setHighlightColor(Color.TRANSPARENT);
            index += index + i + 1;
        }
        messageView.setText(str);
    }

    private int[] getSpanIndexs(String string) {
        int count = 0;
        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == '《' || string.charAt(i) == '》') {
                count++;
            }
        }
        int[] indexs = new int[count];
        count = 0;
        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == '《' || string.charAt(i) == '》') {
                indexs[count++] = i;
            }
        }
        return indexs;
    }

    @Override
    public void initData() {

    }

    @Override
    public void setUpDagger() {
        DaggerLoginComponent.builder().loginModules(new LoginModules(this)).build().inject(this);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void loginSuccess(LoginEntity entity) {

    }

    @Override
    public void loginError(String error) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                break;
            case R.id.get_access:
                boolean flag = true;
                if (TextUtils.isEmpty(phone.getText().toString().trim())) {
                    Toast.makeText(this, "请输入您的电话号码", Toast.LENGTH_LONG).show();
                    phone.requestFocus();
                    flag = false;
                } else if (phone.getText().toString().trim().length() != 11) {
                    Toast.makeText(this, "您的电话号码位数不正确", Toast.LENGTH_LONG).show();
                    phone.requestFocus();
                    flag = false;
                } else {
                    String phone_number = phone.getText().toString().trim();
                    String num = "[1][358]\\d{9}";
                    if (phone_number.matches(num))
                        flag = false;
                    else {
                        Toast.makeText(this, "请输入正确的手机号码", Toast.LENGTH_LONG).show();
                        flag = false;
                    }
                }
                if (!flag) {
                    String s = phone.getText().toString();
                    p.loginRequest("ZIMUSHIPINZHIZUO_KEYI", s);
                }
                break;
            case R.id.login_back:
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
        }
    }
}
