package com.example.android.samisapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.samisapi.models.BaseClass;
import com.example.android.samisapi.models.Item;
import com.example.android.samisapi.rest.ApiClient;
import com.example.android.samisapi.rest.ApiSirver;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends YouTubeBaseActivity implements RecycleViewClickable {
    private RecyclerView mRecyclerView;
   CustomAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    private String apiKey="AIzaSyATNcXEQldlxb7SnZC-q7Rwz9MGAgapQyI";
    YouTubePlayerView youTubePlayerView;
    YouTubeThumbnailView  tubeThumbnailView;
    Button button;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    ArrayList<BaseClass> myDataSource = new ArrayList <BaseClass>();
    ArrayList <Item> items= new ArrayList <>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView= findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mAdapter=new CustomAdapter( items,this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        /////



        //////


        loadData();


    }


    public void loadData()
    {
        final ApiSirver apiService =
                ApiClient.getClient().create(ApiSirver.class);
        Call <BaseClass> call = apiService.getUser();
        call.enqueue(new Callback <BaseClass>() {
            @Override
            public void onResponse(Call <BaseClass> call, final Response <BaseClass> response) {

                Toast.makeText(MainActivity.this,response.body().getItems().get(1).getSnippet().getTitle(), Toast.LENGTH_SHORT).show();

                myDataSource.clear();
                items.addAll(response.body().getItems());
                mAdapter.notifyDataSetChanged();
                onInitializedListener=new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {


                        youTubePlayer.loadVideo(response.body().getItems().get(1).getSnippet().getResourceId().getVideoId());

                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                        Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
                    }
                };

            }

            @Override
            public void onFailure(Call <BaseClass> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public void onMyAdapterClick(int itemPosition) {

        Toast.makeText(this,items.get(itemPosition).getSnippet().getTitle(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        String message = items.get(itemPosition).getSnippet().getTitle();
        intent.putExtra("EXTRA_MESSAGE", message);
        startActivity(intent);
    }

    @Override
    public void onMyAdapterLongClick(int itemPosition) {

    }
}
