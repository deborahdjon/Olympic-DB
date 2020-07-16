package com.TINF19A;

import java.util.ArrayList;

public class TeamsAdmin extends Admin{
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
