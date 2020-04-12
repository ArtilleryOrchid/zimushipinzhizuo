package com.keyi.zimushipinzhizuo.ui.widget.span;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.ui.activity.mine.HtmlActivity;

public class MyClickText extends ClickableSpan {
    private Activity context;
    private String type;
    private Intent intent;

    public MyClickText(Activity context, String type) {
        this.context = context;
        this.type = type;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void updateDrawState(@NonNull TextPaint ds) {
        super.updateDrawState(ds);
        ds.setColor(Color.parseColor("#3099FB"));
        ds.setColor(context.getColor(R.color.dialog_span_color));
        ds.setUnderlineText(false);
    }

    @Override
    public void onClick(View widget) {
        switch (type) {
            case "《用户协议》":
                intent = new Intent(context, HtmlActivity.class);
                intent.putExtra("html", "user_agreement");
                context.startActivity(intent);
                break;
            case "《隐私政策》":
                intent = new Intent(context, HtmlActivity.class);
                intent.putExtra("html", "privacy_policy");
                context.startActivity(intent);
                break;
        }
    }
}

