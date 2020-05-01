package com.example.android.samisapi.models;

import com.google.gson.annotations.SerializedName;

public class ResourceId {
    @SerializedName("videoId")
    private String videoId;

    public ResourceId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoId() {
        return videoId;
    }
}
