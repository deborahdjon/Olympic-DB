package DatabaseProject.DatabaseContent;

import java.util.ArrayList;

public class Athlete {
    int id;
    int weight;
    int age;
    String gender;
    String[] name;
    ArrayList teams;
    Medals medals;
    boolean newOrWasUpdated;

    public Athlete(int id, int weight, int age, String gender, String[] name, ArrayList<Team> teams, Medals medals, boolean newOrWasUpdated){
        this.id = id;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.teams = teams;
        this.medals = medals;
        this.newOrWasUpdated = newOrWasUpdated;
    }

    public Athlete(int weight, int age, String gender, String[] name, ArrayList<Team> teams, Medals medals, boolean newOrWasUpdated){
        this.weight = weight;
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.teams = teams;
        this.medals = medals;
        this.newOrWasUpdated = newOrWasUpdated;

    }
}
