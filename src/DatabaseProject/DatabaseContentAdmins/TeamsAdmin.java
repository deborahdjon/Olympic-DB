package DatabaseProject.DatabaseContentAdmins;

import DatabaseProject.DatabaseContent.Team;

import java.util.ArrayList;

public class TeamsAdmin implements AdminInterface {
    private ArrayList<Team> teamsFromDataBase;
    private ArrayList<Team> teamsFromUser;

    public TeamsAdmin(){

    }

    @Override
    public void addElement(String userOrDB) {
        //if user

        //if db

    }

    @Override
    public void removeElement() {

    }

    @Override
    public ArrayList<Team> search() {
        return null;
    }

    public ArrayList<Team> getTeamsFromUser() {
        return teamsFromUser;
    }




}
