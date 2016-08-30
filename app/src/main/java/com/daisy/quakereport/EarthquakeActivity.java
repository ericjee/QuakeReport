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

        ListView earthquakeList = (ListView) findViewById(R.id.list);
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();
        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this, earthquakes);
        earthquakeList.setAdapter(earthquakeAdapter);

    }
}
