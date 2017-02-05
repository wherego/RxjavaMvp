package com.mvp.ztt.rxjavamvp.holder;

import android.view.View;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.mvp.ztt.rxjavamvp.R;
import com.mvp.ztt.rxjavamvp.model.bean.Repo;
import com.mvp.ztt.rxjavamvp.utils.RxBus;

import java.util.concurrent.TimeUnit;


/**
 * Created by zhangtaotao on 17/2/5.
 * 描述:
 */

public class ItemHolder extends BaseHolder<Repo> {
    private final TextView textView1;
    private final TextView textView2;
    private Repo data;

    public ItemHolder(View itemView) {
        super(itemView);
        textView1 = (TextView) itemView.findViewById(R.id.text1);
        textView2 = (TextView) itemView.findViewById(R.id.text2);
        //设置textView1点击事件
        RxView.clicks(textView1)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe((Void) -> {
                    RxBus.getDefault().post(R.id.text1, "code = " + data.getCode());
                });
        //设置textView2点击事件
        RxView.clicks(textView2)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe((Void) -> {
                    RxBus.getDefault().post(R.id.text2, "msg = " + data.getMsg());
                });
    }

    @Override
    public void refresh() {
        data = getData();
        int code = data.getCode();
        String msg = data.getMsg();
        textView1.setText(code + "---");
        textView2.setText(msg + "++++");
    }

}
