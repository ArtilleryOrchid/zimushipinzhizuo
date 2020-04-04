package com.huopaolan.lib_core.Base;

import android.view.LayoutInflater;
import android.view.View;

/**
 * 设置规范:界面相关方法提取
 */
public interface IFragment {
    //关联的View
    View createView(LayoutInflater inflater);

    //初始化控件
    void initView(View view);

    //初始化数据
    void initData();

    //初始化Dagger
    void setUpDagger();
}
