package com.example.kpbv20.features.rut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.kpbv20.R;
import com.example.kpbv20.features.dashboard.Dashboard;

public class RutAssets extends AppCompatActivity {

    Toolbar toolbarMain;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rut_assets);

        toolbarMain = findViewById(R.id.toolbar_default_in);
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarMain.getNavigationIcon().setColorFilter(getResources().getColor(R.color.color_default_blue), PorterDuff.Mode.SRC_ATOP);
        toolbarMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RutAssets.this, Dashboard.class));
                Animatoo.animateSlideRight(RutAssets.this);
            }
        });

        recyclerView = findViewById(R.id.listKomoditi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(RutAssets.this, Dashboard.class));
        Animatoo.animateSlideRight(RutAssets.this);
    }
}
