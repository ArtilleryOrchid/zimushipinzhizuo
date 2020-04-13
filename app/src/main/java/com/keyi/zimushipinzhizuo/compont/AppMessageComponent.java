package com.keyi.zimushipinzhizuo.compont;

import com.keyi.zimushipinzhizuo.modules.AppMessageModules;
import com.keyi.zimushipinzhizuo.ui.activity.mine.About_US_Activity;

import dagger.Component;
import dagger.Module;

@Component(modules = AppMessageModules.class)
public interface AppMessageComponent {
    void inject(About_US_Activity activity);
}
