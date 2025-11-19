package com.sedigital.gamr.adapter;

import android.content.Intent;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.GameDetailsActivity;
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

        double price = videoGame.getPrice();
        tvVideoGamePrice.setText(itemView.getContext().getString(R.string.price_format_euro, price));

        ivVideoGameCover.setImageResource(videoGame.getCover());

        itemView.setOnClickListener(view -> {
            Intent intent = new Intent(itemView.getContext(), GameDetailsActivity.class);
            intent.putExtra("title", videoGame.getTitle());
            intent.putExtra("category", videoGame.getCategory());
            intent.putExtra("price", videoGame.getPrice());
            intent.putExtra("developer", videoGame.getDeveloper());
            intent.putExtra("rating", videoGame.getRating());
            intent.putExtra("description", videoGame.getDescription());
            intent.putExtra("cover", videoGame.getCover());
            intent.putIntegerArrayListExtra("images", videoGame.getImages());
            itemView.getContext().startActivity(intent);
        });

    }
}
