package com.TINF19A;

import javafx.event.Event;

import java.util.ArrayList;

public class OlympicGame {
    private int year;
    private String name;
    private String city;
    private ArrayList<Event> events;
    public OlympicGame(int year, String name, String city){
        this.year = year;
        this.name = name;
        this.city = city;
    }

    public void addEvent(Event event){
        this.events.add(event);
    }
}
