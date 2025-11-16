package com.sedigital.gamr.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.R;
import com.sedigital.gamr.VideoGame;

public class VideoGameHolder extends RecyclerView.ViewHolder {
    private TextView tvVideoGameTitle;
    private TextView tvVideoGameCategory;
    private TextView tvVideoGamePrice;
    private ImageView ivVideoGameCover;

    public VideoGameHolder(View view) {
        super(view);
        tvVideoGameTitle = view.findViewById(R.id.tvVideoGameTitle);
        tvVideoGameCategory = view.findViewById(R.id.tvVideoGameCategory);
        tvVideoGamePrice = view.findViewById(R.id.tvVideoGamePrice);
        ivVideoGameCover = view.findViewById(R.id.ivVideoGame);
    }

    public void render(VideoGame videoGame) {
        tvVideoGameTitle.setText(videoGame.getTitle());
        tvVideoGameCategory.setText(videoGame.getCategory());
        tvVideoGamePrice.setText(String.valueOf(videoGame.getPrice()) + "€");
        ivVideoGameCover.setImageResource(videoGame.getCover());
    }
}
