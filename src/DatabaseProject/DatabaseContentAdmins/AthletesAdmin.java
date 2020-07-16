package DatabaseProject.DatabaseContentAdmins;

import DatabaseProject.DatabaseContent.Athlete;

import java.util.ArrayList;

public class AthletesAdmin implements AdminInterface {
    private ArrayList<Athlete> athletesFromDatabase;
    private ArrayList<Athlete> athletesFromUser;

    public AthletesAdmin(){

    }

    @Override
    public void addElement(String userOrDB){
        // if user

        // if db

    }

    @Override
    public void removeElement(){

    }

    @Override
    public ArrayList<Athlete> search() {
        return null;
    }

    public ArrayList<Athlete> getAthletesFromUser(int id){
        return athletesFromUser;
    }


}
