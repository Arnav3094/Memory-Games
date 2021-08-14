package com.arnav.memorygames;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    BottomNavigationView bottomNavBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialisations
        bottomNavBar = findViewById(R.id.bottom_nav_bar);
        TilesFragment_Start tilesFragmentStart = new TilesFragment_Start();


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, tilesFragmentStart).commit();

        bottomNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()){
                    case (R.id.tiles_bottom):
                        selectedFragment = new TilesFragment_Start();
                        break;

                    case (R.id.words_bottom):
                        selectedFragment = new WordsFragment_Start();
                        break;

                    case (R.id.numbers_bottom):
                        selectedFragment = new NumbersFragment_Start();
                        break;

                }

                assert selectedFragment != null;
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, selectedFragment)
                        .commit();
                return true;
            }
        });

    }
}