package com.daisy.quakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        ArrayList<Earthquake> listItem  = new ArrayList<>();
        listItem.add(new Earthquake("7.2", "San Francisco", "Feb 2, 2016"));
        listItem.add(new Earthquake("6.1", "London", "Jun 2, 2016"));
        listItem.add(new Earthquake("5.2", "Tokyo", "Nov 10, 2014"));
        listItem.add(new Earthquake("4.5", "Mexico City", "May 3, 2014"));
        listItem.add(new Earthquake("6.2", "Moscow", "Jan 31, 2013"));
        listItem.add(new Earthquake("5.3","Rio de Janeiro", "Mar 3, 2016"));
        listItem.add(new Earthquake("4.6", "Paris", "July 15, 2013"));

        ListView earthquakeList = (ListView) findViewById(R.id.list);
        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this, listItem);
        earthquakeList.setAdapter(earthquakeAdapter);

    }
}
