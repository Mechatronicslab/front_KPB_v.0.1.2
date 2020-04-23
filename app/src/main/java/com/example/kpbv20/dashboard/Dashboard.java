package com.example.kpbv20.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.kpbv20.R;
import com.example.kpbv20.rut.RutAssets;
import com.example.kpbv20.signin.Signin;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    boolean doubleBackToExitPressedOnce = false;

    private DrawerLayout drawer;
    private ActionBarDrawerToggle mTogle;
    ImageButton menu;
    NavigationView navigation;
    Toolbar toolbarMain;
    ViewPager viewPager;

    CardView rut;

    AdapterSliderBanner adapter;
    List<ModelSliderBanner> models;
    LinearLayout indicatorDot;
    private int dotsCount;
    private ImageView[] dots;
    ImageView banners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        drawer = findViewById(R.id.dashboard);
        menu = findViewById(R.id.mainMenu);
        toolbarMain = findViewById(R.id.toolbar);
        banners = findViewById(R.id.banner);
        viewPager = findViewById(R.id.viewPager);
        indicatorDot = findViewById(R.id.bannerDot);
        navigation = findViewById(R.id.navigation);

        models = new ArrayList<>();
        models.add(new ModelSliderBanner(R.drawable.banner_a));
        models.add(new ModelSliderBanner(R.drawable.banner_b));
        models.add(new ModelSliderBanner(R.drawable.banner_c));
        models.add(new ModelSliderBanner(R.drawable.banner_d));
        models.add(new ModelSliderBanner(R.drawable.banner_e));

        adapter = new AdapterSliderBanner(models, this);
        dotsCount = adapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            indicatorDot.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

        viewPager.setAdapter(adapter);
        viewPager.setPadding(55, 0, 55, 0);

        mTogle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawer.setDrawerListener(mTogle);
        mTogle.syncState();
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(navigation);
            }
        });
        navigation.setNavigationItemSelectedListener(this);

        rut = findViewById(R.id.cardRut);
        rut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, RutAssets.class));
                Animatoo.animateSplit(Dashboard.this);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.profile){

        }else if (id == R.id.kolaborator){

        }else if (id == R.id.about){

        }else if (id == R.id.term){

        }else if (id == R.id.exit){
            poupExit();
        }
        return true;
    }

    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            Dashboard.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(3);
                    } else if (viewPager.getCurrentItem() == 3) {
                        viewPager.setCurrentItem(4);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
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

    void poupExit(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
        View v = getLayoutInflater().inflate(R.layout.custom_dialog_exit, null);

        final Button exit = v.findViewById(R.id.exitacc);
        final Button stay = v.findViewById(R.id.stayacc);

        builder.setView(v);

        final AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);

        stay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, Signin.class));
                Animatoo.animateSlideUp(Dashboard.this);
            }
        });

        alertDialog.show();
    }
}
