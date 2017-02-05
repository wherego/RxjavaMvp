package com.mvp.ztt.rxjavamvp.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhangtaotao on 17/2/5.
 * 描述:
 */

public interface IViewDelegate {
    void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    View getRootView();

    void initWidget();

    Toolbar getToolbar();

    int getOptionsMenuId();
}
