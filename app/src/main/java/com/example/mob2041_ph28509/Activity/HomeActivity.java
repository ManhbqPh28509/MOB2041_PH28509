package com.example.mob2041_ph28509.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mob2041_ph28509.Fragment.HomeFragment;
import com.example.mob2041_ph28509.Fragment.LoaiSachFragment;
import com.example.mob2041_ph28509.Fragment.SachFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mob2041_ph28509.databinding.ActivityHomeBinding;

import com.example.mob2041_ph28509.R;

public class HomeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        drawerLayout = findViewById(R.id.drawerlayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.navigation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentlayout, new SachFragment());

                if (item.getItemId() == R.id.qlpm){
                    fragmentTransaction.replace(R.id.fragmentlayout, new HomeFragment());
                } else if (item.getItemId() == R.id.qlls) {
                    fragmentTransaction.replace(R.id.fragmentlayout, new LoaiSachFragment());
                } else if (item.getItemId() == R.id.qls) {
                    fragmentTransaction.replace(R.id.fragmentlayout, new SachFragment());
                }
                fragmentTransaction.commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                setTitle(item.getTitle());
                return false;
            }
        });
    }

}