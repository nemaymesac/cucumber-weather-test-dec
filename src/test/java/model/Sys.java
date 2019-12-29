package model;

public class Sys {
    private int type;
    private long id;
    private double message;
    private String country;
    private short sunrise;
    private short sunset;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public short getSunrise() {
        return sunrise;
    }

    public void setSunrise(short sunrise) {
        this.sunrise = sunrise;
    }

    public short getSunset() {
        return sunset;
    }

    public void setSunset(short sunset) {
        this.sunset = sunset;
    }
}
