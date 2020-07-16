package com.TINF19A;

import java.util.ArrayList;

public class Athlete {
    int id;
    int weight;
    int age;
    String gender;
    String[] name;
    ArrayList teams;
    Medals medals;

    public Athlete(int id, int weight, int age, String gender, String[] name, ArrayList<Team> teams, Medals medals){
        this.id = id;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.teams = teams;
        this.medals = medals;
    }

    public Athlete(int weight, int age, String gender, String[] name, ArrayList<Team> teams, Medals medals){
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.teams = teams;
        this.medals = medals;
    }
}
