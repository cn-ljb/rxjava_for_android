package com.che58.ljb.rxjava.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.che58.ljb.rxjava.R;
import com.che58.ljb.rxjava.model.DeleteModel;
import com.che58.ljb.rxjava.model.GetModel;
import com.che58.ljb.rxjava.model.PostModel;
import com.che58.ljb.rxjava.model.PutModel;
import com.che58.ljb.rxjava.protocol2.TestProtocol;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.TreeMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * RxJava+OkHttp+Gson
 * Created by ljb on 2016/4/7.
 */
public class Net2Fragment extends RxFragment {
    @Bind(R.id.tv_result)
    TextView tv_reuslt;

    @Bind(R.id.tv_msg)
    TextView tv_msg;

    private TestProtocol mTestProtocol;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_net, null);
        ButterKnife.bind(this, view);
        tv_msg.setText(R.string.des_demo_net2);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTestProtocol = new TestProtocol();
    }

    @OnClick(R.id.btn_get)
    void click_get() {
        mTestProtocol.text_Get()
                .compose(this.<GetModel>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<GetModel>() {
                    @Override
                    public void call(GetModel data) {
                        tv_reuslt.setText("Get Result:\r\n" + data);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        tv_reuslt.setText("Get Error:\r\n" + throwable.getMessage());
                    }
                });
    }

    @OnClick(R.id.btn_post)
    void click_post() {
        TreeMap<String, Object> params = new TreeMap<>();
        params.put("name", "Zeus");
        mTestProtocol.text_Post(params)
                .compose(this.<PostModel>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<PostModel>() {
                    @Override
                    public void call(PostModel s) {
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
        mTestProtocol.text_Put(params)
                .compose(this.<PutModel>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<PutModel>() {
                    @Override
                    public void call(PutModel data) {
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
        mTestProtocol.text_Delete()
                .compose(this.<DeleteModel>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<DeleteModel>() {
                    @Override
                    public void call(DeleteModel data) {
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
