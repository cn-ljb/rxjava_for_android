package com.che58.ljb.rxjava.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.che58.ljb.rxjava.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * RxJava定时器
 * Created by ljb on 2016/3/28.
 */
public class TimerFragment extends RxFragment {

    @Bind(R.id.iv_welcome)
    ImageView iv_welcome;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        starTimer();
    }



    private void starTimer() {
        Observable.timer(3000 , TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<Long>bindToLifecycle())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        iv_welcome.setVisibility(View.VISIBLE);
                        ObjectAnimator
                                .ofFloat(iv_welcome, "alpha", 0.0F, 1.0F)
                                .setDuration(500)
                                .start();
                    }
                });
    }
}
