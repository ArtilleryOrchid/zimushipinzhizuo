package com.keyi.zimushipinzhizuo.compont;


import android.app.Activity;

import com.keyi.zimushipinzhizuo.modules.AppModules;
import com.keyi.zimushipinzhizuo.ui.activity.login.LoginActivity;
import com.keyi.zimushipinzhizuo.ui.activity.mine.About_US_Activity;
import com.keyi.zimushipinzhizuo.ui.activity.mine.MineActivity;
import com.keyi.zimushipinzhizuo.ui.activity.mine.VIPActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModules.class
})
public interface AppComponent {
    void inject(LoginActivity activity);

    void inject(About_US_Activity activity);

    void inject(VIPActivity activity);

    void inject(MineActivity activity);
}