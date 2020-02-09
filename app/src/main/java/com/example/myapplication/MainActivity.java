package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String Tag = "MainActivity";
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(menuFragment);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("Menu");
    }

    Feedback feedbackFragment = new Feedback();
    Suggestions suggestionsFragment = new Suggestions();
    menu menuFragment = new menu();
    price priceFragment = new price();
    credits creditsFragment = new credits();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_menu:
                loadFragment(menuFragment);
                getSupportActionBar().setTitle("Menu");
                return true;
            case R.id.navigation_price:
                loadFragment(priceFragment);
                getSupportActionBar().setTitle("Price");
                return true;
            case R.id.navigation_suggestions:
                loadFragment(suggestionsFragment);
                getSupportActionBar().setTitle("Suggestion");
                return true;
            case (R.id.navigation_feedback):
                loadFragment(feedbackFragment);
                getSupportActionBar().setTitle("Feedback");
                return true;
            case (R.id.navigation_credits):
                loadFragment(creditsFragment);
                getSupportActionBar().setTitle("Credit");
                return true;
        }
        return false;

    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }



}