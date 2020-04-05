package com.keyi.zimushipinzhizuo.ui.widget.span;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

import com.keyi.zimushipinzhizuo.R;

public class MyClickText extends ClickableSpan {
    private Context context;
    private String type;

    public MyClickText(Context context, String type) {
        this.context = context;
        this.type = type;
    }

    @Override
    public void updateDrawState(@NonNull TextPaint ds) {
        super.updateDrawState(ds);
        ds.setColor(Color.parseColor("#3099FB"));
        ds.setColor(context.getColor(R.color.dialog_span_color));
        ds.setUnderlineText(false);
    }

    @Override
    public void onClick(View widget) {
        Toast.makeText(context,type + " 发生了点击效果 ",Toast.LENGTH_SHORT).show();
    }


}

