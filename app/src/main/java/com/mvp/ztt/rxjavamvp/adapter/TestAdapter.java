package com.mvp.ztt.rxjavamvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvp.ztt.rxjavamvp.R;
import com.mvp.ztt.rxjavamvp.holder.BaseHolder;
import com.mvp.ztt.rxjavamvp.holder.ItemHolder;
import com.mvp.ztt.rxjavamvp.model.bean.Repo;
import com.mvp.ztt.rxjavamvp.utils.UIUtil;


/**
 * Created by zhangtaotao on 17/2/5.
 * 描述:
 */

public class TestAdapter extends BaseAdapter<Repo> {
    @Override
    protected BaseHolder getHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(UIUtil.getContext()).inflate(R.layout.item_holder, parent, false);
        ItemHolder itemHolder = new ItemHolder(inflate);
        return itemHolder;
    }
}
