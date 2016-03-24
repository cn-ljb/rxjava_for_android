package com.che58.ljb.rxjava.act;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.che58.ljb.rxjava.R;
import com.che58.ljb.rxjava.fragment.MainFragment;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_content, new MainFragment(), MainFragment.class.getName())
                .commit();
    }
}
