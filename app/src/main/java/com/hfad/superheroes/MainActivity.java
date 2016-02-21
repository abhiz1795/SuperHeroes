package com.hfad.superheroes;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private ListView drawer;
    private String[] heroes;
    private DrawerLayout drawerLayout;
    private TextView textView;
    private ActionBarDrawerToggle drawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize the drawer list
        heroes=getResources().getStringArray(R.array.super_heroes);
        drawer=(ListView)findViewById(R.id.drawer);
        drawer.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, heroes));
        //set Listener to drawer list
        drawer.setOnItemClickListener(new DrawerItemClickListener());

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close)
                         {
                           @Override
                           public void onDrawerClosed(View view)
                           {
                               super.onDrawerClosed(view);
                               getActionBar().setTitle(R.string.app_name);
                               invalidateOptionsMenu();
                           }
                           @Override
                           public void onDrawerOpened(View view)
                           {
                               super.onDrawerClosed(view);
                               getActionBar().setTitle(R.string.app_name);
                               invalidateOptionsMenu();
                           }};
        drawerLayout.setDrawerListener(drawerToggle);

        }



    private class DrawerItemClickListener implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView parent,View view,int position,long id)
         {
             display();
         }

    }


    private void display()
    {
        textView=(TextView)findViewById(R.id.text);
        textView.setText("clicked");
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
}
