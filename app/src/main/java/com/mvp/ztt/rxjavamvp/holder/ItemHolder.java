package com.mvp.ztt.rxjavamvp.holder;

import android.view.View;
import android.widget.TextView;

import com.mvp.ztt.rxjavamvp.R;
import com.mvp.ztt.rxjavamvp.model.bean.Repo;



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
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
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
