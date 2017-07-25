package com.example.sanusianwar.mindvalleychallenge.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("profile_image")
    @Expose
    private ProfileImage profileImage;

    public ProfileImage getProfileImage()
    {
        return profileImage;
    }

    public void setProfileImage(ProfileImage profileImage)
    {
        this.profileImage = profileImage;
    }
}
