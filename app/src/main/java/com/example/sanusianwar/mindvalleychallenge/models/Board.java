
package com.example.sanusianwar.mindvalleychallenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Board {

    @SerializedName("user")
    @Expose
    private User user;
    //
    @SerializedName("urls")
    @Expose
    private Urls urls;

    public User getUser()
    {
        return user;
    }

    public Urls getUrls()
    {
        return urls;
    }

    public void setUrls(Urls urls)
    {
        this.urls = urls;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
