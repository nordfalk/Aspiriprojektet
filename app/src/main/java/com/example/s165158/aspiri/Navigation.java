package com.example.s165158.aspiri;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    ListView lst;

    String[] nameArray = {"Rentes Regning", "Kvatratsætninger", "Potensregneregler", "Polynomier", "Lineær eksponentiel og potens-sammenhænge", "Statistik", "Differentialregning", "Integralregning", "Geometri", "Plangeometri med vektore", "Rumgeometri med vektore", "Areal, omkreds og rumfang", "Placeholder", "Placeholder", "Placeholder"};

    // Lavet som array så man kan tilføje flere beskrivelser
    String[] infoArray = {
            "Her lærer du om Sin, Cos og Tan", "Trigonometri", "Trigonometri", "Trigonometri", "Trigonometri", "Trigonometri", "Trigonometri", "Trigonometri", "Trigonometri", "Trigonometri", "Trigonometri", "Trigonometri", "Trigonometri", "Trigonometri", "Trigonometri"
    };

    Integer[] imageArray = {R.drawable.trig, R.drawable.trig, R.drawable.trig, R.drawable.trig, R.drawable.trig, R.drawable.trig, R.drawable.trig, R.drawable.trig, R.drawable.trig, R.drawable.trig, R.drawable.trig, R.drawable.trig, R.drawable.trig, R.drawable.trig, R.drawable.trig, R.drawable.trig
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        // Fanebladet
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);


        // Den flyvende knap nede i højre hjørne.
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            // OnClick metode for den flyvende knap
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Navigation menu oppe til venstre

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // Objekt for den scrollende liste
        CustomListAdapter whatever = new CustomListAdapter(this, nameArray, infoArray, imageArray);
        lst = (ListView) findViewById(R.id.list);
        lst.setAdapter(whatever);
    }
    //On return pressed
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    // OnClick for Settings and favorite options!
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    // On click for de forskellige optioner i navigation menuen.
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

