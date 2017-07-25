package com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.utilities;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.interfaces.IMProvider;
import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.models.MDownloadDataType;

import cz.msebera.android.httpclient.Header;

public class MDownloadAsyncManager {

    public MDownloadAsyncManager()
    {
        //
    }

    public AsyncHttpClient get(final MDownloadDataType mDownloadDataType, final IMProvider imProvider)
    {
        AsyncHttpClient client = new AsyncHttpClient(true, 80, 443);
        client.get(mDownloadDataType.getUrl(), new AsyncHttpResponseHandler() {
            @Override
            public void onStart()
            {
                //
                mDownloadDataType.getImDownloadDataType().onStart(mDownloadDataType);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response)
            {
                //response HTTP status is "200 OK"
                mDownloadDataType.setData(response);
                mDownloadDataType.getImDownloadDataType().onSuccess(mDownloadDataType);
                // This call for provider to manage it
                imProvider.markAsDone(mDownloadDataType);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e)
            {
                // response HTTP status is "4XX" (eg. 401, 403, 404)
                mDownloadDataType.getImDownloadDataType().onFailure(mDownloadDataType, statusCode, errorResponse, e);
                // This call for provider to manage it
                imProvider.onFailure(mDownloadDataType);
            }

            @Override
            public void onRetry(int retryNo)
            {
                // called when request is retried
                mDownloadDataType.getImDownloadDataType().onRetry(mDownloadDataType, retryNo);
            }

            @Override
            public void onCancel()
            {
                super.onCancel();
                // called when request is retried
                imProvider.markAsCancel(mDownloadDataType);
            }
        });
        return client;
    }
}


