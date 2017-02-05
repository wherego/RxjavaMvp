package com.mvp.ztt.rxjavamvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvp.ztt.rxjavamvp.R;
import com.mvp.ztt.rxjavamvp.holder.ItemHolder;
import com.mvp.ztt.rxjavamvp.model.bean.Repo;
import com.mvp.ztt.rxjavamvp.utils.UIUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangtaotao on 17/2/5.
 * 描述:
 */

public class TestAdapter extends RecyclerView.Adapter<ItemHolder> {
    private List<Repo> list = new ArrayList<>();

    public TestAdapter() {
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(UIUtil.getContext()).inflate(R.layout.item_holder, null, false);
        ItemHolder itemHolder = new ItemHolder(inflate);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        Repo repo = list.get(position);
        holder.setData(repo);
        holder.refresh();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void init(List<Repo> repos) {
        list.clear();
        list.addAll(repos);
        notifyDataSetChanged();
    }
}
