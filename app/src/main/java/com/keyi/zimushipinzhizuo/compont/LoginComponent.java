package com.keyi.zimushipinzhizuo.compont;

import com.keyi.zimushipinzhizuo.modules.LoginModules;
import com.keyi.zimushipinzhizuo.ui.activity.login.LoginActivity;

import dagger.Component;

@Component(modules = LoginModules.class)
public interface LoginComponent {
    void inject(LoginActivity activity);
}
