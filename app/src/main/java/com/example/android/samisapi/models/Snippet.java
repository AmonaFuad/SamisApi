package com.example.android.samisapi.models;

import com.google.gson.annotations.SerializedName;

public class Snippet {
    @SerializedName("publishedAt")
    private String publishedAt;
   @SerializedName("channelId")
    private String channelId;
   @SerializedName("title")
    private String title;
   @SerializedName("resourceId")
    private ResourceId resourceId;

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public Snippet(String publishedAt, String channelId, String title, ResourceId resourceId, Thumbnails thumbnails) {
        this.publishedAt = publishedAt;
        this.channelId = channelId;
        this.title = title;
        this.resourceId = resourceId;
        this.thumbnails = thumbnails;
    }

    @SerializedName("thumbnails")
    private Thumbnails thumbnails;

    public Snippet(String publishedAt, String channelId, String title, ResourceId resourceId) {
        this.publishedAt = publishedAt;
        this.channelId = channelId;
        this.title = title;
        this.resourceId = resourceId;
    }

    public Snippet(String publishedAt, String channelId, String title) {
        this.publishedAt = publishedAt;
        this.channelId = channelId;
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getTitle() {
        return title;
    }

    public ResourceId getResourceId() {
        return resourceId;
    }
}
