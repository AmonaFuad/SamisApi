package com.example.android.samisapi.rest;

import com.example.android.samisapi.models.BaseClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiSirver {

    @GET("youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLIPYb0kAOAovw46edbBnrhz6H8G724fIv&key=AIzaSyATNcXEQldlxb7SnZC-q7Rwz9MGAgapQyI")
    Call <BaseClass> getUser();
}
