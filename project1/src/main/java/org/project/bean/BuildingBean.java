package org.project.bean;

public class BuildingBean {

    private int id;
    private String name;
    private String address;
    private String city;
    private double latitude;
    private double longitude;
    private String type;
    private double price;
    private int area;
    private String eClass;

    public BuildingBean() {
        id = 0;
        name = "";
        address = "";
        city = "";
        latitude = 0.0;
        longitude = 0.0;
        type = "";
        price = 0.0;
        area = 0;
        eClass = "a";
    }

    public BuildingBean(int id, String n, String ad, String city, double lat, double lng, String type, double price, int area, String ch) {
        this.id = id;
        this.name = n;
        this.address = ad;
        this.city = city;
        this.latitude = lat;
        this.longitude = lng;
        this.type = type;
        this.price = price;
        this.area = area;
        this.eClass = ch;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String geteClass() {
        return eClass;
    }

    public void seteClass(String eClass) {
        this.eClass = eClass;
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
