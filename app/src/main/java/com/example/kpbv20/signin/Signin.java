package com.example.kpbv20.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.kpbv20.dashboard.Dashboard;
import com.example.kpbv20.R;
import com.example.kpbv20.signup.CheckNik;

public class Signin extends AppCompatActivity {

    Button regist, signin;
    boolean doubleBackToExitPressedOnce = false;
    TextView keuntungan, syarat;
    ImageButton closePopup;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_signin);

        regist = findViewById(R.id.registBtn);
        signin = findViewById(R.id.signinBtn);
        keuntungan = findViewById(R.id.popupKeuntungan);
        syarat = findViewById(R.id.popupSyarat);

        dialog = new Dialog(this);

        keuntungan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showpoupkeuntungan();
            }
        });

        syarat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showpoupsyarat();
            }
        });

        final LoadingDialog loadingDialog = new LoadingDialog(Signin.this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismissDialog();
                        startActivity(new Intent(Signin.this, Dashboard.class));
                        Animatoo.animateZoom(Signin.this);
                    }
                }, 3000);
            }
        });
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signin.this, CheckNik.class));
                Animatoo.animateSlideUp(Signin.this);
            }
        });
    }

    private void showpoupkeuntungan() {
        dialog.setContentView(R.layout.popup_keuntungan);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        closePopup = dialog.findViewById(R.id.closePopKeuntungan);
        dialog.setCanceledOnTouchOutside(false);
        closePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void showpoupsyarat() {
        dialog.setContentView(R.layout.popup_syarat);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        closePopup = dialog.findViewById(R.id.closePopKeuntungan);
        dialog.setCanceledOnTouchOutside(false);
        closePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan sekali lagi untuk keluar aplikasi", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
