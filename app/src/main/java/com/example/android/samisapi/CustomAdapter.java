package com.example.android.samisapi;

import android.content.Intent;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.samisapi.models.Item;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ExampleViewHolder> {
    private static final String TAG = "CustomAdapter";
    private static String apiKey = "AIzaSyATNcXEQldlxb7SnZC-q7Rwz9MGAgapQyI";
    static YouTubePlayer.OnInitializedListener onInitializedListener;
    private ArrayList <Item> mVideoItems;
    private RecycleViewClickable recycleViewClickable;
    public CustomAdapter(ArrayList <Item> videoItems,RecycleViewClickable recycleViewClickable){
mVideoItems=videoItems;
        this.recycleViewClickable=recycleViewClickable;
    }


    public static  class ExampleViewHolder extends RecyclerView.ViewHolder {
        public com.google.android.youtube.player.YouTubePlayerView thumbnailView;
        public TextView titleTextView;
        public TextView PublishDate;
       // RecycleViewClickable recycleViewClickable;
        public ExampleViewHolder(@NonNull View itemView,final RecycleViewClickable recycleViewClickable) {
            super(itemView);
            thumbnailView =itemView.findViewById(R.id.imageView);
            titleTextView= itemView.findViewById(R.id.titleText);
            PublishDate=itemView.findViewById(R.id.publishText);

itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        recycleViewClickable.onMyAdapterClick(getAdapterPosition());
    }
});

        }
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, parent, false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(view,recycleViewClickable);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
final Item getVideoData=mVideoItems.get(position);
        holder.titleTextView.setText(getVideoData.getSnippet().getTitle());
        holder.PublishDate.setText(getVideoData.getSnippet().getTitle());
        ////
      onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

               youTubePlayer.loadVideo(getVideoData.getSnippet().getResourceId().getVideoId());
               // youTubePlayer.release();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        //
       holder.thumbnailView.initialize(apiKey,onInitializedListener);

    }
//////////////

    @Override
    public int getItemCount() {
        return mVideoItems.size();
    }
}
