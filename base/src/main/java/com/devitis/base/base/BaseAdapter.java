package com.devitis.base.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diana on 20.03.2019.
 */

public abstract class BaseAdapter<T, H extends BaseAdapter.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> dataList = new ArrayList<>();

    public abstract H createHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        T data = dataList.get(position);
        ((ViewHolder) holder).bindData(data);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createHolder(parent, viewType);
    }

    public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void bindData(T data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setData(List<? extends T> data) {
        dataList.clear();
        if (data != null) {
            dataList.addAll(data);
        }
        notifyDataSetChanged();
    }

}
