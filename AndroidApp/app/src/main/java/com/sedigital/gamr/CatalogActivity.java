package com.sedigital.gamr;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.adapter.VideoGameAdapter;

public class CatalogActivity extends AppCompatActivity {

    private VideoGameProvider videoGameProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        videoGameProvider = new VideoGameProvider();
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerGames);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new VideoGameAdapter(videoGameProvider.getVideoGames()));
    }
}