package DatabaseProject.DatabaseContent;

import java.util.ArrayList;

public class Sport {
    private String name;
    private ArrayList<Event> sportEvents;

    public Sport(String name, Event event)
    {
        this.name = name;
        this.sportEvents = new ArrayList<Event>();
        this.addSportEvent(event);
    }

    public void addSportEvent(Event event){
        this.sportEvents.add(event);
    }

    public String getName() {
        return name;
    }
}
