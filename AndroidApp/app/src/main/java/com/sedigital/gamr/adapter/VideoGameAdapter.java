package com.sedigital.gamr.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.R;
import com.sedigital.gamr.VideoGame;

import java.util.ArrayList;

public class VideoGameAdapter extends RecyclerView.Adapter<VideoGameHolder> {
    private ArrayList<VideoGame> videoGames;

    public VideoGameAdapter(ArrayList<VideoGame> videoGames) {
        this.videoGames = videoGames;
    }

    @NonNull
    @Override
    public VideoGameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new VideoGameHolder(layoutInflater.inflate(R.layout.item_videogame, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoGameHolder holder, int position) {
        VideoGame videoGame = videoGames.get(position);
        holder.render(videoGame);
    }

    @Override
    public int getItemCount() {
        return videoGames.size();
    }
}
