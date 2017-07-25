package com.example.sanusianwar.mindvalleychallenge.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.sanusianwar.mindvalleychallenge.FullImageActivity;
import com.example.sanusianwar.mindvalleychallenge.R;
import com.example.sanusianwar.mindvalleychallenge.adapter.ImageAdapter;
import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.interfaces.IMDownloadDataType;
import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.models.MDownloadDataType;
import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.models.MDownloadDataTypeJson;
import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.utilities.MProviderMDownloadDataType;
import com.example.sanusianwar.mindvalleychallenge.models.Board;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GalleryFragement extends Fragment {

    private MProviderMDownloadDataType mProvider;
    private Handler mHandler = new Handler();
    private String baseURL = "http://pastebin.com/raw/wgkJgazE";
    private GridView grid_view;
    private ImageAdapter mImageAdapter;

    public static GalleryFragement newInstance()
    {
        Bundle args = new Bundle();
        GalleryFragement fragment = new GalleryFragement();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_gallery_fragement, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        grid_view = (GridView) view.findViewById(R.id.grid_view);
        //
        mProvider = MProviderMDownloadDataType.getInstance();
        List<String> imgUrlArray = new ArrayList<>();
        mImageAdapter = new ImageAdapter(getContext(), imgUrlArray);
        //
        mProvider.clearTheCash();
        Toast.makeText(getContext(), "Cache - Gallery Feed Cleared", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        //
        if (id == R.id.action_refresh)
        {
            Toast.makeText(getContext(), "Refresh - Gallery Feed", Toast.LENGTH_SHORT).show();
            List<String> imgUrlArray = new ArrayList<>();
            mImageAdapter.setImgUrlArray(imgUrlArray);
            grid_view.setAdapter(mImageAdapter);
            mHandler.postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    runGetJson();
                }
            }, 1000);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void runGetJson() {
        int i = 0;
        //
        MDownloadDataType mDataTypeJson = new MDownloadDataTypeJson(baseURL, new IMDownloadDataType()
        {
            @Override
            public void onStart(MDownloadDataType mDownloadDataType)
            {
                //
            }

            @Override
            public void onSuccess(final MDownloadDataType mDownloadDataType)
            {
                //
                final List<String> imgUrlArray = new ArrayList<>();
                Type type = new TypeToken<List<Board>>() {
                }.getType();
                List<Board> lstBoard = (List<Board>) ((MDownloadDataTypeJson) mDownloadDataType).getJson(type);
                //
                for(Board b : lstBoard)
                {
                    imgUrlArray.add(b.getUrls().getSmall());
                    imgUrlArray.add(b.getUrls().getThumb());
                    imgUrlArray.add(b.getUrls().getRegular());
                }
                //
                mImageAdapter.setImgUrlArray(imgUrlArray);
                grid_view.setAdapter(mImageAdapter);
                grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id)
                    {
                        Intent i = new Intent(getContext(), FullImageActivity.class);
                        i.putExtra("url", imgUrlArray.get(position));
                        startActivity(i);
                    }
                });
            }

            @Override
            public void onFailure(MDownloadDataType mDownloadDataType, int statusCode, byte[] errorResponse, Throwable e)
            {
                Toast.makeText(getContext(), "Error in Base URL", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRetry(MDownloadDataType mDownloadDataType, int retryNo)
            {
                //
            }
        });
        mProvider.getRequest(mDataTypeJson);
    }
}
