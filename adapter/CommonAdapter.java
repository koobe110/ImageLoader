package com.along.imageloader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/8/14.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected LayoutInflater mInflater;
    protected Context mContext;
    protected List<T> mData;
    protected int mLayoutId;

    public CommonAdapter(Context context, List<T> data,int layoutId) {
        mContext = context;
        mData = data;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int i) {
        return (T) mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CommonViewHolder viewHolder = CommonViewHolder.get(mContext, viewGroup,mLayoutId, i, view);
        convert(viewHolder,getItem(i));
        return viewHolder.getConvertView();
    }

    protected abstract void convert(CommonViewHolder viewHolder, T t);
}
