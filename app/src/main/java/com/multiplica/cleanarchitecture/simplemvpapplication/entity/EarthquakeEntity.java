package com.multiplica.cleanarchitecture.simplemvpapplication.entity;

/**
 * Created by user on 07/11/18.
 */

public class EarthquakeEntity {

    private int id;
    private String place;
    private long time;
    private String title;
    private double latitude;
    private double longitude;

    public String getPlace() {
        return place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
