package com.mvp.ztt.rxjavamvp.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zhangtaotao on 17/2/5.
 * 描述:
 */

public abstract class BaseHolder<D> extends RecyclerView.ViewHolder {
    /**
     * 数据
     */
    private D mData;

    public BaseHolder(View itemView) {
        super(itemView);
    }

    /**
     * 设置数据
     */
    public void setData(D mData) {
        this.mData = mData;
    }

    /**
     * 返回数据
     *
     * @return
     */
    public D getData() {
        return mData;
    }

    /**
     * 把数据绑定到holder的控件上
     */
    public abstract void refresh();

}
