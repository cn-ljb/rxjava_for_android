package com.che58.ljb.rxjava.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.che58.ljb.rxjava.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.subjects.PublishSubject;

/**
 * PublishSubject Demo 顶部Fragment
 * Created by ljb on 2016/3/28.
 */
public class PublishSubjectTopFragment extends RxFragment {

    @Bind(R.id.et_input)
    EditText et_input;

    private final PublishSubject<String> publishSubject;

    public PublishSubjectTopFragment(PublishSubject<String> publishSubject) {
        this.publishSubject = publishSubject;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_publish_top  , null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick(R.id.btn_send)
    void sendToBottom(){
        String result = et_input.getText().toString().trim();
        publishSubject.onNext(result);
    }
}
