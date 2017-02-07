package com.mvp.ztt.rxjavamvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mvp.ztt.rxjavamvp.holder.BaseHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangtaotao on 17/2/7.
 * 描述:
 */

public abstract class BaseAdapter<D> extends RecyclerView.Adapter<BaseHolder> {
    protected List<D> list = new ArrayList<D>();
    protected OnRecyclerViewItemClickListener onItemClickListener = null;

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseHolder baseHolder = getHolder(parent, viewType);
        baseHolder.setOnItemClickListener(((view, position, data) -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(view, position, data);
            }
        }));
        return baseHolder;
    }

    protected abstract BaseHolder getHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        holder.setData(list.get(position));
        holder.refresh();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void init(List<D> l) {
        list.clear();
        list.addAll(l);
        notifyDataSetChanged();
    }

    public interface OnRecyclerViewItemClickListener<D> {
        void onItemClick(View view, int position, D data);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.onItemClickListener = listener;
    }
}
