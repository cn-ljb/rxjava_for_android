package com.che58.ljb.rxjava.protocol2;

import com.che58.ljb.rxjava.model.DeleteModel;
import com.che58.ljb.rxjava.model.GetModel;
import com.che58.ljb.rxjava.model.PostModel;
import com.che58.ljb.rxjava.model.PutModel;
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
    public Observable<GetModel> testGet() {
        return createObservable(URL, XgoHttpClient.METHOD_GET, null, GetModel.class);
    }


    /**
     * Post请求
     */
    public Observable<PostModel> testPost(Map<String, Object> params) {
        return createObservable(URL, XgoHttpClient.METHOD_POST, params, PostModel.class);
    }

    /**
     * Put请求
     */
    public Observable<PutModel> testPut(Map<String, Object> params) {
        return createObservable(URL, XgoHttpClient.METHOD_PUT, params, PutModel.class);
    }

    /**
     * Delete请求
     */
    public Observable<DeleteModel> testDelete() {
        return createObservable(URL, XgoHttpClient.METHOD_DELETE, null, DeleteModel.class);
    }

}
