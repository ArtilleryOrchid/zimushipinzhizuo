package com.keyi.zimushipinzhizuo.ui.activity.login;

import com.huopaolan.lib_core.Base.BaseActivity;
import com.keyi.zimushipinzhizuo.R;
import com.keyi.zimushipinzhizuo.compont.DaggerLoginComponent;
import com.keyi.zimushipinzhizuo.contract.LoginContract;
import com.keyi.zimushipinzhizuo.modules.LoginModules;
import com.keyi.zimushipinzhizuo.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.LoginIView {

    @Override
    public int layoutID() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void setUpDagger() {
        DaggerLoginComponent.builder().loginModules(new LoginModules(this)).build().inject(this);
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void loginSuccess(String entity) {

    }
}
