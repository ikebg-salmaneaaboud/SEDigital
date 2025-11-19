package com.sedigital.gamr;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class GameDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);

        ImageView btnReturn = findViewById(R.id.header_return_icon);

        btnReturn.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());


        TextView tvTitle = findViewById(R.id.tvGameTitle);
        TextView tvDeveloper = findViewById(R.id.tvDeveloper);
        TextView tvRating = findViewById(R.id.tvRating);
        TextView tvDescription = findViewById(R.id.tvGameDescription);
        com.denzcoskun.imageslider.ImageSlider imageSlider = findViewById(R.id.imageSlider);

        tvTitle.setText(getIntent().getStringExtra("title"));
        tvDeveloper.setText(getIntent().getStringExtra("developer"));
        tvRating.setText(String.valueOf(getIntent().getDoubleExtra("rating", 0.0)));
        tvDescription.setText(getIntent().getStringExtra("description"));

        ArrayList<Integer> images = getIntent().getIntegerArrayListExtra("images");
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        if (images != null) {
            for (int img : images) {
                slideModels.add(new SlideModel(img, ScaleTypes.FIT));
            }
        }
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }

}
