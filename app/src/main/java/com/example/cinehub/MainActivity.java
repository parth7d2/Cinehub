package com.example.cinehub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bNView;
    BlurView blurView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        View view = findViewById(R.id.avoid_0View);
        view.setOnClickListener(v -> {

        });

        bNView = findViewById(R.id.bNView);
        blurView = (BlurView) findViewById(R.id.blurLayout);

        bNView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.bNhome) {
                    loadFrag(new HomeFragment(), true);
                } else if (itemId == R.id.bNdownloads) {
                    loadFrag(new DownloadsFragment(), false);
                } else if (itemId == R.id.bNsaved) {
                    loadFrag(new SavedFragment(), false);
                } else {
                    loadFrag(new AccountFragment(), false);
                }
                return true;
            }
        });

        bNView.setSelectedItemId(R.id.bNhome);

        blurBackground();
    }

    private void blurBackground() {
        float radius = 16f;
        View decorView = getWindow().getDecorView();
        ViewGroup rootView = (ViewGroup)decorView.findViewById(android.R.id.content);
        Drawable windowBackground = decorView.getBackground();
        blurView.setupWith(rootView, new RenderScriptBlur(this)).setFrameClearDrawable(windowBackground).setBlurRadius(radius);
    }

    public void loadFrag(Fragment fragment, boolean val) {
        int id = fragment.getId();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (val) {
            ft.add(R.id.framContainer, fragment);
            fm.popBackStack(String.valueOf(id), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.commit();
        } else {
            ft.replace(R.id.framContainer, fragment);
            ft.addToBackStack(String.valueOf(id));
            ft.commit();
        }

    }
}