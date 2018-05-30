package com.benmu.wx.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;

import com.benmu.framework.BMWXEnvironment;
import com.benmu.framework.activity.AbstractWeexActivity;
import com.benmu.framework.constant.Constant;
import com.benmu.framework.model.RouterModel;
import com.benmu.framework.model.WeexEventBean;
import com.benmu.framework.view.TabbleView;
import com.benmu.wx.R;
import com.taobao.weex.bridge.JSCallback;

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

    @Override
    public boolean navigationListenter(WeexEventBean weexEventBean) {
        if (tabbleView != null) {
            return tabbleView.setNaigation(weexEventBean);
        }
        return false;
    }
}
