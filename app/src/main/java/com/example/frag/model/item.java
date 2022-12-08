package com.example.frag.model;

public class item {
    private int resourceId;
    private String nametab1;
    private String infortab1;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getNametab1() {
        return nametab1;
    }

    public void setNametab1(String nametab1) {
        this.nametab1 = nametab1;
    }

    public String getInfortab1() {
        return infortab1;
    }

    public void setInfortab1(String infortab1) {
        this.infortab1 = infortab1;
    }

    public item(int resourceId, String nametab1, String infortab1) {
        this.resourceId = resourceId;
        this.nametab1 = nametab1;
        this.infortab1 = infortab1;
    }
}
