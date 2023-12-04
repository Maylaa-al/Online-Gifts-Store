package com.example.glistenglowgifts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.glistenglowgifts.fragments.CategoriesFragment;
import com.example.glistenglowgifts.fragments.HomeFragment;
import com.example.glistenglowgifts.recycleView.CustomRecyclerViewAdapter;
import com.example.glistenglowgifts.recycleView.Term;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.example.glistenglowgifts.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private CustomRecyclerViewAdapter adapter;
    private SharedPreferences.OnSharedPreferenceChangeListener prefListener;

    // Add animation to navigation drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        String tag = null;

        int id = item.getItemId();
        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
            tag = "HOME_FRAGMENT";
        } else if (id == R.id.nav_categories) {
            fragment = new CategoriesFragment();
            tag = "CATEGORIES_FRAGMENT";
        }

        if (fragment != null) {
            switchFragment(fragment, tag);
        }

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

        // Initialize the adapter with an empty list or a valid list of Terms
        adapter = new CustomRecyclerViewAdapter(this, new ArrayList<Term>());

        // Register SharedPreferences listener
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                if ("currency_preference".equals(key)) {
                    // Notify adapter about the preference change
                    adapter.notifyCurrencyChanged();
                }
            }
        };
        prefs.registerOnSharedPreferenceChangeListener(prefListener);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.unregisterOnSharedPreferenceChangeListener(prefListener);
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

    private void switchFragment(Fragment fragment, String tag) {
        // Prepare a FragmentTransaction
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Set custom animations
        transaction.setCustomAnimations(
                R.anim.fade_in,  // Enter animation
                R.anim.fade_out, // Exit animation
                R.anim.fade_in,  // Pop Enter animation
                R.anim.fade_out  // Pop Exit animation
        );

        // Replace the current fragment with the new fragment
        transaction.replace(R.id.nav_categories, fragment, tag);

        // Add to back stack and commit
        transaction.addToBackStack(null);
        transaction.commit();
    }



}
