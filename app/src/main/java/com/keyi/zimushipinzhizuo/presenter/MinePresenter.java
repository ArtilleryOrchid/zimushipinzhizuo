package com.keyi.zimushipinzhizuo.presenter;

import com.google.gson.Gson;
import com.huopaolan.lib_core.Base.BaseEntity;
import com.huopaolan.lib_core.Mvp.Presenter.BasePresenter;
import com.keyi.zimushipinzhizuo.bean.AppEntity;
import com.keyi.zimushipinzhizuo.contract.MineContract;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MinePresenter extends BasePresenter<MineContract.MineIView, MineContract.MineIModel> {
    @Inject
    public MinePresenter(MineContract.MineIView mineIView, MineContract.MineIModel mineIModel) {
        super(mineIView, mineIModel);
    }

    /**
     * 请求退出登录
     *
     * @param accountId
     * @param appName
     * @param brand
     * @param channel
     * @param deviceModel
     * @param deviceType
     * @param headImg
     * @param uuid
     * @param version
     */
    public void LogoutRequest(String accountId, String appName, String brand, String channel, String deviceModel, String deviceType, String headImg, String uuid, String version) {
        Map<String, String> map = new HashMap<>();
        if (accountId.equals("")) {
            map.put("accountId", "");
        } else {
            map.put("accountId", accountId);
        }
        map.put("appName", appName);
        map.put("brand", brand);
        map.put("channel", channel);
        map.put("deviceModel", deviceModel);
        map.put("deviceType", deviceType);
        map.put("headImg", headImg);
        map.put("uuid", uuid);
        map.put("version", version);
        String jsonStr = new Gson().toJson(map);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonStr);
        m.logout_request(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<AppEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity<AppEntity> entity) {
                        if (entity == null) {
                            return;
                        } else {
                            v.logoutSuccess(entity);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        v.logoutError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
