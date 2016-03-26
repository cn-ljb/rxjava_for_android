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
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * 合并操作
 * Created by ljb on 2016/3/25.
 */
public class ZipFragment extends RxFragment {

    @Bind(R.id.view_load)
    ProgressWheel loadView;

    @Bind(R.id.lv_list)
    ListView lv_list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zip, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getContactData();
    }

    private void getContactData() {
        Observable.zip(
                queryContactsFromLocation(),
                queryContactsForNet(),
                new Func2<List<Contacter>, List<Contacter>, List<Contacter>>() {
                    @Override
                    public List<Contacter> call(List<Contacter> contacters, List<Contacter> contacters2) {
                        contacters.addAll(contacters2);
                        return contacters;
                    }
                }
        ).compose(this.<List<Contacter>>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Contacter>>() {
                    @Override
                    public void call(List<Contacter> contacters) {
                        initPage(contacters);
                    }
                });
    }

    private void initPage(List<Contacter> contacters) {
        loadView.setVisibility(View.GONE);
        XgoLog.d(contacters.toString());
        lv_list.setAdapter(new ArrayAdapter<Contacter>(getActivity(), R.layout.item_list, R.id.tv_text, contacters));
    }


    /**
     * 模拟网络联系人列表
     */
    private Observable<List<Contacter>> queryContactsForNet() {
        return Observable.create(new Observable.OnSubscribe<List<Contacter>>() {
            @Override
            public void call(Subscriber<? super List<Contacter>> subscriber) {

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ArrayList<Contacter> contacters = new ArrayList<>();
                contacters.add(new Contacter("Zeus"));
                contacters.add(new Contacter("Athena"));
                contacters.add(new Contacter("Prometheus"));
                subscriber.onNext(contacters);
                subscriber.onCompleted();
            }
        });
    }

    /**
     * 模拟手机本地联系人查询
     */
    private Observable<List<Contacter>> queryContactsFromLocation() {
        return Observable.create(new Observable.OnSubscribe<List<Contacter>>() {
            @Override
            public void call(Subscriber<? super List<Contacter>> subscriber) {

                ArrayList<Contacter> contacters = new ArrayList<>();
                contacters.add(new Contacter("张三"));
                contacters.add(new Contacter("李四"));
                contacters.add(new Contacter("王五"));
                subscriber.onNext(contacters);
                subscriber.onCompleted();
            }
        });
    }
}
