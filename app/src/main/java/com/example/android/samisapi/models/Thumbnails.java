package com.example.android.samisapi.models;

import com.google.gson.annotations.SerializedName;

public class Thumbnails {
    @SerializedName("medium")
    private Medium medium;

    public Thumbnails(Medium medium) {
        this.medium = medium;
    }

    public Medium getMedium() {
        return medium;
    }
}
