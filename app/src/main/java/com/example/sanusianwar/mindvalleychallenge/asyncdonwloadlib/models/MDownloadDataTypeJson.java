package com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.models;

import com.google.gson.Gson;
import com.example.sanusianwar.mindvalleychallenge.asyncdonwloadlib.interfaces.IMDownloadDataType;

import java.lang.reflect.Type;

public class MDownloadDataTypeJson extends MDownloadDataType {

    public MDownloadDataTypeJson(String url, IMDownloadDataType imDownloadDataType)
    {
        super(url, MDataType.JSON, imDownloadDataType);
    }

    @Override
    public MDownloadDataType getCopyOfMe(IMDownloadDataType imDownloadDataType)
    {
        MDownloadDataType mDownloadDataType = new MDownloadDataTypeJson(this.getUrl(), imDownloadDataType);
        return mDownloadDataType;
    }

    public String getJsonText()
    {
        try
        {
            String str = new String(getData(), "UTF-8");
            return str;
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }

    public Object getJson(Type type)
    {
        Gson gson = new Gson();
        return gson.fromJson(getJsonText(), type);
    }
}
