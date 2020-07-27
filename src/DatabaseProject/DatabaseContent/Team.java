package DatabaseProject.DatabaseContent;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Team extends DatabaseContent{
    private SimpleStringProperty noc;
    private ArrayList<OlympicGame> olympicGames;

    public Team(String name, String noc){
        this.setName(name);
        this.noc = new SimpleStringProperty(noc);
        this.olympicGames = new ArrayList<>();
    }

    public void addOlympicGame(OlympicGame game){
        this.olympicGames.add(game);
    }
    public String getNoc(){
        return this.noc.get();
    }
    public ArrayList<OlympicGame> getOlympicGames(){
        return this.olympicGames;
    }

    @Override
    public void update(String identifier, DatabaseContent updatedObject, HashMap<String,
                         DatabaseContent> referenceAdminStore) {

        if (updatedObject instanceof Team){
            Team teamUpdate = (Team) updatedObject;
            String nameOfOlympicGameToUpdate = teamUpdate.olympicGames.get(0).getName();

            AtomicBoolean olympicGameContained = new AtomicBoolean(false);
            OlympicGame olympicGameToAdd = (teamUpdate.getOlympicGames().get(0));
            this.getOlympicGames().forEach(game -> {
                if (olympicGameToAdd.getName().equals(game.getName())){
                    olympicGameContained.set(true);
                }
            });


            if (!olympicGameContained.get()){
                if(referenceAdminStore.get(nameOfOlympicGameToUpdate) instanceof OlympicGame){
                    this.addOlympicGame((OlympicGame) referenceAdminStore.get(nameOfOlympicGameToUpdate));
                }
            }

        }else { //TOdo get rud
            throw new Error("wrong type");
        }

    }

}
