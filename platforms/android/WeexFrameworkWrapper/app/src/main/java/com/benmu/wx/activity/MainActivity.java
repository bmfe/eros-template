package com.benmu.wx.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

import com.benmu.framework.BMWXEnvironment;
import com.benmu.framework.activity.AbstractWeexActivity;
import com.benmu.framework.constant.Constant;
import com.benmu.framework.model.RouterModel;
import com.benmu.framework.view.TabbleView;
import com.benmu.wx.R;
import com.umeng.socialize.UMShareAPI;

import java.lang.reflect.Field;

public class MainActivity extends AbstractWeexActivity {
    private FrameLayout layout_container;
    private ViewStub vs_tabView;
    private TabbleView tabbleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RouterModel tabble = (RouterModel) getIntent().getSerializableExtra(Constant.ROUTERPARAMS);
        if (Constant.TABBAR.equals(tabble.url)) {
            initTabView();
        } else {
            layout_container = (FrameLayout) findViewById(R.id.layout_container);
            initView();
            renderPage();
        }
    }

    private void initView() {
        mContainer = (ViewGroup) findViewById(R.id.layout_container);
    }

    private void initTabView() {
        vs_tabView = (ViewStub) findViewById(R.id.vs_tabView);
        vs_tabView.inflate();
        tabbleView = (TabbleView) findViewById(R.id.tabView);
        tabbleView.setData(BMWXEnvironment.mPlatformConfig.getTabBar());

    }
}
