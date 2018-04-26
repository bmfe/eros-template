package com.benmu.wx;

import android.app.Application;

import com.benmu.framework.BMInitConfig;
import com.benmu.framework.BMWXApplication;
import com.benmu.framework.BMWXEngine;
import com.benmu.framework.constant.Constant;

/**
 * Created by Carry on 2017/8/23.
 */

public class App extends BMWXApplication {
    public Application mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Constant.setApplicationId(BuildConfig.PAGE_PREFIX);
    }

}
