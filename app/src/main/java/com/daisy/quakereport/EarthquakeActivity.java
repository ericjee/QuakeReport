package com.daisy.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        earthquakeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Earthquake earthquake = (Earthquake) parent.getAdapter().getItem(position);
                Uri earthquakeUri = Uri.parse(earthquake.getEarthquakeUrl());
                openWebPage(earthquakeUri);
            }
        });

    }

    public void openWebPage(Uri uri) {
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
