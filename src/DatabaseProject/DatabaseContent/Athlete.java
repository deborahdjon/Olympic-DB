package DatabaseProject.DatabaseContent;

import java.util.ArrayList;
import java.util.HashMap;

public class Athlete extends DatabaseContent{
    private Integer id; //TODO change to String ??
    private final Integer weight; // never gets updated
    private static Integer height;
    private Integer age;
    private static String gender;
    private ArrayList<Team> teams;
    private Medals medals;

    public Athlete(Integer id, Integer weight, Integer height, Integer age, String gender, String name, Team team, Medals medals){
        if(id !=null){
            this.id = id;
        }
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
        this.addName(name);
        this.teams = new ArrayList<Team>();
        this.addTeam(team);
        this.medals = medals;
    }

    //TODO Set all to private
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer newId){this.id  = newId;}
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
    public ArrayList<Team> getTeams(){
        return this.teams;
    }
    public void addTeam(Team newTeam){//TODO: throw exception for invalid input
        this.teams.add(newTeam);
    }
    public Medals getMedals(){return this.medals;}

    @Override
    public HashMap<ArrayList<String>, HashMap<String, String>> returnData() {
        return null;
    }

    @Override
    public void update(String identifier, DatabaseContent updatedObject) {
        // 1:Indecies are ids check by indecy if it exists
         //"ID": "Name","Sex","Age","Height","Weight", teams[team_name, noc], medal[]
        if (this.getName().contains(updatedObject.getName().get(0)==null)){
            this.addName(updatedObject.getName().get(0));
        }
        // how do I make sure this is an athlete

    }


}
