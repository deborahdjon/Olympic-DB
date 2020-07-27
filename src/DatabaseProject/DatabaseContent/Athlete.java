package DatabaseProject.DatabaseContent;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Athlete extends DatabaseContent{
    private SimpleIntegerProperty id; //TODO change to String ??
    private final SimpleIntegerProperty weight; // never gets updated
    private SimpleIntegerProperty height;
    private SimpleIntegerProperty age;
    private final SimpleStringProperty gender;
    private ArrayList<Team> teams;
    private Medals medals;

    public Athlete(Integer id, Integer weight, Integer height, Integer age, String gender, String name, Team team, Medals medals){
        if(id !=null){
            this.id = new SimpleIntegerProperty(id);
        }
        this.weight = new SimpleIntegerProperty(weight);
        this.height = new SimpleIntegerProperty(height);
        this.age = new SimpleIntegerProperty(age);
        setName(name);
        this.teams = new ArrayList<>();
        this.gender = new SimpleStringProperty(gender);
        this.addTeam(team);
        this.medals = medals;
    }

    //TODO Set all to private
    public Integer getId() { return this.id.get(); }
    public void setId(Integer newId){this.id  = new SimpleIntegerProperty(newId);}

    public Integer getWeight(){ return this.weight.get(); }

    public Integer getHeight(){ return this.height.get(); }
    public void setHeight(Integer newHeight){ this.height = new SimpleIntegerProperty(newHeight); }

    public Integer getAge(){
        return this.age.get();
    }
    public void setAge(Integer newAge){//TODO: throw exception for invalid input
        this.age = new SimpleIntegerProperty(newAge);
    }

    public String getGender(){
        return this.gender.get();
    }

    public ArrayList<Team> getTeams(){
        return this.teams;
    }
    public void addTeam(Team newTeam){//TODO: throw exception for invalid input
        this.teams.add(newTeam); }

    public Medals getMedals(){return this.medals;}



    @Override
    public void update(String identifier, DatabaseContent updatedObject) {
        if(updatedObject instanceof Athlete){
            //  Add name
            if (!this.getName().contains(updatedObject.getName())){
                this.addName(updatedObject.getName());
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
