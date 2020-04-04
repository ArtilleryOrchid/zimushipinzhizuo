package com.huopaolan.lib_core.Base;

/**
 * 设置规范:界面相关方法提取
 */
public interface IActivity {
    //返回关联布局
    int layoutID();

    //初始化控件
    void initView();

    //初始化数据
    void initData();

    //初始化dagger
    void setUpDagger();
}
