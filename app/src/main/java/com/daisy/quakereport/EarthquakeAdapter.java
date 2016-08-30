package com.daisy.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by eric on 8/25/16.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake earthquake = getItem(position);
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.tv_magnitude);
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.tv_location);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.tv_earthquake_date);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        Date dateObject = new Date(earthquake.getDate());
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD, yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");

        magnitudeTextView.setText(earthquake.getMagnitude());
        locationTextView.setText(earthquake.getLocation());
        dateTextView.setText(dateFormat.format(dateObject));
        timeTextView.setText(timeFormat.format(dateObject));

        return listItemView;
    }
}
