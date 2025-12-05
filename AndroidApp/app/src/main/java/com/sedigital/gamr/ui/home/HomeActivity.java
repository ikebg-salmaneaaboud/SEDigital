package com.sedigital.gamr.ui.home;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.sedigital.gamr.R;
import com.sedigital.gamr.ui.BaseActivity;

import java.util.ArrayList;

/**
 * Actividad principal que muestra la pantalla de inicio.
 * Contiene un carrusel de imágenes con información destacada.
 * Hereda de BaseActivity para disponer de la barra de navegación inferior.
 */
public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Configura la navegación inferior resaltando la sección de inicio
        setupBottomNav(R.id.home);

        // Slider de imágenes en la pantalla de inicio
        ImageSlider homeImageSlider = findViewById(R.id.homeImageSlider);

        // Lista de recursos de imagen a mostrar en el slider
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.home_carousel_1);

        // Convierte las imágenes en SlideModels con descripciones
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        for (int img : images) {
            slideModels.add(new SlideModel(
                    img,
                    "Asume el papel de Travis Baker, un hombre que tiene la mira puesta en convertirse en el nuevo rey de Rockay City, un crimen a la vez.",
                    ScaleTypes.FIT
            ));
        }

        // Asigna la lista de SlideModels al ImageSlider
        homeImageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }
}
