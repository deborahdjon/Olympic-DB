package DatabaseProject.DatabaseContent;

import javafx.event.Event;

import java.util.ArrayList;
import java.util.HashMap;

public class OlympicGame extends DatabaseContent{
    private int year;
    private String city;
    private ArrayList<Event> events;
    public OlympicGame(int year, String name, String city){
        this.year = year;
        this.addName(name);
        this.city = city;
    }
    public void addEvent(Event event){
        this.events.add(event);
    }

    public int getyear(){
        return this.year;
    }

    public String getCity(){
        return this.city;
    }

    @Override
    public HashMap<ArrayList<String>, HashMap<String, String>> returnData() {
        return null;
    }

    @Override
    public void update(String identifier, DatabaseContent updatedObject) {

        //1: Tu alle rein, soollen unique sein,  sonst remove duplicates
         //"int Year", "Gamesname","Season","City"
    }

}
