package com.TINF19A;

import java.util.ArrayList;

public class AthletesAdmin extends Admin{
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
