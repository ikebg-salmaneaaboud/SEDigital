package com.sedigital.gamr.ui.gamedetail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.sedigital.gamr.R;

import java.util.ArrayList;

/**
 * Pantalla que muestra los detalles de un juego seleccionado.
 * Incluye:
 * - Slider de imágenes del juego
 * - Título, desarrollador, rating y descripción
 */
public class GameDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        // Botón para regresar a la pantalla anterior
        ImageView btnReturn = findViewById(R.id.header_return_icon);
        btnReturn.setOnClickListener(view -> onBackPressed());

        // Elementos visuales para mostrar la información del juego
        TextView tvTitle = findViewById(R.id.tvGameTitle);
        TextView tvDeveloper = findViewById(R.id.tvDeveloper);
        TextView tvRating = findViewById(R.id.tvRating);
        TextView tvDescription = findViewById(R.id.tvGameDescription);
        ImageSlider imageSlider = findViewById(R.id.imageSlider);

        // Configura la información recibida desde el Intent
        tvTitle.setText(getIntent().getStringExtra("title"));
        tvDeveloper.setText(getIntent().getStringExtra("developer"));
        tvRating.setText(String.valueOf(getIntent().getDoubleExtra("rating", 0.0)));
        tvDescription.setText(getIntent().getStringExtra("description"));

        // Configura el slider de imágenes
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
