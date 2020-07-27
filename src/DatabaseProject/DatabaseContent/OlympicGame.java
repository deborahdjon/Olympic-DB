package DatabaseProject.DatabaseContent;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.HashMap;

public class OlympicGame extends DatabaseContent{
    private final SimpleIntegerProperty year;
    private final SimpleStringProperty city;
    private final SimpleStringProperty season;
    private ArrayList<Event> events;

    public OlympicGame(int year, String name, String city, String season){
        this.year = new SimpleIntegerProperty(year);
        this.setName(name);
        this.city = new SimpleStringProperty(city);
        this.season = new SimpleStringProperty(season);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }
    public void addEvent(Event event){
        this.events.add(event);
    }
    /**Puts the event names into a string array for display in the user interface.
     * @return List of events in this Olympic game.*/
    public ArrayList<String> getEventsString(){
        ArrayList<Event> events = getEvents();
        ArrayList <String> eventsStrings = new ArrayList<>();
        events.forEach(event -> eventsStrings.add(event.getName()));
        return eventsStrings;
    }
    public int getyear(){
        return this.year.get();
    }
    public String getCity(){
        return this.city.get();
    }
    public String getSeason(){return this.season.get();}


    @Override
    public void update(String identifier, DatabaseContent updatedObject, HashMap<String, DatabaseContent> referenceAdminStore) {
        if (updatedObject instanceof OlympicGame){
            this.addEvent(((OlympicGame) updatedObject).getEvents().get(0));
        }else{ //TODO: Rm
            throw new Error("Wrong type");
        }
    }
}
