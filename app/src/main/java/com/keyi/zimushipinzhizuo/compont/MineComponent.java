package com.keyi.zimushipinzhizuo.compont;

import com.keyi.zimushipinzhizuo.modules.MineModules;
import com.keyi.zimushipinzhizuo.ui.activity.mine.MineActivity;

import dagger.Component;

@Component(modules = MineModules.class)
public interface MineComponent {
    void inject(MineActivity activity);
}
