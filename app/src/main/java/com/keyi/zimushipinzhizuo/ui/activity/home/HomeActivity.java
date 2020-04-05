package com.keyi.zimushipinzhizuo.ui.activity.home;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import android.widget.Toast;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.ui.widget.dialog.CustomDialog;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.keyi.zimushipinzhizuo.ui.activity.mine.MineActivity;
import com.keyi.zimushipinzhizuo.ui.widget.span.MyClickText;
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
        final CustomDialog.Builder builder = new CustomDialog.Builder(HomeActivity.this);
        showAgreeDialog(builder);
        ShadowViewHelper.bindShadowHelper(
                new ShadowProperty()
                        .setShadowDx(0x77FF0000)
                        .setShadowDy(3)
                , findViewById(R.id.shadow_back));
        my = findViewById(R.id.my);
        my.setOnClickListener(this);
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

        SpannableStringBuilder style = new SpannableStringBuilder(
                getBaseContext().getString(R.string.dialog_content));
        SpannableString str = new SpannableString(getBaseContext().getString(R.string.dialog_content));
        int[] spanIndexs = getSpanIndexs(style.toString());
        int index = 0;
        for (int i = 0; i < spanIndexs.length / 2; i ++) {
            str.setSpan(new MyClickText(HomeActivity.this), spanIndexs[index + i], spanIndexs[index + i + 1] + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            messageView.setText(str);
            messageView.setMovementMethod(LinkMovementMethod.getInstance());
            messageView.setHighlightColor(Color.TRANSPARENT);
            index += index + i + 1;
        }
    }

    private int[] getSpanIndexs(String string) {
        int count = 0;
        for (int i = 0; i < string.length() - 1; i ++) {
            if (string.charAt(i) == '《' || string.charAt(i) == '》') {
                count ++;
            }
        }
        int [] indexs = new int[count];
        count = 0;
        for (int i = 0; i < string.length() - 1; i ++) {
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
