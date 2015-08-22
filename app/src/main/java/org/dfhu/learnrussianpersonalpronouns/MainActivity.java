package org.dfhu.learnrussianpersonalpronouns;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerFragment mDrawerFragment;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.myToolbar);
        setSupportActionBar(mToolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.mipmap.ic_reorder_24dp);
            ab.setDisplayHomeAsUpEnabled(true);
        }


        mDrawerFragment = (DrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);


        mDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        setUpDrawerToggle();
    }

    private void setUpDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                (DrawerLayout) findViewById(R.id.drawer_layout),
                mToolbar,
                R.string.return_to_home,
                R.string.nav_cases_refresher);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }



        return super.onOptionsItemSelected(item);
    }

    private void setupWelcomeFragment() {
        View fragmentContainer = findViewById(R.id.fragmentContainer);

        // if this view doesn't have a fragmentContainer return
        if (fragmentContainer == null) {
            return;
        }

        WelcomeFragment fragment = new WelcomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment).commit();

    }



}
