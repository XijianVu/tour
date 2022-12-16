package com.example.frag.model;

public class Tour2 {
    String resourceId;
    String name;
    String pricePeople ;
    String priceChild;
    String timeTour;
    String placeTour;
    String placeStart;
    String about;

    public Tour2(){

    }

    public Tour2(String about, String name, String placeStart, String placeTour, String priceChild, String pricePeople, String resourceId, String timeTour) {
        this.resourceId = resourceId;
        this.name = name;
        this.pricePeople = pricePeople;
        this.priceChild = priceChild;
        this.timeTour = timeTour;
        this.placeTour = placeTour;
        this.placeStart = placeStart;
        this.about = about;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPricePeople() {
        return pricePeople;
    }

    public void setPricePeople(String pricePeople) {
        this.pricePeople = pricePeople;
    }

    public String getPriceChild() {
        return priceChild;
    }

    public void setPriceChild(String priceChild) {
        this.priceChild = priceChild;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
