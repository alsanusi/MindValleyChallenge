package com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.interfaces;

import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.models.MDownloadDataType;

public interface IMDownloadDataType {

    public void onStart(MDownloadDataType mDownloadDataType);
    //
    public void onSuccess(MDownloadDataType mDownloadDataType);
    //
    public void onFailure(MDownloadDataType mDownloadDataType, int statusCode, byte[] errorResponse, Throwable e);
    //
    public void onRetry(MDownloadDataType mDownloadDataType, int retryNo);
}
