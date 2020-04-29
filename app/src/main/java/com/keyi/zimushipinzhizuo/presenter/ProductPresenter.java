package com.keyi.zimushipinzhizuo.presenter;

import com.google.gson.Gson;
import com.huopaolan.lib_core.Base.BaseEntity;
import com.huopaolan.lib_core.Mvp.Presenter.BasePresenter;
import com.keyi.zimushipinzhizuo.bean.AppEntity;
import com.keyi.zimushipinzhizuo.contract.AppContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ProductPresenter extends BasePresenter<AppContract.ProductIView, AppContract.AppIModel> {
    @Inject
    public ProductPresenter(AppContract.ProductIView productIView, AppContract.AppIModel appIModel) {
        super(productIView, appIModel);
    }

    /**
     * 创建支付订单
     *
     * @param accountId
     * @param appName
     * @param brand
     * @param channel
     * @param deviceModel
     * @param deviceType
     * @param headImg
     * @param productId
     * @param uuid
     * @param version
     */
    public void CreatePayRequest(String accountId, String appName, String brand, String channel, String deviceModel, String deviceType, String headImg, String productId, String uuid, String version) {
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
        map.put("productId", productId);
        map.put("uuid", uuid);
        map.put("version", version);
        String jsonStr = new Gson().toJson(map);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonStr);
        m.create_pay_request(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity<String> entity) {
                        if (entity == null) {
                            return;
                        } else {
                            v.CreatePaySuccess(entity);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        v.CreatePayError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 查询
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
    public void productRequest(String accountId, String appName, String brand, String channel, String deviceModel, String deviceType, String headImg, String uuid, String version) {
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
        m.product_request(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<ArrayList<AppEntity.Data>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity<ArrayList<AppEntity.Data>> entity) {
                        if (entity == null) {
                            return;
                        } else {
                            v.ProductSuccess(entity);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        v.ProductError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 支付类型
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
    public void PayRequest(String accountId, String appName, String brand, String channel, String deviceModel, String deviceType, String headImg, String uuid, String version) {
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
        m.pay_request(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<ArrayList<AppEntity.Pay>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity<ArrayList<AppEntity.Pay>> entity) {
                        if (entity == null) {
                            return;
                        } else {
                            v.PaySuccess(entity);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        v.PayError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 提交支付
     *
     * @param accountId
     * @param appId
     * @param appName
     * @param orderId
     * @param payChannel
     */
    public void SubmitRequest(String accountId, String appId, String appName, String orderId, String payChannel) {
        Map<String, String> map = new HashMap<>();
        if (accountId.equals("")) {
            map.put("accountId", "");
        } else {
            map.put("accountId", accountId);
        }
        map.put("appId", appId);
        map.put("appName", appName);
        map.put("orderId", orderId);
        map.put("payChannel", payChannel);
        String jsonStr = new Gson().toJson(map);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonStr);
        m.submit_request(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<AppEntity.Submit>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity<AppEntity.Submit> entity) {
                        if (entity == null) {
                            return;
                        } else {
                            v.SubmitSuccess(entity);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        v.SubmitError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
