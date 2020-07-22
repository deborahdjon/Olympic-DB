package DatabaseProject.DatabaseContent;

public class Event{
    /**
     * Class for storing events.
     * @param name Name of the event.*/

    private String name;

    public Event(String eventname){
        this.name = eventname;
    }

    public String getName() {
        return this.name;
    }
}
