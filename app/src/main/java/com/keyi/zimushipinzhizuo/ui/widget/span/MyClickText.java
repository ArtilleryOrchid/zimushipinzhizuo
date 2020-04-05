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

    public MyClickText(Context context) {
        this.context = context;
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
        Toast.makeText(context,"发生了点击效果",Toast.LENGTH_SHORT).show();
    }


}

