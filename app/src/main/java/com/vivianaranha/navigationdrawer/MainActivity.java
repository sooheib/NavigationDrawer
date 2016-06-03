package com.vivianaranha.navigationdrawer;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    DrawerLayout drawerLayout;
    ListView listView;
    String[] people;
    TextView textView;
    ActionBarDrawerToggle drawerListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        people = getResources().getStringArray(R.array.people);
        listView = (ListView) findViewById(R.id.drawerList);
        listView.setOnItemClickListener(this);
        textView = (TextView) findViewById(R.id.textView);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        drawerListener = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(MainActivity.this, "Drawer Open", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText(MainActivity.this, "Drawer Closed", Toast.LENGTH_LONG).show();
            }
        };

        drawerLayout.setDrawerListener(drawerListener);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, people[position], Toast.LENGTH_LONG).show();
        listView.setItemChecked(position, true);
        textView.setText(people[position]);
    }
}
