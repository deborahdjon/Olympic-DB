package DatabaseProject.DatabaseContent;

import java.util.ArrayList;

public class Team {
    private String name;
    private String noc;
    private ArrayList<OlympicGame> olympicGames;

    public Team(String name, String NOC, OlympicGame olympicGame){
        this.name = name;
        this.noc = NOC;
        this.olympicGames = new ArrayList<OlympicGame>();
        this.addOlympicGame(olympicGame);
    }

    public void addOlympicGame(OlympicGame game){
        this.olympicGames.add(game);
    }
    public String getName(){
        return this.name;
    }
    public String getNoc(){
        return this.noc;
    }
}
