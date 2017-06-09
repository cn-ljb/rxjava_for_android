package com.che58.ljb.rxjava.protocol;

import com.che58.ljb.rxjava.net.XgoHttpClient;

import java.util.Map;

import rx.Observable;

/**
 * 测试接口
 * Created by ljb on 2016/3/23.
 */
public class TestProtocol extends BaseProtocol {

    private static final String URL = "http://integer.wang/init/json.shtml";

    /**
     * Get请求
     */
    public Observable<String> testGet() {
        return createObservable(URL, XgoHttpClient.METHOD_GET, null);   // (1)
    }


    /**
     * Post请求
     */
    public Observable<String> testPost(Map<String , Object> params) {
        return createObservable(URL, XgoHttpClient.METHOD_POST, params);
    }

    /**
     * Put请求
     */
    public Observable<String> testPut(Map<String , Object> params) {
        return createObservable(URL, XgoHttpClient.METHOD_PUT, params);
    }

    /**
     * Delete请求
     */
    public Observable<String> testDelete() {
        return createObservable(URL, XgoHttpClient.METHOD_DELETE, null);
    }

}
