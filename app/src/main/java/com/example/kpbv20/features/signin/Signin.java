package com.example.kpbv20.features.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.kpbv20.App;
import com.example.kpbv20.Prefs;
import com.example.kpbv20.features.dashboard.Dashboard;
import com.example.kpbv20.R;
import com.example.kpbv20.features.signin.model.LoginResponse;
import com.example.kpbv20.features.signup.CheckNik;
import com.example.kpbv20.ui.LoadingDialog;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Signin extends AppCompatActivity implements ISigninView {


    boolean doubleBackToExitPressedOnce = false;
    Dialog dialog;
    @BindView(R.id.registBtn)
    Button regist;
    @BindView(R.id.signinBtn)
    Button signin;
    @BindView(R.id.popupKeuntungan)
    TextView keuntungan;
    @BindView(R.id.popupSyarat)
    TextView syarat;
    ImageButton closePopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signin);
        ButterKnife.bind(this);
        dialog = new Dialog(this);
        this.initViews();


//        final LoadingDialog loadingDialog = new LoadingDialog(Signin.this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                LoadingDialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        loadingDialog.dismissDialog();
                        startActivity(new Intent(Signin.this, Dashboard.class));
                        Animatoo.animateZoom(Signin.this);
                    }
                }, 3000);
            }
        });
//        regist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Signin.this, CheckNik.class));
//                Animatoo.animateSlideUp(Signin.this);
//            }
//        });
    }

    @Override
    public void initViews() {
        keuntungan.setOnClickListener(view->showpoupkeuntungan());
        syarat.setOnClickListener(view->showpoupsyarat());
//        signin.setOnClickListener(view->this.);
        regist.setOnClickListener(view -> this.goToRegist());
    }

//    @Override
//    public void onSigninSuccess(LoginResponse response) {
//        presenter.storeProfile(new Gson().toJson(response));
//        presenter.storeAccessToken(response.getResult().getToken());
//        App.getPref().put(Prefs.PREF_FIRST_TIME, true);
//        App.getPref().put(Prefs.PREF_ROLE, response.getResult().getRole());
//        if (presenter.isLoggedIn()) {
//            if (response.getResult().getRole().equals("petani")) {
//                presenter.storeNoKK(response.getResult().getProfile().getNoKk());
//                presenter.storeNoRek(response.getResult().getNomorRekening());
//                this.goToDashboardPetani();
//            } else if (response.getResult().getRole().equals("gubernur")) {
//                this.goToDashboardGubernur();
//            }
//        }
//    }

//    @Override
//    public void onSigninFailed(String rm) {
//        Toast.makeText(this, rm, Toast.LENGTH_SHORT).show();
//    }

//    @Override
//    public void onNetworkError(String cause) {
//        Log.e("errornya", cause);
//        SweetDialogs.endpointError(this);
//    }

    @Override
    public void goToRegist() {
        startActivity(new Intent(Signin.this, CheckNik.class));
        Animatoo.animateSlideUp(Signin.this);
    }

    @Override
    public void showLoadingIndicator() {
        LoadingDialog.startLoadingDialog(this);
    }

    @Override
    public void hideLoadingIndicator() {

       LoadingDialog.dismissDialog();
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
