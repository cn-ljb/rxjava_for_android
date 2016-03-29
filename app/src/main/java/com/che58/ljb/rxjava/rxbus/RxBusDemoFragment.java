package com.che58.ljb.rxjava.rxbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.che58.ljb.rxjava.R;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;

/**
 * RxBus Demo
 */
public class RxBusDemoFragment extends RxFragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_rxbus_demo, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.demo_rxbus_frag_1, new RxBusDemo_TopFragment())
                .replace(R.id.demo_rxbus_frag_2, new RxBusDemo_Bottom3Fragment())
                .commit();
    }

    public static class TapEvent {
    }
}