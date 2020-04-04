package com.huopaolan.lib_core.Mvp.View;

/**
 * msg:设置规范:showDialog 显示等待
 * hideDialog 隐藏等待;showMessage 提示错误信息
 */
public interface IView {
    /**
     * 显示等待对话框
     */
    void showDialog();

    /**
     * 隐藏等待对话框
     */
    void hideDialog();

    /**
     * 显示错误信息
     */
    void showMessage(String message);
}
