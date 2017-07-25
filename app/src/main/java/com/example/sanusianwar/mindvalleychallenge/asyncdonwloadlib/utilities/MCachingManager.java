package com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.utilities;

import android.util.LruCache;

import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.models.MDownloadDataType;

public class MCachingManager {
    //
    private int maxCacheSize;
    private static MCachingManager instance;
    private LruCache<String, MDownloadDataType> mDownloadDataTypeCache;

    private MCachingManager()
    {
        //
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        //
        maxCacheSize =   maxMemory / 8;
        mDownloadDataTypeCache = new LruCache<>(maxCacheSize);
    }

    public static MCachingManager getInstance()
    {
        if (instance == null)
        {
            instance = new MCachingManager();
        }
        return instance;
    }

    public MDownloadDataType getMDownloadDataType(String key)
    {
        return mDownloadDataTypeCache.get(key);
    }

    public boolean putMDownloadDataType(String key, MDownloadDataType mDownloadDataType)
    {
        return mDownloadDataTypeCache.put(key, mDownloadDataType) != null;
    }

    public void clearTheCash()
    {
        mDownloadDataTypeCache.evictAll();
    }
}
