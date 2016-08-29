package com.daisy.quakereport;

/**
 * Created by eric on 8/25/16.
 */

public class Earthquake {
    private String magnitude;
    private String location;
    private String date;

    public Earthquake(String magnitude, String location, String date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getMagnitude() {
        return magnitude;
    }
}
