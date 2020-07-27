package DatabaseProject.DatabaseContentAdmins;

import DatabaseProject.DatabaseContent.Event;
import DatabaseProject.DatabaseContent.Sport;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class concerned with searching events in a Sports Admin.*/

public class EventSearcher {
    /**
     * Searching Events in a Hashmap with sports.
     * @param sports Hashmap with Sportname as key and Sport as value.
     * @param searchString search from user input.
     * @return String Array list with matching event names.*/
    public static ArrayList<String> searchEvents(HashMap<String, Sport> sports, String searchString){
        ArrayList<String> matches = new ArrayList<>();
        sports.forEach((key,value)->{
            ArrayList<Event> SportEvents= value.getSportEvents();
            SportEvents.forEach(event -> {
                if(event.getName().contains(searchString)){
                    matches.add(event.getName());
                }
            });
        });
        return matches;
    }
}
