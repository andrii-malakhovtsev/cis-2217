// Andrii Malakhovtsev
// 05.09.2025
// Final Project - NASA data

import java.io.Serializable;

public class Meteorite implements Serializable {
    private String name;
    private String id;
    private String nametype;
    private String recclass;
    private String mass;
    private String fall;
    private String year;
    private String reclat;
    private String reclong;
    private Geolocation geolocation;

    public String getName() { return name; }
    public String getId() { return id; }
    public String getMass() { return mass; }
    public String getYear() { return year; }
    public String getRecclass() { return recclass; }

    private String getYearDigits()
    {
        int yearLength = 4;
        return (year != null && year.length() >= yearLength) ? year.substring(0, yearLength) : "Unknown";
    }

    public String display() {
        return String.format("\tname = %s, id = %s, recclass = %s, mass = %s, year = %s", name, id, recclass, mass, getYearDigits());
    }

    public String toString() {
        return String.format("Meteorite [name=%s, id=%s, nametype=%s, recclass=%s, mass=%s, fall=%s, year=%s, reclat=%s, reclong=%s, geolocation=%s]",
                name, id, nametype, recclass, mass, fall, getYearDigits(), reclat, reclong, geolocation);
    }
}
