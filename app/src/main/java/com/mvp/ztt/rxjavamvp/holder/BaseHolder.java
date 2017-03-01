package com.mvp.ztt.rxjavamvp.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;



/**
 * Created by zhangtaotao on 17/2/5.
 * 描述:
 */

public abstract class BaseHolder<D> extends RecyclerView.ViewHolder implements View.OnClickListener {
    protected OnViewClickListener mOnViewClickListener = null;
    private D data;

    public BaseHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        if (mOnViewClickListener != null) {
            mOnViewClickListener.onViewClick(v, getAdapterPosition(), data);
        }
    }

    public interface OnViewClickListener<D> {
        void onViewClick(View view, int position, D data);
    }

    public void setOnItemClickListener(OnViewClickListener listener) {
        this.mOnViewClickListener = listener;
    }
}
