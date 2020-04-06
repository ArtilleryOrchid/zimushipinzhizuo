package com.keyi.zimushipinzhizuo;

import android.app.Application;

import com.keyi.zimushipinzhizuo.utils.SPUtils;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SPUtils.getInstance().init(this, "files");
    }
}
