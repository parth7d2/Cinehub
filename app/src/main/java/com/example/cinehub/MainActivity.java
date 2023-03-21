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

    BottomNavigationView bNView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bNView = findViewById(R.id.bNView);

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