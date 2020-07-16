package DatabaseProject.DatabaseContentAdmins;

import DatabaseProject.DatabaseContent.Sport;

import java.util.ArrayList;

public class SportsAdmin implements AdminInterface {
    ArrayList<Sport> sportsFromDataBase;
    ArrayList<Sport> sportsFromUser;

    public SportsAdmin(){

    }

    @Override
    public void removeElement() {

    }

    @Override
    public ArrayList<Sport> search() {
        return null;
    }

    @Override
    public void addElement(String userOrDB) {
        //if user

        //if db

    }

}
