package com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.interfaces;

import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.models.MDownloadDataType;

public interface IMProvider {

    public void markAsDone(MDownloadDataType mDownloadDataType);
    //
    public void onFailure(MDownloadDataType mDownloadDataType);
    //
    public void markAsCancel(MDownloadDataType mDownloadDataType);
}
