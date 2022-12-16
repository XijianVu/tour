package com.example.frag.model;

import java.util.Date;

public class Ticket {
    private String name, phoneCustom, emailCustom;
    private int people_amount, child_amount;
    String nameTour;
    String timeTour;
    String placeTour;
    String placeStart;
    String pricePeople ;
    String priceChild;
    String time;

    public Ticket() {

    }

    public Ticket(String name, int people_amount, int child_amount, String nameTour, String timeTour, String placeTour, String placeStart, String pricePeople, String priceChild,  String phoneCustom, String emailCustom, String time) {
        this.name = name;
        this.people_amount = people_amount;
        this.child_amount = child_amount;
        this.nameTour = nameTour;
        this.timeTour = timeTour;
        this.placeTour = placeTour;
        this.placeStart = placeStart;
        this.pricePeople = pricePeople;
        this.priceChild = priceChild;
        this.phoneCustom = phoneCustom;
        this.emailCustom = emailCustom;
        this.time = time;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneCustom() {
        return phoneCustom;
    }

    public void setPhoneCustom(String phoneCustom) {
        this.phoneCustom = phoneCustom;
    }

    public String getEmailCustom() {
        return emailCustom;
    }

    public void setEmailCustom(String emailCustom) {
        this.emailCustom = emailCustom;
    }

    public int getPeople_amount() {
        return people_amount;
    }

    public void setPeople_amount(int people_amount) {
        this.people_amount = people_amount;
    }

    public int getChild_amount() {
        return child_amount;
    }

    public void setChild_amount(int child_amount) {
        this.child_amount = child_amount;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
