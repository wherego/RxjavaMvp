package com.mvp.ztt.rxjavamvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * Created by zhangtaotao on 17/2/5.
 * 描述:
 */

public class BaseActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
