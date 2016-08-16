package com.along.imageloader.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/14.
 */
public class CommonViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;
    private int mPosition;

    public CommonViewHolder(Context context, ViewGroup viewGroup, int layout, int position) {
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layout, viewGroup, false);
        mConvertView.setTag(this);
    }

    public static CommonViewHolder get(Context context, ViewGroup viewGroup, int layout, int position, View convertView) {
        if (convertView == null) {
            return new CommonViewHolder(context, viewGroup, layout, position);
        }
        CommonViewHolder viewHolder = (CommonViewHolder) convertView.getTag();
        viewHolder.mPosition = position;
        return viewHolder;
    }

    /**
     * 通过id获取对应的控件，如果没有则加入views
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

    public CommonViewHolder setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    public CommonViewHolder setImageResource(int viewId, int resId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resId);
        return this;
    }
}
