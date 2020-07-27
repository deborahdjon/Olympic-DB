package DatabaseProject.DatabaseContent;

import java.util.ArrayList;

public class Sport extends DatabaseContent{
    private ArrayList<Event> sportEvents;

    public Sport(String name){
        this.addName(name);
        this.sportEvents = new ArrayList<>();
    }

    public void addSportEvent(Event event){
        this.sportEvents.add(event);
    }

    public ArrayList<Event> getSportEvents() {
        return this.sportEvents;
    }

    @Override
    public void update(String identifier, DatabaseContent updatedObject) {

        //1: Tu alle sportarten rein, remove dupplicates
        //2: Adde events: checke immer, ob das event schon in event list ist
        // sportart, event[]
    }


}
