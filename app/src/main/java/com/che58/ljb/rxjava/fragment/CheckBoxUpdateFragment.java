package com.che58.ljb.rxjava.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.che58.ljb.rxjava.R;
import com.f2prateek.rx.preferences.Preference;
import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.jakewharton.rxbinding.widget.RxCompoundButton;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * 随着CheckBox状态发生改变UI而改变
 * Created by ljb on 2016/3/24.
 */
public class CheckBoxUpdateFragment extends RxFragment {

    @Bind(R.id.cb_1)
    CheckBox checkBox1;

    @Bind(R.id.cb_2)
    CheckBox checkBox2;

    @Bind(R.id.btn_login)
    Button btn_login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkbox_update, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        check_update1();
        check_update2();
    }

    /**
     * 同步SharedPreferences
     */
    private void check_update1() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        RxSharedPreferences rxPreferences = RxSharedPreferences.create(preferences);
        Preference<Boolean> xxFunction = rxPreferences.getBoolean("xxFunction", false);

        checkBox1.setChecked(xxFunction.get());

        RxCompoundButton.checkedChanges(checkBox1)
                .subscribe(xxFunction.asAction());
    }

    /**
     * 同步UI
     */
    private void check_update2() {
        RxCompoundButton.checkedChanges(checkBox2)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        btn_login.setClickable(aBoolean);
                        btn_login.setBackgroundResource(aBoolean ? R.color.can_login : R.color.not_login);
                    }
                });
    }

    @OnClick(R.id.btn_login)
    void login(){
        Toast.makeText(getActivity(), R.string.login, Toast.LENGTH_SHORT).show();
    }


}
