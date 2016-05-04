package com.che58.ljb.rxjava.fragment.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.che58.ljb.rxjava.R;
import com.che58.ljb.rxjava.fragment.BufferFragment;
import com.che58.ljb.rxjava.fragment.CheckBoxUpdateFragment;
import com.che58.ljb.rxjava.fragment.LoopFragment;
import com.che58.ljb.rxjava.fragment.MergeFragment;
import com.che58.ljb.rxjava.fragment.Net2Fragment;
import com.che58.ljb.rxjava.fragment.PublishSubjectFragment;
import com.che58.ljb.rxjava.fragment.ReuseSubscriberFragment;
import com.che58.ljb.rxjava.fragment.TimerFragment;
import com.che58.ljb.rxjava.fragment.ZipFragment;
import com.che58.ljb.rxjava.fragment.NetFragment;
import com.che58.ljb.rxjava.fragment.NotMoreClickFragment;
import com.che58.ljb.rxjava.fragment.DebounceFragment;
import com.che58.ljb.rxjava.rxbus.RxBusDemoFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主菜单Fragment
 * Created by ljb on 2016/3/23.
 */
public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_net)
    void btn_net() {
        open(new NetFragment());
    }

    @OnClick(R.id.btn_net2)
    void btn_net2() {
        open(new Net2Fragment());
    }

    @OnClick(R.id.btn_not_more_click)
    void btn_not_more_click() {
        open(new NotMoreClickFragment());
    }

    @OnClick(R.id.btn_checkbox_state_update)
    void btn_checkbox_update() {
        open(new CheckBoxUpdateFragment());
    }

    @OnClick(R.id.btn_text_change)
    void btn_text_change() {
        open(new DebounceFragment());
    }

    @OnClick(R.id.btn_buffer)
    void btn_buffer() {
        open(new BufferFragment());
    }

    @OnClick(R.id.btn_zip)
    void btn_zip() {
        open(new ZipFragment());
    }

    @OnClick(R.id.btn_merge)
    void btn_merage() {
        open(new MergeFragment());
    }

    @OnClick(R.id.btn_loop)
    void btn_loop() {
        open(new LoopFragment());
    }

    @OnClick(R.id.btn_timer)
    void btn_timer() {
        open(new TimerFragment());
    }

    @OnClick(R.id.btn_publish)
    void btn_publish() {
        open(new PublishSubjectFragment());
    }

    @OnClick(R.id.btn_rxbus)
    void btn_rxbus() {
        open(new RxBusDemoFragment());
    }

    @OnClick(R.id.btn_reuse_subscriber)
    void btn_reuseSubscriber(){
        open(new ReuseSubscriberFragment());
    }
    /**
     * 开启新的Fragment
     */
    private void open(Fragment fragment) {
        final String tag = fragment.getClass().toString();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(tag)
                .replace(R.id.main_content, fragment, tag)
                .commit();
    }

}
