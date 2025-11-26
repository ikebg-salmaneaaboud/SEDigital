package com.sedigital.gamr.ui.catalog;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.R;
import com.sedigital.gamr.data.mock.VideoGameProvider;
import com.sedigital.gamr.ui.BaseActivity;

public class CatalogActivity extends BaseActivity {

    private VideoGameProvider videoGameProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        videoGameProvider = new VideoGameProvider();
        setupBottomNav(R.id.games);
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerGames);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new CatalogGameAdapter(videoGameProvider.getVideoGames()));
    }
}