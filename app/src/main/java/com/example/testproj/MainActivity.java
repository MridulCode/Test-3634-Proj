package com.example.testproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PodcastsRecyclerViewInterface{


    static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    // private RecyclerView.Adapter adapterRV;
    private PodcastAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rvPodcasts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        adapter = new PodcastAdapter(Podcast.getPodcasts(), this);
        mRecyclerView.setAdapter(adapter);

    }

    public void launchDetailActivity(String msg){
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(DetailActivity.INTENT_MESSAGE, msg);
        startActivity(intent);
    }

    @Override
    public void onItemClick(String symbol) {
        launchDetailActivity(symbol);
    }


}