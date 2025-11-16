package com.sedigital.gamr;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sedigital.gamr.adapter.VideoGameAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private VideoGameProvider videoGameProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoGameProvider = new VideoGameProvider();
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerGames);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new VideoGameAdapter(videoGameProvider.getVideoGames()));
    }
}