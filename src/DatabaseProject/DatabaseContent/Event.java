package DatabaseProject.DatabaseContent;

import javafx.beans.property.SimpleStringProperty;

public class Event{
    /**Class for storing events.*/
    private SimpleStringProperty name;

    /**Set the name property*/
    public Event(String eventName){
        this.name = new SimpleStringProperty(eventName);
    }

    public String getName() {
        return this.name.get();
    }
}
