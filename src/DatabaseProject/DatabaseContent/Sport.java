package DatabaseProject.DatabaseContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

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
    public void update(String identifier, DatabaseContent updatedObject, HashMap<String, DatabaseContent> referenceAdminStore) {
        if (updatedObject instanceof Sport){
            Sport sportUpdate =(Sport) updatedObject;
            AtomicBoolean eventContained = new AtomicBoolean(false);
            Event eventToAdd = (sportUpdate.getSportEvents().get(0));
            this.getSportEvents().forEach(event -> {
                if (eventToAdd.getName().equals(event.getName())){
                    eventContained.set(true);
                }
            });
            if (!eventContained.get()){
                this.addSportEvent(eventToAdd);
            }
        }else { //TOdo get rud
            throw new Error("wrong type");
        }
    }
}
