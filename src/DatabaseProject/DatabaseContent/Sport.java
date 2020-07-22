package DatabaseProject.DatabaseContent;

import java.util.ArrayList;
import java.util.HashMap;

public class Sport extends DatabaseContent{
    private ArrayList<Event> sportEvents;

    public Sport(String name){
        this.addName(name);
        this.sportEvents = new ArrayList<Event>();
    }

    public void addSportEvent(Event event){
        this.sportEvents.add(event);
    }

    public ArrayList<Event> getSportEvents() {
        return this.sportEvents;
    }

    @Override
    public HashMap<ArrayList<String>, HashMap<String, String>> returnData() {
        return null;
    }

    @Override
    public void update(String identifier, DatabaseContent updatedObject) {

        //1: Tu alle sportarten rein, remove dupplicates
        //2: Adde events: checke immer, ob das event schon in event list ist
        // sportart, event[]
    }


}
