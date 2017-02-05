package com.mvp.ztt.rxjavamvp.utils;

import android.content.Context;

import com.mvp.ztt.rxjavamvp.BaseApplication;

/**
 * Created by zhangtaotao on 17/2/5.
 * 描述:
 */

public class UIUtil {
    private UIUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Context getContext() {
        return BaseApplication.getContext();
    }

}
