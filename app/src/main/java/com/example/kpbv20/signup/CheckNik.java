package com.example.kpbv20.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.kpbv20.R;
import com.example.kpbv20.signin.Signin;
import com.google.android.material.textfield.TextInputLayout;

public class CheckNik extends AppCompatActivity {

    Button registered;
    private TextInputLayout provinsi, kabupaten, kecamatan, desa;
    private AutoCompleteTextView provinsiComplete, kabupatenComplete, kecamatanComplete, desaComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_check_nik);

        provinsi = findViewById(R.id.provinsiList);
        kabupaten = findViewById(R.id.kabupatenList);
        kecamatan = findViewById(R.id.kecamatanList);
        desa = findViewById(R.id.desaList);
        provinsiComplete = findViewById(R.id.provinsiAuto);
        kabupatenComplete = findViewById(R.id.kabupatenAuto);
        kecamatanComplete = findViewById(R.id.kecamatanAuto);
        desaComplete = findViewById(R.id.desaAuto);

        registered = findViewById(R.id.regist);

        registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckNik.this, Signin.class));
                Animatoo.animateSlideDown(CheckNik.this);
            }
        });

        String[] item = new String[]{
                "item 1",
                "item 2",
                "item 3",
                "item 4",
                "item 5",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(CheckNik.this, R.layout.dropdown_item, item);
        provinsiComplete.setAdapter(adapter);
        kabupatenComplete.setAdapter(adapter);
        kecamatanComplete.setAdapter(adapter);
        desaComplete.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(CheckNik.this, Signin.class));
        Animatoo.animateSlideDown(CheckNik.this);
    }
}
