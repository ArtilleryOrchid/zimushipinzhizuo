package com.huopaolan.lib_core.Mvp.Model;

/**
 * msg:设置规范;提取公共部分destroy
 * 解除观察者订阅,防止内存泄露
 */
public interface IModel {
    /**
     * 销毁方法->负责销毁观察者
     */
    void destroy();
}
