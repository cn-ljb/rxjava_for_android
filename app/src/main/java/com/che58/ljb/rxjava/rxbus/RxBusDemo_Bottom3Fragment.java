package com.che58.ljb.rxjava.rxbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.che58.ljb.rxjava.R;
import com.che58.ljb.rxjava.act.MainActivity;
import com.trello.rxlifecycle.FragmentEvent;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.ConnectableObservable;

public class RxBusDemo_Bottom3Fragment extends RxFragment {

    @Bind(R.id.demo_rxbus_tap_txt)
    TextView _tapEventTxtShow;
    @Bind(R.id.demo_rxbus_tap_count)
    TextView _tapEventCountShow;
    private RxBus _rxBus;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_rxbus_bottom, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _rxBus = ((MainActivity) getActivity()).getRxBusSingleton();
    }

    @Override
    public void onStart() {
        super.onStart();

        //将普通的Observable转换为可连接的Observable
        ConnectableObservable<Object> tapEventEmitter = _rxBus.toObserverable().publish();

        tapEventEmitter
                .compose(this.bindToLifecycle())
                .subscribe(new Action1<Object>() { //一个一旦被触发就会显示TapText的监听者
            @Override
            public void call(Object event) {
                if (event instanceof RxBusDemoFragment.TapEvent) {
                    _showTapText();
                }
            }
        });

        tapEventEmitter
                .compose(this.bindUntilEvent(FragmentEvent.DESTROY))
                .publish(new Func1<Observable<Object>, Observable<List<Object>>>() {//一个出发后缓存一秒内的点击数并显示的监听者
                    @Override
                    public Observable<List<Object>> call(Observable<Object> stream) {
                        return stream.buffer(stream.debounce(1, TimeUnit.SECONDS)); //进行缓冲1秒，打包发送
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<List<Object>>() {
            @Override
            public void call(List<Object> taps) {
                _showTapCount(taps.size());
            }
        });

        tapEventEmitter.connect();  //可连接的Observable并不在订阅时触发，而需手动调用connect()方法
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    // -----------------------------------------------------------------------------------
    // Helper to show the text via an animation

    /**
     * 显示TapText
     */
    private void _showTapText() {
        _tapEventTxtShow.setVisibility(View.VISIBLE);
        _tapEventTxtShow.setAlpha(1f);
        ViewCompat.animate(_tapEventTxtShow).alphaBy(-1f).setDuration(400);
    }

    private void _showTapCount(int size) {
        _tapEventCountShow.setText(String.valueOf(size));
        _tapEventCountShow.setVisibility(View.VISIBLE);
        _tapEventCountShow.setScaleX(1f);
        _tapEventCountShow.setScaleY(1f);
        ViewCompat.animate(_tapEventCountShow)
                .scaleXBy(-1f)
                .scaleYBy(-1f)
                .setDuration(800)
                .setStartDelay(100);
    }
}
