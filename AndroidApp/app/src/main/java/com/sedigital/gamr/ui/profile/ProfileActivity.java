package com.sedigital.gamr.ui.profile;

import android.os.Bundle;
import com.sedigital.gamr.R;
import com.sedigital.gamr.ui.BaseActivity;

/**
 * Actividad que muestra el perfil del usuario.
 * Hereda de BaseActivity para disponer de la BottomNavigationView.
 */
public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setupBottomNav(R.id.profile);
    }
}
