package com.example.sanusianwar.mindvalleychallenge.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.sanusianwar.mindvalleychallenge.R;
import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.interfaces.IMDownloadDataType;
import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.models.MDownloadDataType;
import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.models.MDownloadDataTypeImage;
import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.utilities.MProviderMDownloadDataType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SanusiAnwar on 7/24/2017.
 */

public class ImageAdapter extends BaseAdapter {
    //
    private Context mContext;
    private MProviderMDownloadDataType mProvider;
    public List<String> imgUrlArray = new ArrayList<>();

    //
    public ImageAdapter(Context c, List<String> imgUrlArray)
    {
        mContext = c;
        this.imgUrlArray = imgUrlArray;
        mProvider = MProviderMDownloadDataType.getInstance();
    }

    public void setImgUrlArray(List<String> imgUrlArray)
    {
        this.imgUrlArray = imgUrlArray;
    }

    @Override
    public int getCount()
    {
        return imgUrlArray.size();
    }

    @Override
    public Object getItem(int position)
    {
        return imgUrlArray.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        //
        final ImageView imageView = new ImageView(mContext);
        //
        MDownloadDataType mDataTypeImageCancel = new MDownloadDataTypeImage(imgUrlArray.get(position), new IMDownloadDataType() {
            @Override
            public void onStart(MDownloadDataType mDownloadDataType)
            {
                //
            }

            @Override
            public void onSuccess(MDownloadDataType mDownloadDataType)
            {
                imageView.setImageBitmap(((MDownloadDataTypeImage) mDownloadDataType).getImageBitmap());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
            }

            @Override
            public void onFailure(MDownloadDataType mDownloadDataType, int statusCode, byte[] errorResponse, Throwable e)
            {
                imageView.setImageResource(R.drawable.ic_menu_gallery);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
            }

            @Override
            public void onRetry(MDownloadDataType mDownloadDataType, int retryNo)
            {
                //
            }
        });
        mProvider.getRequest(mDataTypeImageCancel);
        return imageView;
    }
}
