package com.mvp.ztt.rxjavamvp.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jakewharton.rxbinding.view.RxView;

import java.util.concurrent.TimeUnit;


/**
 * Created by zhangtaotao on 17/2/5.
 * 描述:
 */

public abstract class BaseHolder<D> extends RecyclerView.ViewHolder {
    protected OnViewClickListener mOnViewClickListener = null;
    private D data;

    public BaseHolder(View itemView) {
        super(itemView);

        RxView.clicks(itemView)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(aVoid -> {
                    click(itemView);
                });
    }

    /**
     * 设置数据
     *
     * @param data
     */
    public void setData(D data) {
        this.data = data;
    }

    public D getData() {
        return data;
    }

    /**
     * 刷新页面
     */
    public abstract void refresh();

    protected void click(View view) {
        if (mOnViewClickListener != null) {
            mOnViewClickListener.onViewClick(view, getAdapterPosition(), data);
        }
    }

    public interface OnViewClickListener<D> {
        void onViewClick(View view, int position, D data);
    }

    public void setOnItemClickListener(OnViewClickListener listener) {
        this.mOnViewClickListener = listener;
    }
}
