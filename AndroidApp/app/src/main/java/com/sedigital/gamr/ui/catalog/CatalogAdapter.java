package com.sedigital.gamr.ui.catalog;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.R;
import com.sedigital.gamr.data.model.VideoGame;

import java.util.ArrayList;

/**
 * Adapter del RecyclerView del catálogo.
 * Se encarga de mostrar los VideoGame en la grilla definida en CatalogActivity.
 */
public class CatalogAdapter extends RecyclerView.Adapter<CatalogViewHolder> {

    private final ArrayList<VideoGame> videoGames;

    public CatalogAdapter(ArrayList<VideoGame> videoGames) {
        this.videoGames = videoGames;
    }

    @NonNull
    @Override
    public CatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new CatalogViewHolder(layoutInflater.inflate(R.layout.item_videogame, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CatalogViewHolder holder, int position) {
        VideoGame videoGame = videoGames.get(position);
        holder.render(videoGame);
    }

    @Override
    public int getItemCount() {
        return videoGames.size();
    }
}
