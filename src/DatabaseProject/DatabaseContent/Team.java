package DatabaseProject.DatabaseContent;

import java.util.ArrayList;

public class Team {
    private String name;
    private String NOC;
    private ArrayList<OlympicGame> olympicGames;

    public Team(String name, String NOC){
        this.name = name;
        this.NOC = NOC;
        this.olympicGames = new ArrayList<OlympicGame>();

    }

    public void addOlympicGame(OlympicGame game){
        this.olympicGames.add(game);
    }
}
