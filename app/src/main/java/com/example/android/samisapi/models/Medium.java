package com.example.android.samisapi.models;

import com.google.gson.annotations.SerializedName;

public class Medium {
    @SerializedName("url")
    private String url;

    public Medium(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
