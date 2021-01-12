package com.igligoric.jmbg;

class Region {

    private int regionNumber;

    private String regionName;

    private PoliticalRegion politicalRegion;


    public Region(int regionNumber, String regionName, PoliticalRegion politicalRegion) {
        this.regionNumber = regionNumber;
        this.regionName = regionName;
        this.politicalRegion = politicalRegion;
    }


    String getRegionName() {
        return regionName;
    }

    int getRegionNumber() {
        return regionNumber;
    }

    public PoliticalRegion getPoliticalRegion() {
        return politicalRegion;
    }

}
