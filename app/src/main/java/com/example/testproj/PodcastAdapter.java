package com.example.testproj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class PodcastAdapter extends RecyclerView.Adapter<PodcastAdapter.MyViewHolder> {
        private ArrayList<Podcast> mPodcast;
        private PodcastsRecyclerViewInterface recyclerViewInterface;

        public PodcastAdapter(ArrayList<Podcast> podcasts, PodcastsRecyclerViewInterface rvInterface) {
            mPodcast = podcasts;
            recyclerViewInterface = rvInterface;
        }


        @NonNull
        @Override
        public PodcastAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
            return new MyViewHolder(view, recyclerViewInterface);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            NumberFormat currencyFormat = NumberFormat.getNumberInstance();
            //match each piece of information to its respective podcast
            Podcast podcast = mPodcast.get(position);
            holder.tvPodcastName.setText(podcast.getPodName());
            holder.tvPodcastCategory.setText(podcast.getCategory());
            //set tag to be dynamic
            holder.itemView.setTag(podcast.getPodName());

        }

        @Override
        public int getItemCount() {
            return mPodcast.size();
        }

    public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView tvPodcastName;
            private TextView tvPodcastCategory;
            ImageView ivPodcastImage;

            public MyViewHolder(@NonNull View itemView, PodcastsRecyclerViewInterface recyclerViewInterface) {
                super(itemView);
                tvPodcastName = itemView.findViewById(R.id.tvPodcastName);
                tvPodcastCategory = itemView.findViewById(R.id.tvPodcastCategory);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //if the recyclerView has been clicked i.e. if the click is not null
                        if(recyclerViewInterface != null) {
                            recyclerViewInterface.onItemClick((String) itemView.getTag());
                        }
                    }
                });
            }
        }
}
