package com.benmu.wx.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.alibaba.fastjson.JSON;
import com.benmu.erosplugingt.manager.GetuiManager;
import com.benmu.erospluginumeng.event.EventUmeng;
import com.benmu.erospluginumeng.model.UmengPlagformBean;
import com.benmu.framework.BMWXEnvironment;
import com.benmu.framework.constant.Constant;
import com.benmu.framework.constant.WXConstant;
import com.benmu.framework.constant.WXEventCenter;
import com.benmu.framework.manager.ManagerFactory;
import com.benmu.framework.manager.impl.ParseManager;
import com.benmu.framework.manager.impl.VersionManager;
import com.benmu.framework.manager.impl.dispatcher.DispatchEventManager;
import com.benmu.framework.model.RouterModel;
import com.benmu.framework.model.TitleModel;
import com.benmu.framework.model.WeexEventBean;
import com.benmu.wx.R;
import com.plugamap.manager.GeoManager;

/**
 * Created by Carry on 2017/8/23.
 */

public class SplashActivity extends Activity {
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
        initPlugin();
    }

    private void init() {
        final VersionManager versionManager = ManagerFactory.getManagerService(VersionManager
                .class);
        new Thread(new Runnable() {
            @Override
            public void run() {
                long prepareTime = versionManager.prepareJsBundle(SplashActivity.this);
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toHome();
                    }
                }, 2000 - prepareTime);
            }
        }).start();


    }

    private void initPlugin() {
        GetuiManager.pushInit(getApplication());
        GeoManager mGeoManager = ManagerFactory.getManagerService(GeoManager.class);
        mGeoManager.initAmap("a3308e6aef150346915922d2ea292590");
        EventUmeng umeng = new EventUmeng();
        umeng.initUM(getApplication(), "5a0194ad8f4a9d7f85000108");
        UmengPlagformBean bean = new UmengPlagformBean();
        bean.setAppKey("wxc47b78d8ef92e00c");
        bean.setAppSecret("641ac311fd075c1b61fd8dbddc3d8168");
        umeng.initPlatform(getApplication(), JSON.toJSONString(bean));
    }

    private void toHome() {
        String homePage = BMWXEnvironment.mPlatformConfig.getPage().getHomePage(this);
        String NavigationColor = BMWXEnvironment.mPlatformConfig.getPage().getNavBarColor();
        RouterModel router = new RouterModel(homePage, Constant.ACTIVITIES_ANIMATION
                .ANIMATION_PUSH, null, null, false, null);
        DispatchEventManager dispatchEventManager = ManagerFactory.getManagerService
                (DispatchEventManager.class);
        WeexEventBean eventBean = new WeexEventBean();
        eventBean.setKey(WXEventCenter.EVENT_OPEN);
        eventBean.setJsParams(ManagerFactory.getManagerService(ParseManager.class).toJsonString
                (router));
        eventBean.setContext(this);
        dispatchEventManager.getBus().post(eventBean);
        finish();
    }
}
