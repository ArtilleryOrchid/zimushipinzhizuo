package com.keyi.zimushipinzhizuo.ui.activity.login;

import android.content.Intent;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.ui.activity.home.HomeActivity;

public class SplashActivity extends BaseActivity {
    private Thread myThread;

    @Override
    public int layoutID() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        myThread = new Thread() {//创建子线程
            @Override
            public void run() {
                try {
                    sleep(2000);//使程序休眠一秒
                    Intent it = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(it);
                    finish();//关闭当前活动
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    @Override
    public void initData() {
        myThread.start();//启动线程
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
}
