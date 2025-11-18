package com.sedigital.gamr.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.R;
import com.sedigital.gamr.VideoGame;

public class VideoGameHolder extends RecyclerView.ViewHolder {
    private final TextView tvVideoGameTitle;
    private final TextView tvVideoGameCategory;
    private final TextView tvVideoGamePrice;
    private final ImageView ivVideoGameCover;

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
        tvVideoGamePrice.setText(String.format(String.valueOf(videoGame.getPrice()) + R.string.euro_symbol));
        ivVideoGameCover.setImageResource(videoGame.getCover());
    }
}
