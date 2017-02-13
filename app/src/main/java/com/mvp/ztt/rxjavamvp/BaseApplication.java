package com.mvp.ztt.rxjavamvp;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by zhangtaotao on 17/2/5.
 * 描述:
 */

public class BaseApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }

}
