package com.che58.ljb.rxjava;

import android.app.Application;

/**
 * Demo Application
 * Created by ljb on 2016/3/23.
 */
public class DemoApplication extends Application {

    private static Application mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }

    public static Application getApplaction(){
        return mApp;
    }
}
