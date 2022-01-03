package com.codegus.walkingbolivia.models.Country;

import java.util.ArrayList;
import java.util.List;

public class Region {

    private int id;
    private String name;
    private String capital;
    private List<Region> subRegionList;

    public Region(){
        id = 0;
        name = "";
        capital = null;
        subRegionList = new ArrayList<>();
    }

    public Region(int id, String name){
        this.id = id;
        this.name = name;
        capital = "";
        subRegionList = new ArrayList<>();
    }

    public Region(int id, String name, String capital, List<Region> subRegionList) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.subRegionList = subRegionList;
    }

    public Region(int id, String name, String capital) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.subRegionList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<Region> getSubRegionList() {
        return subRegionList;
    }

    public void setSubRegionList(List<Region> subRegionList) {
        this.subRegionList = subRegionList;
    }

    public void putSubRegion(Region subRegion){
        subRegionList.add(subRegion);
    }

    public java.lang.String[] getVectorNameList(){
        java.lang.String[] stringList = new java.lang.String[subRegionList.size()];
        for (int i = 0; i< subRegionList.size(); i++) {
            stringList[i] = subRegionList.get(i).getName();
        }
        return stringList;
    }
}
