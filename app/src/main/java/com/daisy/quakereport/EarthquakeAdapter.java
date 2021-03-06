package com.daisy.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by eric on 8/25/16.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public static final String LOCATION_SEPARATOR = " of ";

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
        TextView nearbyTextView = (TextView) listItemView.findViewById(R.id.tv_nearby_location);
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.tv_primary_location);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.tv_earthquake_date);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        Date dateObject = new Date(earthquake.getDate());
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD, yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String fullLocation = earthquake.getLocation();
        String nearbyLocation;
        String primaryLocation;

        if (fullLocation.contains(LOCATION_SEPARATOR)) {
            nearbyLocation = fullLocation.split(LOCATION_SEPARATOR)[0] + LOCATION_SEPARATOR;
            primaryLocation = fullLocation.split(LOCATION_SEPARATOR)[1];
            locationTextView.setText(primaryLocation);
            nearbyTextView.setText(nearbyLocation);
        } else {
            nearbyTextView.setText("Near the");
            locationTextView.setText(fullLocation);
        }

        DecimalFormat decimalFormatter = new DecimalFormat("0.0");
        String magnitude = decimalFormatter.format(earthquake.getMagnitude());
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
        magnitudeTextView.setText(magnitude);
        dateTextView.setText(dateFormat.format(dateObject));
        timeTextView.setText(timeFormat.format(dateObject));

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColoreResId;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColoreResId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColoreResId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColoreResId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColoreResId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColoreResId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColoreResId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColoreResId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColoreResId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColoreResId = R.color.magnitude9;
                break;
            default:
                magnitudeColoreResId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColoreResId);
    }
}
