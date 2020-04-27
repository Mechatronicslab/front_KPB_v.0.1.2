package com.example.kpbv20.features.rut;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.kpbv20.R;
import com.example.kpbv20.features.dashboard.Dashboard;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class RutDetail extends AppCompatActivity{

    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar toolbarMain;

    private TabRutSaprotan tabRutSaprotan;
    private TabRutTani tabRutTani;
    private TabRutEstimasi tabRutEstimasi;
    private TabRutUntung tabRutUntung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rut_detail);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.pagerTab);

        toolbarMain = findViewById(R.id.toolbar_default_in);
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarMain.getNavigationIcon().setColorFilter(getResources().getColor(R.color.color_default_blue), PorterDuff.Mode.SRC_ATOP);
        toolbarMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RutDetail.this, Dashboard.class));
                Animatoo.animateSlideRight(RutDetail.this);
            }
        });

        tabRutSaprotan = new TabRutSaprotan();
        tabRutTani = new TabRutTani();
        tabRutEstimasi = new TabRutEstimasi();
        tabRutUntung = new TabRutUntung();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragment(tabRutSaprotan, "SAPROTAN");
        viewPagerAdapter.addFragment(tabRutTani, "BUDI DAYA TANI");
        viewPagerAdapter.addFragment(tabRutEstimasi, "ESTIMASI PENDAPATAN");
        viewPagerAdapter.addFragment(tabRutUntung, "KEUNTUNGAN");
        viewPager.setAdapter(viewPagerAdapter);

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            fragmentTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }
}
