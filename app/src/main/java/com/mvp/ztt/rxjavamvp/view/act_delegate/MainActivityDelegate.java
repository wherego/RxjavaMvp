package com.mvp.ztt.rxjavamvp.view.act_delegate;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.mvp.ztt.rxjavamvp.R;
import com.mvp.ztt.rxjavamvp.adapter.TestAdapter;
import com.mvp.ztt.rxjavamvp.model.bean.Repo;
import com.mvp.ztt.rxjavamvp.view.AppViewDelegate;

import java.util.List;


/**
 * Created by zhangtaotao on 17/2/5.
 * 描述:
 */

public class MainActivityDelegate extends AppViewDelegate {
    private Toolbar toolbar;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private TestAdapter adapter;

    @Override
    public int getRootLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {
        toolbar = get(R.id.toolbar);
        refreshLayout = get(R.id.swiperefreshlayout);
        recyclerView = get(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(null);
        adapter = new TestAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void refreshView(List<Repo> repos) {
        refreshLayout.setRefreshing(false);
        adapter.init(repos);
    }

    @Override
    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    public int getOptionsMenuId() {
        return R.menu.menu_main;
    }

    public void setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener listener) {
        refreshLayout.setOnRefreshListener(listener);
    }
}
