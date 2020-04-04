package com.huopaolan.lib_core.Mvp.Presenter;

import com.huopaolan.lib_core.Mvp.Model.IModel;
import com.huopaolan.lib_core.Mvp.View.IView;

public class BasePresenter<V extends IView, M extends IModel> implements IPresenter {
    protected V v; //实现IView对应的类
    protected M m; //实现IModel对应的类

    public BasePresenter(V v, M m) {
        this.v = v;
        this.m = m;
    }

    @Override
    public void destroy() {
        if (m != null) {
            m.destroy();
        }
        //m对象置空
        m = null;
        //v对象置空
        v = null;
    }
}
