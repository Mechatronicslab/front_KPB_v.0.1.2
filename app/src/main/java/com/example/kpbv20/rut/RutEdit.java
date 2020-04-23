package com.example.kpbv20.rut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.kpbv20.R;
import com.example.kpbv20.dashboard.Dashboard;

public class RutEdit extends AppCompatActivity {

    Toolbar toolbarMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rut_edit);

        toolbarMain = findViewById(R.id.toolbar_default_in);
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarMain.getNavigationIcon().setColorFilter(getResources().getColor(R.color.color_default_blue), PorterDuff.Mode.SRC_ATOP);
        toolbarMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RutEdit.this, Dashboard.class));
                Animatoo.animateSlideRight(RutEdit.this);
            }
        });
    }
}
