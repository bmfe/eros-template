package com.benmu.wx.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;

import com.benmu.framework.BMWXEnvironment;
import com.benmu.framework.activity.AbstractWeexActivity;
import com.benmu.framework.constant.Constant;
import com.benmu.framework.manager.impl.GlobalEventManager;
import com.benmu.framework.model.RouterModel;
import com.benmu.framework.model.WeexEventBean;
import com.benmu.framework.view.TableView;
import com.benmu.wx.R;
import com.taobao.weex.WXSDKInstance;

public class MainActivity extends AbstractWeexActivity {
    private FrameLayout layout_container;
    private ViewStub vs_tabView;
    private TableView tableView;

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
        tableView = (TableView) findViewById(R.id.tabView);
        tableView.setData(BMWXEnvironment.mPlatformConfig.getTabBar());

    }

    @Override
    public boolean navigationListenter(WeexEventBean weexEventBean) {
        if (tableView != null) {
            return tableView.setNaigation(weexEventBean);
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (isHomePage() && BMWXEnvironment.mPlatformConfig.isAndroidIsListenHomeBack()) {
                WXSDKInstance wxsdkInstance = getWXSDK();
                if (wxsdkInstance != null) {
                    GlobalEventManager.homeBack(wxsdkInstance);
                    return true;
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private WXSDKInstance getWXSDK() {
        return (tableView != null) ? tableView.getWXSDKInstance() : getWXSDkInstance();

    }
}
