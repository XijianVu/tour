package com.example.frag.model;

public class Ticket {
    private String name;
    private int people_amount, people_child;

    public Ticket(String name, int people_amount, int people_child) {
        this.name = name;
        this.people_amount = people_amount;
        this.people_child = people_child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeople_amount() {
        return people_amount;
    }

    public void setPeople_amount(int people_amount) {
        this.people_amount = people_amount;
    }

    public int getPeople_child() {
        return people_child;
    }

    public void setPeople_child(int people_child) {
        this.people_child = people_child;
    }
}
