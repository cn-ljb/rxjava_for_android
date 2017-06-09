package com.che58.ljb.rxjava.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.che58.ljb.rxjava.R;
import com.che58.ljb.rxjava.protocol.TestProtocol;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.TreeMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * RxJava网络请求Demo
 * Created by ljb on 2016/3/23.
 */
public class NetFragment extends RxFragment {

    @Bind(R.id.tv_result)
    TextView tv_reuslt;

    private TestProtocol mTestProtocol;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_net, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTestProtocol = new TestProtocol();
    }

    @OnClick(R.id.btn_get)
    void click_get() {
        mTestProtocol.testGet()                            //  (1)
                .compose(this.<String>bindToLifecycle())    //  (2)
                .observeOn(AndroidSchedulers.mainThread())  //  (3)
                .subscribe(new Action1<String>() {          //  (4)
                    @Override
                    public void call(String data) {         //  (5)
                        tv_reuslt.setText("Get Result:\r\n" + data);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) { //  (6)
                        tv_reuslt.setText("Get Error:\r\n" + throwable.getMessage());
                    }
                });


    }

    @OnClick(R.id.btn_post)
    void click_post() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("name", "Zeus");
        mTestProtocol.testPost(params)
                .compose(this.<String>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        tv_reuslt.setText("Post Result:\r\n" + s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        tv_reuslt.setText("Post Error:\r\n" + throwable.getMessage());
                    }
                });
    }

    @OnClick(R.id.btn_put)
    void click_put() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("name", "Zeus");
        mTestProtocol.testPut(params)
                .compose(this.<String>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String data) {
                        tv_reuslt.setText("Put Result:\r\n" + data);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        tv_reuslt.setText("Put Error:\r\n" + throwable.getMessage());
                    }
                });
    }

    @OnClick(R.id.btn_delete)
    void click_delete() {
        mTestProtocol.testDelete()
                .compose(this.<String>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String data) {
                        tv_reuslt.setText("Delete Result:\r\n" + data);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        tv_reuslt.setText("Delete Error:\r\n" + throwable.getMessage());
                    }
                });
    }
}
