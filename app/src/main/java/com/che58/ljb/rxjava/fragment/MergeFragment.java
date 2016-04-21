package com.che58.ljb.rxjava.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.che58.ljb.rxjava.R;
import com.che58.ljb.rxjava.model.Contacter;
import com.che58.ljb.rxjava.utils.XgoLog;
import com.che58.ljb.rxjava.view.ProgressWheel;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * merge操作符
 * 可以将多个Observables的输出合并，就好像它们是一个单个的Observable一样
 * <p/>
 * Demo:模拟先读取(1s)本地缓存数据，再读取(3s)网络数据
 * Created by zjh on 2016/3/26.
 */
public class MergeFragment extends RxFragment {
    private static final String LOCATION = "location:";

    @Bind(R.id.view_load)
    ProgressWheel loadView;

    @Bind(R.id.lv_list)
    ListView lv_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_merge, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mergeDemo();
    }

    private void mergeDemo() {
        Observable.merge(
                getDataFromLocation(),
                getDataFromNet()
        ).compose(this.<List<Contacter>>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Contacter>>() {
                    @Override
                    public void call(List<Contacter> contacters) {
                        initPage(contacters);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }

    private void initPage(List<Contacter> contacters) {
        loadView.setVisibility(View.GONE);
        XgoLog.d(contacters.toString());
        lv_list.setAdapter(new ArrayAdapter<>(getActivity(), R.layout.item_list, R.id.tv_text, contacters));
    }

    private Observable<List<Contacter>> getDataFromNet() {
        return Observable.create(new Observable.OnSubscribe<List<Contacter>>() {
            @Override
            public void call(Subscriber<? super List<Contacter>> subscriber) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ArrayList<Contacter> contacters = new ArrayList<>();
                contacters.add(new Contacter("net:Zeus"));
                contacters.add(new Contacter("net:Athena"));
                contacters.add(new Contacter("net:Prometheus"));
                subscriber.onNext(contacters);
                subscriber.onCompleted();
            }
        });
    }


    private Observable<List<Contacter>> getDataFromLocation() {
        return Observable.create(new Observable.OnSubscribe<List<Contacter>>() {
            @Override
            public void call(Subscriber<? super List<Contacter>> subscriber) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<Contacter> datas = new ArrayList<>();
                datas.add(new Contacter(LOCATION + "张三"));
                datas.add(new Contacter(LOCATION + "李四"));
                datas.add(new Contacter(LOCATION + "王五"));

                subscriber.onNext(datas);
                subscriber.onCompleted();
            }
        });
    }

}
