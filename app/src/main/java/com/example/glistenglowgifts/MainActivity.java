package com.example.glistenglowgifts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.glistenglowgifts.fragments.CategoriesFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.example.glistenglowgifts.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    // Add animation to navigation drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Depending on the ID of the item, perform your animations
        if (id == R.id.nav_home) {
            // Apply animation for Home item
            applyScaleAnimation();
        } else if (id == R.id.nav_categories) {
            // Apply a different animation for Categories
            applyRotateFadeInAnimation();
        } else if (id == R.id.nav_credits) {
            // Apply a different animation for Categories
            applyRotateFadeInAnimation();
        }

        // Close the drawer after item click
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void applyFadeInAnimation() {
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        // Replace 'binding.navView' with the specific view you want to animate
        binding.navView.startAnimation(fadeIn);
    }

    private void applySlideInAnimation() {
        Animation slideIn = AnimationUtils.loadAnimation(this, R.anim.slide_in);
        // Replace 'binding.navView' with the specific view you want to animate
        binding.navView.startAnimation(slideIn);
    }

    private void applyScaleAnimation() {
        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        binding.navView.startAnimation(scaleAnimation);
    }

    private void applyRotateFadeInAnimation() {
        Animation rotateFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_fade_in);
        binding.navView.startAnimation(rotateFadeInAnimation);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
//        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_categories, R.id.catListFragment, R.id.nav_cart, R.id.nav_help, R.id.nav_credits)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    // Start SettingsActivity
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        // Check if the settings item was clicked
        if (id == R.id.action_settings) {
            Intent startSettingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(startSettingsIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
