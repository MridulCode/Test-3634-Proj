package com.example.testproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

public class DetailActivity extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "Intent";

    private TextView mPodName;
    private TextView mChanName;
    private TextView mPodYear;
    private TextView mPodLength;
    private TextView mPodDescription;
    private TextView mPodSummary;
    private ImageView mPodView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //connecting variables here to the items in the xml file
        mPodName = findViewById(R.id.tvPodName);
        mChanName = findViewById(R.id.tvChanName);
        mPodYear = findViewById(R.id.tvPodYear);
        mPodLength = findViewById(R.id.tvPodLength);
        mPodDescription = findViewById(R.id.tvPodDescription);
        mPodSummary = findViewById(R.id.tvPodSummary);
        mPodView = findViewById(R.id.ivPod);

        Intent intent = getIntent();

        if (intent.hasExtra(INTENT_MESSAGE)) {
            String message = intent.getStringExtra(INTENT_MESSAGE);

            Podcast podcast = Podcast.matchPodcast(message);
            if (podcast != null) {
                setTitle(podcast.getCategory() + " - " + podcast.getPodName());
                //setting the value of the items in the xml file so that the podcast details change when different podcasts are clicked
                mPodName.setText(podcast.getPodName());
                mChanName.setText(podcast.getChannelName());
              //  mPodYear.setText(podcast.getPodYear());
                mPodLength.setText(podcast.getPodLength());
                mPodDescription.setText(podcast.getPodDescription());
                mPodSummary.setText(podcast.getPodSummary());

                //setting a onClick listener so when you click the ImageView for search, it calls the openURL method to take you to a spotify link of the podcast
                mPodView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openURL(podcast.getPodName());
                    }
                });
            }
        }
    }

    public void openURL(String url){
        //implicit intent
        //replace with spotify search link + string url
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=5HaJPpihkBI&ab_channel=CurtisHolt"));
        startActivity(intent);
    }
}
