package com.company;

public abstract class Region {
    protected String name;
    protected Integer TypeOfRegion;
    protected boolean northIsAvailable;
    protected boolean westIsAvailable;
    protected boolean eastIsAvailable;

    void determineRegionDirections() {
        northIsAvailable = random() > 0.5 ? true : false;
        westIsAvailable = random() > 0.5 ? true : false;
        eastIsAvailable = random() > 0.5 ? true : false;
    }

    void determineRegionType() {
        TypeOfRegion = random() * 10;
    }
}
