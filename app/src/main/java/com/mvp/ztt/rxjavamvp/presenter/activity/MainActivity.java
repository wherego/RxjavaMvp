package com.mvp.ztt.rxjavamvp.presenter.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MenuItem;
import android.widget.Toast;

import com.mvp.ztt.rxjavamvp.R;
import com.mvp.ztt.rxjavamvp.model.Api;
import com.mvp.ztt.rxjavamvp.model.bean.Repo;
import com.mvp.ztt.rxjavamvp.presenter.ActivityPresenter;
import com.mvp.ztt.rxjavamvp.utils.RxBus;
import com.mvp.ztt.rxjavamvp.view.act_delegate.MainActivityDelegate;
import com.trello.rxlifecycle.android.ActivityEvent;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends ActivityPresenter<MainActivityDelegate> implements SwipeRefreshLayout.OnRefreshListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        show();
    }

    private void show() {
        Api.getInstance().listRepos("octocat")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(new Subscriber<List<Repo>>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "onCompleted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, "onError", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(List<Repo> repos) {
                        viewDelegate.refreshView(repos);
                        Toast.makeText(MainActivity.this, "onNext", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void bindEventListener() {
        RxBus.getDefault().toObservable(R.id.text1, String.class)
                .subscribe(s -> {
                    Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                });
        RxBus.getDefault().toObservable(R.id.text2, String.class)
                .subscribe(s -> {
                    Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
                });
        viewDelegate.setOnRefreshListener(this);
    }

    @Override
    protected Class<MainActivityDelegate> getDelegateClass() {
        return MainActivityDelegate.class;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "action_search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_notification:
                Toast.makeText(this, "action_notification", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "action_settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                Toast.makeText(this, "action_about", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        show();
    }
}
