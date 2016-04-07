package com.che58.ljb.rxjava.protocol2;

import com.che58.ljb.rxjava.model.DeleteModel;
import com.che58.ljb.rxjava.model.GetModel;
import com.che58.ljb.rxjava.model.PostModel;
import com.che58.ljb.rxjava.model.PutModel;
import com.che58.ljb.rxjava.net.XgoHttpClient;

import java.util.TreeMap;

import rx.Observable;

/**
 * 测试接口
 * Created by ljb on 2016/3/23.
 */
public class TestProtocol extends BaseProtocol {

    private static final String BASE_URL = "http://service.test.xgo.com.cn:8080/app/v1/demo/";

    /**
     * Get请求
     */
    public Observable<GetModel> text_Get() {
        String path = "1";
        return createObservable(BASE_URL + path, XgoHttpClient.METHOD_GET, null, GetModel.class);
    }


    /**
     * Post请求
     */
    public Observable<PostModel> text_Post(TreeMap<String, Object> params) {
        return createObservable(BASE_URL, XgoHttpClient.METHOD_POST, params, PostModel.class);
    }

    /**
     * Put请求
     */
    public Observable<PutModel> text_Put(TreeMap<String, Object> params) {
        return createObservable(BASE_URL, XgoHttpClient.METHOD_PUT, params, PutModel.class);
    }

    /**
     * Delete请求
     */
    public Observable<DeleteModel> text_Delete() {
        String path = "1";
        return createObservable(BASE_URL + path, XgoHttpClient.METHOD_DELETE, null, DeleteModel.class);
    }

}
