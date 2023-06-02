package com.example.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnav.Fragments.Account;
import com.example.bottomnav.Fragments.Categories;
import com.example.bottomnav.Fragments.Home;
import com.example.bottomnav.Fragments.Notification;
import com.example.bottomnav.Fragments.Settings;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // UPPER ACTION BAR


//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main);


        bnView = findViewById(R.id.bnView);

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    loadFrag(new Home(), false);
                    getSupportActionBar().hide();


                }
                else if (id == R.id.nav_categories) {

                    loadFrag(new Categories(), false);
                    getSupportActionBar().show();

                    getSupportActionBar().setTitle(" All Categories");


                }
                else if (id == R.id.nav_notification) {
                    loadFrag(new Notification(), false);
//                    getSupportActionBar().show();
//                    getSupportActionBar().setTitle("Notification");

                }
                else if (id == R.id.nav_cart) {
                    loadFrag(new Account(), false);
//                    getSupportActionBar().show();
//                    getSupportActionBar().setTitle("Cart");

                }
                else if (id == R.id.nav_account) {
                    loadFrag(new Settings(), false);
//                    getSupportActionBar().show();
//                    getSupportActionBar().setTitle("Account");

                }
                return true;

            }
        });

        bnView.setSelectedItemId(R.id.nav_home);

//        bnView.setOnNavigationItemSelectedListener(R.id.nav_home);

    }



    @SuppressLint("SuspiciousIndentation")
    public void loadFrag(Fragment fragment, boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag) {
            ft.add(R.id.container, fragment);
            fm.popBackStack();
        } else
            ft.replace(R.id.container, fragment);
        ft.addToBackStack(null);
        ft.commit();


    }





}