package org.dfhu.learnrussianpersonalpronouns;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.mipmap.ic_reorder_24dp);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        setupInfoFragment();
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

    private void setupInfoFragment() {
        View fragmentContainer = findViewById(R.id.fragmentContainer);

        // if this view doesn't have a fragmentContainer return
        if (fragmentContainer == null) {
            return;
        }
        /*
        InfoFragment infoFragment = InfoFragment.newInstance("foo", "bar");
        // pass along any special extras from the intent
        infoFragment.setArguments(getIntent().getExtras()); */

        CasesRefresherFragment casesFragment = new CasesRefresherFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, casesFragment).commit();

    }

}
