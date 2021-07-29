package com.example.ohridcityguide.models;

public class Place {
    private String name;
    private int imageId;
    private String shortDesc;
    private double lat;
    private double lon;

    public Place(String name, int imageId, String shortDesc, double lat, double lon) {
        this.name = name;
        this.imageId = imageId;
        this.shortDesc = shortDesc;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
}
