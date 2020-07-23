package DatabaseProject.DatabaseContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Athlete extends DatabaseContent{
    private Integer id; //TODO change to String ??
    private final Integer weight; // never gets updated
    private Integer height;
    private Integer age;
    private final String gender;
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
    public Integer getId() { return this.id; }
    public void setId(Integer newId){this.id  = newId;}

    public Integer getWeight(){ return this.weight; }

    public Integer getHeight(){ return this.height; }
    public void setHeight(Integer newHeight){ this.height = newHeight; }

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
        this.teams.add(newTeam); }

    public Medals getMedals(){return this.medals;}


    @Override
    public HashMap<ArrayList<String>, HashMap<String, String>> returnData() {
        return null;
    }

    @Override
    public void update(String identifier, DatabaseContent updatedObject) {
        if(updatedObject instanceof Athlete){
            //  Add name
            if (!this.getName().contains(updatedObject.getName().get(0))){
                this.addName(updatedObject.getName().get(0));
            }
            // Update age
            if((((Athlete) updatedObject).getAge())>this.getAge()){
                this.setAge(((Athlete) updatedObject).getAge());
            }
            // Update height
            if((((Athlete) updatedObject).getHeight())>this.getHeight()){
                this.setHeight(((Athlete) updatedObject).getHeight());
            }
            // Add team //TODO: this should just be a reference to the team, since the teams can change
            AtomicBoolean teamContained = new AtomicBoolean(false);
            this.teams.forEach(team -> {
                if(team.getName().equals(((Athlete) updatedObject).getTeams().get(0).getName())){
                    teamContained.set(true);
                }
            });
            if(!teamContained.get()){
                this.addTeam(((Athlete) updatedObject).getTeams().get(0));
            }

            //Add Medal
            MedalsUpdate update= Medals.getUpdate(((Athlete) updatedObject).getMedals());
            if(update != null){
                this.medals.addMedal(update.getType(), update.getEvent());
            }
        }else{
            throw new Error("Wrong type");
        }

    }


}
