package com.TINF19A;

import java.util.ArrayList;

public class Medals {
    private ArrayList<String[]> gold;
    private ArrayList<String[]> silver;
    private ArrayList<String[]> bronze;

    public Medals(){

    }
    public void addMedal(String event, String color){
        String[] medalToAdd = {event, color};
        if (color == "gold"){
            this.gold.add(medalToAdd);
        }if(color == "silver"){
            this.silver.add(medalToAdd);
        }if(color == "bronze"){
            this.bronze.add(medalToAdd);
        }
        //TODO: Some error handling for when I enter the wrong thing
    }
}
