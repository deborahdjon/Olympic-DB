package DatabaseProject.DatabaseContentAdmins;

import DatabaseProject.DatabaseContent.OlympicGame;

import java.util.ArrayList;

public class OlympicGamesAdmin implements AdminInterface {
    private ArrayList<OlympicGame> olympicGamesFromDatabase;
    private ArrayList<OlympicGame> olympicGamesFromUser;

    public OlympicGamesAdmin(){

    }



    @Override
    public void removeElement(){

    }

    @Override
    public ArrayList<OlympicGame> search() {
        return null;
    }

    @Override
    public void addElement(String userOrDB) {
        //if user

        //if db

    }
}


