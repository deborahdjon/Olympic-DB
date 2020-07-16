package com.TINF19A;

import java.util.ArrayList;

public class Sport {
    private String name;
    private ArrayList<Event> sportEvents;

    public Sport(String name){
        this.name = name;
    }

    public void addSportEvent(Event event){
        this.sportEvents.add(event);
    }
}
