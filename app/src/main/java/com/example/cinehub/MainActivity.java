package com.example.cinehub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.bnView);

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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

        bnView.setSelectedItemId(R.id.bNhome);
    }

    public void loadFrag(Fragment fragment, boolean val) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (val) {
            ft.add(R.id.framContainer, fragment);
            ft.commit();
        } else {
            ft.replace(R.id.framContainer, fragment);
            ft.commit();
        }

    }
}