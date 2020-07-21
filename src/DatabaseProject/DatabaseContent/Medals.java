package DatabaseProject.DatabaseContent;

import java.util.ArrayList;
import java.util.HashMap;

public class Medals {
    private HashMap<MedalType, ArrayList<Event>> medals= new HashMap<MedalType, ArrayList<Event>>();
    public Medals(){
        this.medals.put(MedalType.GOLD, new ArrayList<Event>());
        this.medals.put(MedalType.SILVER, new ArrayList<Event>());
        this.medals.put(MedalType.BRONZE, new ArrayList<Event>());
    }

    public enum MedalType{
        GOLD,
        SILVER,
        BRONZE
    }

    public  HashMap<MedalType, ArrayList<Event>> getMedals(){
        return this.medals;
    }
    public ArrayList<Event> getGold(){return this.medals.get(MedalType.GOLD);};
    public ArrayList<Event> getSilver(){return this.medals.get(MedalType.SILVER);};
    public ArrayList<Event> getBronze(){return this.medals.get(MedalType.BRONZE);};
    public void addMedal(Event event, MedalType color){
        if (color == MedalType.GOLD){ //TODO could be converted to enum
            this.medals.get(MedalType.GOLD).add(event);
        }else if(color == MedalType.SILVER){
            this.medals.get(MedalType.SILVER).add(event);
        }else if(color == MedalType.BRONZE){
            this.medals.get(MedalType.BRONZE).add(event);
        } //TODO: Some error handling for when I enter the wrong thing
    }
}
