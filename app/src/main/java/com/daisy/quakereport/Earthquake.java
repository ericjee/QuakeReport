package com.daisy.quakereport;

/**
 * Created by eric on 8/25/16.
 */

public class Earthquake {
    private double magnitude;
    private String location;
    private long date;
    private String earthquakeUrl;

    public Earthquake(double magnitude, String location, long date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public Earthquake(double magnitude, String location, long date, String earthquakeUrl) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
        this.earthquakeUrl = earthquakeUrl;
    }

    public String getEarthquakeUrl() {
        return earthquakeUrl;
    }

    public long getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public double getMagnitude() {
        return magnitude;
    }
}
