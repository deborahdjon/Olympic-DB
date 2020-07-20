package DatabaseProject.DatabaseContentAdmins;

import DatabaseProject.DatabaseContent.Team;

import java.util.ArrayList;
import java.util.HashMap;

public class TeamsAdmin implements AdminInterface {
    private HashMap<String,Team> teams;
    public TeamsAdmin(){

    }



    @Override
    public void removeElement(String teamName) {

    }

    @Override
    public ArrayList<Team> search(String teamName) {
        return null;
    }

}
