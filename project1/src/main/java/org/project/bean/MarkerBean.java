package org.project.bean;

public class MarkerBean {

    private int id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private String type;

    public MarkerBean() {
        id = 0;
        name = "";
        address = "";
        latitude = 0.0;
        longitude = 0.0;
        type = "";
    }

    public MarkerBean(int id, String n, String ad, double lat, double lng, String type) {
        this.id = id;
        this.name = n;
        this.address = ad;
        this.latitude = lat;
        this.longitude = lng;
        this.type = type;
    }

    public String toString() {
        return this.id + " " + this.name + " " + this.address + " " + this.latitude + " " + this.longitude + " " + this.type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
