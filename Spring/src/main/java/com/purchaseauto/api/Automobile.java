package com.purchaseauto.api;

public class Automobile {
    private String make;
    private String year;
    private Boolean accepted;

    public String getMake() {
        return make;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public String getYear() {
        return year;
    }

    public Automobile(String make, String year) {
        super();
        this.make = make;
        this.year = year;
    }
}
