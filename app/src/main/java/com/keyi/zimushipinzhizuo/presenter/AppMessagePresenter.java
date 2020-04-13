package com.keyi.zimushipinzhizuo.presenter;

import com.google.gson.Gson;
import com.huopaolan.lib_core.Base.BaseEntity;
import com.huopaolan.lib_core.Mvp.Presenter.BasePresenter;
import com.keyi.zimushipinzhizuo.bean.AppEntity;
import com.keyi.zimushipinzhizuo.contract.AppMessageContract;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class AppMessagePresenter extends BasePresenter<AppMessageContract.AppMessageIView, AppMessageContract.AppMessageIModel> {

    @Inject
    public AppMessagePresenter(AppMessageContract.AppMessageIView appMessageIView, AppMessageContract.AppMessageIModel appMessageIModel) {
        super(appMessageIView, appMessageIModel);
    }

    public void AppRequest(String appName, String brand, String channel, String deviceModel, String deviceType, String uuid, String version) {
        Map<String, String> map = new HashMap<>();
        map.put("appName", appName);
        map.put("brand", brand);
        map.put("channel", channel);
        map.put("deviceModel", deviceModel);
        map.put("deviceType", deviceType);
        map.put("uuid", uuid);
        map.put("version", version);
        String jsonStr = new Gson().toJson(map);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonStr);
        m.app_message_request(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<AppEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity<AppEntity> appMessageEntity) {
                        if (appMessageEntity == null) {
                            return;
                        } else {
                            v.AppMessageSuccess(appMessageEntity);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        v.AppMessageError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
