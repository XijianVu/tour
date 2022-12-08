package com.example.frag.model;

public class Tour {
    private int resourceId;
    private String name;
    private String timeTour;
    private String placeTour;
    private String placeStart;
    private String about;
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tour(int resourceId, String name, String timeTour, String placeTour, String placeStart, String about, String price) {
        this.resourceId = resourceId;
        this.name = name;
        this.timeTour = timeTour;
        this.placeTour = placeTour;
        this.placeStart = placeStart;
        this.about = about;
        this.price = price;
    }

    public String getTimeTour() {
        return timeTour;
    }

    public void setTimeTour(String timeTour) {
        this.timeTour = timeTour;
    }

    public String getPlaceTour() {
        return placeTour;
    }

    public void setPlaceTour(String placeTour) {
        this.placeTour = placeTour;
    }

    public String getPlaceStart() {
        return placeStart;
    }

    public void setPlaceStart(String placeStart) {
        this.placeStart = placeStart;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}


