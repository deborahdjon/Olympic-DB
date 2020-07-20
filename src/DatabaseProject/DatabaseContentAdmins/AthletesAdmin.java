package DatabaseProject.DatabaseContentAdmins;

import DatabaseProject.DatabaseContent.Athlete;

import java.util.ArrayList;
import java.util.HashMap;

public class AthletesAdmin implements AdminInterface {
    private HashMap<Integer, Athlete> athletes;

    public AthletesAdmin(){

    }



    @Override
    public void removeElement(String id){

    }

    @Override
    public ArrayList<Athlete> search(String name) {
        return null;
    }


    public Athlete searchByID(){
        return null;
    }

}
