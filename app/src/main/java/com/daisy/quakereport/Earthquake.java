package com.daisy.quakereport;

/**
 * Created by eric on 8/25/16.
 */

public class Earthquake {
    private double magnitude;
    private String location;
    private long date;

    public Earthquake(double magnitude, String location, long date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
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
