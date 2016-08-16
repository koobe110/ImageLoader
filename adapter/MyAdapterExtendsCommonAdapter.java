package com.along.imageloader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.along.imageloader.R;
import com.along.imageloader.util.ImageLoader;

import java.util.List;

public class MyAdapterExtendsCommonAdapter extends CommonAdapter {

    private Context mContext;
    private List<String> mData;
    private String mDirPath;
    private LayoutInflater mInflater;
    private ImageLoader mImageLoader;

    public MyAdapterExtendsCommonAdapter(Context context, List<String> mData, String dirPath) {
        super(context,mData,R.layout.grid_item);
        this.mDirPath = dirPath;
        mImageLoader = ImageLoader.getInstance(4, ImageLoader.Type.LIFO);
    }



    @Override
    protected void convert(CommonViewHolder viewHolder, Object o) {
        ImageView imageView = (ImageView) viewHolder.getView(R.id.id_item_image);
        viewHolder.setImageResource(R.id.id_item_image,R.mipmap.friends_sends_pictures_no);
        //使用Imageloader去加载图片
        mImageLoader.loadImage(mDirPath + "/" + (String)o, (ImageView) viewHolder.getView(R.id.id_item_image));

    }



}