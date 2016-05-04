package com.che58.ljb.rxjava.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.che58.ljb.rxjava.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

/**
 * 复用订阅者Demo
 * Created by ljb on 2016/4/29.
 */
public class ReuseSubscriberFragment extends RxFragment {


    private Observer mReuseSubscriber;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reuse_subscriber, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        //订阅者
        mReuseSubscriber = new Observer<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object data) {
                if (data.getClass() == Integer.class) {
                    Toast.makeText(getActivity(), "The data from Btn1!", Toast.LENGTH_SHORT).show();
                } else if (data.getClass() == String.class) {
                    Toast.makeText(getActivity(), "The data from Btn2!", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    //被观察者1
    @OnClick(R.id.btn1)
    void btn1() {
        Observable.just(1)
                .compose(this.<Integer>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mReuseSubscriber);
    }

    //被观察者2
    @OnClick(R.id.btn2)
    void btn2() {
        Observable.just("string")
                .compose(this.<String>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mReuseSubscriber);
    }
}
