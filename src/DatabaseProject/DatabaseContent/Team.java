package DatabaseProject.DatabaseContent;

import java.util.ArrayList;
import java.util.HashMap;

public class Team extends DatabaseContent{
    private String noc;
    private ArrayList<OlympicGame> olympicGames;

    public Team(String name, String NOC){
        this.addName(name);
        this.noc = NOC;
        this.olympicGames = new ArrayList<OlympicGame>();
    }

    public void addOlympicGame(OlympicGame game){
        this.olympicGames.add(game);
    }
    public String getNoc(){
        return this.noc;
    }

    @Override
    public void update(String identifier, DatabaseContent updatedObject) {
        // 1: Tu erst mal alle teams rein (ohne olympics, remove duplicates)
        // 2: adde die olympic games
        // "Teamname": "Teamname" "NOC", olympicGame[]

    }

    @Override
    public HashMap<ArrayList<String>, HashMap<String, String>> returnData() {
        return null;
    }
}
