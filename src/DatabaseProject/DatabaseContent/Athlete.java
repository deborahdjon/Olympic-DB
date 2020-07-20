package DatabaseProject.DatabaseContent;

import java.util.ArrayList;

public class Athlete {
    private Integer id;
    private final Integer weight; // never gets updated
    private static Integer height;
    private Integer age;
    private static String gender;
    private ArrayList<String> name;
    private ArrayList<Team> teams;
    private Medals medals;
    private Status status;

    public Athlete(Integer id, Integer weight, Integer height, Integer age, String gender, String name, Team team, Medals medals){
        if(id !=null){
            this.id = id;
        }
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
        this.name = new ArrayList<String>();
        this.addName(name);
        this.teams = new ArrayList<Team>();
        this.addTeam(team);
        this.medals = medals;
    }


    public Integer getId() {
        return this.id;
    }
    public Integer setId(Integer newId){this.id  = newId}
    public Integer getWeight(){
        return this.weight;
    }

    public Integer getAge(){
        return this.age;
    }
    public void setAge(Integer newAge){//TODO: throw exception for invalid input
        this.age = newAge;
    }
    public String getGender(){
        return this.gender;
    }
    public ArrayList<String> getName(){
        return this.name;
    }
    public void addName(String newName){//TODO: throw exception for invalid input
        this.name.add(newName);
    }
    public ArrayList<Team> getTeams(){
        return this.teams;
    }
    public void addTeam(Team newTeam){//TODO: throw exception for invalid input
        this.teams.add(newTeam);
    }
    public void changeStatus(Status newStatus){
        this.status = newStatus;
    }
    public Status getStatus(){return this.status;}
    public Medals getMedals(){return this.medals;}

}
