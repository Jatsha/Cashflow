package com.example.foodtracker.objects;

public class CEntry {
    private String name;
    private double cost;

    public CEntry(String n, double c){
        this.name = n;
        this.cost = c;
    }

    public String getName(){
        return name;
    }

    public Double getPrice() {
        return cost;
    }
}
