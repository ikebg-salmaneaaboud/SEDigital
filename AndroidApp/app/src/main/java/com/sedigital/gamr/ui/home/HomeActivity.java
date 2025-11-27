package com.sedigital.gamr.ui.home;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.sedigital.gamr.R;
import com.sedigital.gamr.data.repository.FakeRepository;
import com.sedigital.gamr.ui.BaseActivity;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupBottomNav(R.id.home);

        ImageSlider homeImageSlider = findViewById(R.id.homeImageSlider);

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.home_carousel_1);

        ArrayList<SlideModel> slideModels = new ArrayList<>();
        if (images != null) {
            for (int img : images) {
                slideModels.add(new SlideModel(img, "Asume el papel de Travis Baker, un hombre que tiene la mira puesta en convertirse en el nuevo rey de Rockay City, un crimen a la vez.", ScaleTypes.FIT));
            }
        }
        homeImageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }
}
