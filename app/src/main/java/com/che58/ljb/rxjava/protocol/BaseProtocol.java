package com.che58.ljb.rxjava.protocol;

import android.text.TextUtils;

import com.che58.ljb.rxjava.net.XgoHttpClient;
import com.squareup.okhttp.Request;

import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * BaseProtocol
 * Created by Ljb on 2015/12/22.
 */
public abstract class BaseProtocol {


    /**
     *  创建一个工作在IO线程的被观察者(被订阅者)对象
     *  @param url
     *  @param method
     *  @param params
     */
    protected  Observable<String> createObservable(final String url, final String method, final Map<String, Object> params) {
        return Observable.create(new Observable.OnSubscribe<String>() {                         //  (2)
            @Override
            public void call(Subscriber<? super String> subscriber) {
                Request request = XgoHttpClient.getClient().getRequest(url, method, params);    //  (3)
                String json = XgoHttpClient.getClient().execute2String(request);                //  (4)
                setData(subscriber, json);                                                      //  (5)
            }
        }).subscribeOn(Schedulers.io());
    }


    /**
     * 为观察者（订阅者）设置返回数据
     * */
    protected  void setData(Subscriber<? super String> subscriber, String json) {
        if (TextUtils.isEmpty(json)) {                          //  (6)
            subscriber.onError(new Throwable("not data"));
            subscriber.onCompleted();
            return;
        }
        subscriber.onNext(json);                                //  (7)
        subscriber.onCompleted();
    }
}
