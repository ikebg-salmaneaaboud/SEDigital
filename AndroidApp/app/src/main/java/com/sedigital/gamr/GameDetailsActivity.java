package com.sedigital.gamr;

import android.os.Bundle;

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

        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.rdr_carousel_1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.rdr_carousel_2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.rdr_carousel_3, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }
}
