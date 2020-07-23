package DatabaseProject.DatabaseContent;

/**Class for storing an update to a medal.*/

public class MedalsUpdate {
    private final Medals.MedalType type;
    private final Event event;
    /**Initialize the event and the type of the medal update.
     * @param typeUpdate medal type.
     * @param eventUpdate event*/
    public MedalsUpdate(Medals.MedalType typeUpdate, Event eventUpdate){
        this.type = typeUpdate;
        this.event = eventUpdate;
    }

    public Event getEvent() {
        return event;
    }

    public Medals.MedalType getType() {
        return type;
    }
}
