package com.example.foodi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.*;

import androidx.appcompat.widget.Toolbar;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import com.google.firebase.auth.FirebaseAuth;


public class Homepage extends AppCompatActivity {

    private TextView tv;
    private DrawerLayout mDrawerLayout;
    private Toolbar tbar;
    private NavigationView nDrawer;

    private ActionBarDrawerToggle drawerToggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        tbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tbar); // replaces action bar with tool bar

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nDrawer = (NavigationView) findViewById(R.id.nav_view);

        nDrawer.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch(menuItem.getItemId())
                        {
                            case R.id.nav_profile:
                                startActivity(new Intent(Homepage.this, MainActivity.class));
                                break;

                            case R.id.nav_recommendations:
                                startActivity(new Intent(Homepage.this, MainActivity.class));
                                break;

                            case R.id.nav_notifications:
                                startActivity(new Intent(Homepage.this, MainActivity.class));
                                break;

                            case R.id.nav_dashboard:
                                startActivity(new Intent(Homepage.this, MainActivity.class));
                                break;

                            case R.id.nav_logout:
                                startActivity(new Intent(Homepage.this, MainActivity.class));
                                break;

                        }
                        DrawerLayout drawer = findViewById(R.id.drawerLayout);
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });

        Log.d("TAG", "It works");
        //setupDrawerContent(nDrawer);


        // Handle drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

    }

    //public void selectDrawerItem(MenuItem item)
    //{
        //Fragment fragment = null;
        //Class fragClass;



        // Insert the fragment by replacing any existing fragment
        //FragmentManager fragmentManager = getSupportFragmentManager();
        //fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();


        //item.setChecked(true);

        // Set action bar title
        //setTitle(item.getTitle());

        //mDrawerLayout.closeDrawers(); // Close the navigation drawer
    //}

    //private void setupDrawerContent(NavigationView navigationView) {

   // }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_menu, menu);
        return true;
    }
}
