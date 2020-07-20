package DatabaseProject.DatabaseContentAdmins;

import DatabaseProject.DatabaseContent.Sport;

import java.util.ArrayList;
import java.util.HashMap;

public class SportsAdmin implements AdminInterface {
    HashMap<String,Sport> sports;

    public SportsAdmin(){

    }

    @Override
    public void removeElement(String sportName) {

    }

    @Override
    public ArrayList<Sport> search(String sportName) {
        return null;
    }



}
