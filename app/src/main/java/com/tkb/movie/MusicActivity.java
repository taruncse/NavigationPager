package com.tkb.movie;

import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tkb.movie.fragment.PopularMovieFragment;

public class MusicActivity extends AppCompatActivity{

    private static final String TAG = MusicActivity.class.getSimpleName();

    private FragmentManager fragmentManager;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        fragmentManager = getSupportFragmentManager();
        //final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



        if (savedInstanceState != null) {
            fragment =  getSupportFragmentManager().findFragmentByTag("PopularMovieFragment");
        } else {
            fragment = new PopularMovieFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.main_container_wrapper, fragment, "PopularMovieFragment").commit();

        }
        /*//fragmentTransaction.replace(R.id.main_container_wrapper, fragment);
        //fragmentTransaction.commit();*/

        NavigationView navigationView = findViewById(R.id.nav_view);
        View header = navigationView.inflateHeaderView(R.layout.nav_header_music);
        TextView profileName =  header.findViewById(R.id.profile_name);
        profileName.setText("Adele");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                fragment = FragmentsManager.getFragment(id);

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_container_wrapper, fragment);
                transaction.commit();

                DrawerLayout drawer =  findViewById(R.id.drawer_layout);
                assert drawer != null;
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movie, menu);

        MenuItem mSearch = menu.findItem(R.id.action_search);

        SearchView mSearchView = (SearchView) mSearch.getActionView();
        mSearchView.setQueryHint("Search");

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MusicActivity.this,query,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //mAdapter.getFilter().filter(newText);
                return true;
            }
        });


        return true;
    }
}
