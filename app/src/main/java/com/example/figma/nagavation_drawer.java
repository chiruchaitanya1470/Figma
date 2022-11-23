package com.example.figma;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.figma.databinding.ActivityNagavationDrawerBinding;

public class nagavation_drawer extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationview;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    private AppBarConfiguration mAppBarConfiguration,mAppBarConfiguratio;
    private ActivityNagavationDrawerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNagavationDrawerBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());

       /* mAppBarConfiguration=new AppBarConfiguration.Builder(R.id.nav_consultant,R.id.nav_appointments,R.id.nav_records)
                .setOpenableLayout().build();*/



        setSupportActionBar(binding.appBarNagavationDrawer.toolbar);
        binding.appBarNagavationDrawer.toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_consultant, R.id.nav_records,R.id.nav_home,R.id.nav_myfamily,R.id.nav_appointments
        ,R.id.nav_help)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nagavation_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        bottomNavigationView=findViewById(R.id.bottom_nagavation);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
/*
        bottomNavigationView=findViewById(R.id.bottom_nagavation);


        mAppBarConfiguratio=new AppBarConfiguration.Builder(R.id.nav_appointments
                ,R.id.nav_home
                ,R.id.nav_records,R.id.nav_consultant)
                .build();
        NavController navController1=Navigation.findNavController(this,R.id.nav_host_fragment_content_nagavation_drawer);
        NavigationUI.setupActionBarWithNavController(this,navController1,mAppBarConfiguratio);
        NavigationUI.setupWithNavController(bottomNavigationView,navController1);*/


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nagavation_drawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nagavation_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();

    }


}