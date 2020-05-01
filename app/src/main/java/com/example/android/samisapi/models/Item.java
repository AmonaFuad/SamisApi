package com.example.android.samisapi.models;

import com.google.gson.annotations.SerializedName;

public class Item {
   @SerializedName("id")
    private String id;
   @SerializedName("snippet")
    private Snippet snippet;

    public Item(String id, Snippet snippet) {
        this.id = id;
        this.snippet = snippet;
    }

    public String getId() {
        return id;
    }

    public Snippet getSnippet() {
        return snippet;
    }
}
