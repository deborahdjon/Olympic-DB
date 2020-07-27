package DatabaseProject.DatabaseContent;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class OlympicGame extends DatabaseContent{
    private SimpleIntegerProperty year;
    private SimpleStringProperty city;
    private ArrayList<Event> events;
    public OlympicGame(int year, String name, String city){
        this.year = new SimpleIntegerProperty(year);
        this.setName(name);
        this.city = new SimpleStringProperty(city);
    }
    public void addEvent(Event event){
        this.events.add(event);
    }

    public int getyear(){
        return this.year.get();
    }

    public String getCity(){
        return this.city.get();
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public ArrayList<String> getEventsString(){
        ArrayList<Event> events = getEvents();
        ArrayList <String> eventsStrings = new ArrayList<>();
        events.forEach(event -> eventsStrings.add(event.getName()));
        return eventsStrings;
    }

    @Override
    public void update(String identifier, DatabaseContent updatedObject) {

        //1: Tu alle rein, soollen unique sein,  sonst remove duplicates
         //"int Year", "Gamesname","Season","City"
    }

}
