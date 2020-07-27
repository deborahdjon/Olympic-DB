package DatabaseProject.DatabaseContent;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Athlete extends DatabaseContent{
    private SimpleIntegerProperty id; //TODO change to String ??
    private final SimpleIntegerProperty weight; // never gets updated
    private SimpleIntegerProperty height;
    private SimpleIntegerProperty age;
    private final SimpleStringProperty gender;
    private ArrayList<Team> teams;
    private Medals medals;

    public Athlete(Integer id, Integer weight, Integer height, Integer age, String gender, String name, Team team, Medals medals){
        this.id = new SimpleIntegerProperty(id);
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
    public void update(String identifier, DatabaseContent updatedObject, HashMap<String, DatabaseContent> referenceAdminStore) {
        if(updatedObject instanceof Athlete){
            Athlete athleteUpdate = (Athlete) updatedObject;

            String nameUpdate = athleteUpdate.getName();
            if ((!this.getName().contains(nameUpdate)) && !(athleteUpdate.getName().equals("NA"))){
                this.addName(athleteUpdate.getName());
            }

            if((athleteUpdate.getAge())>this.getAge()){
                this.setAge(athleteUpdate.getAge());
            }

            if((athleteUpdate.getHeight())>this.getHeight()){
                this.setHeight(athleteUpdate.getHeight());
            }

            String nameOfTeamToUpdate = (athleteUpdate.getTeams().get(0).getName());
            AtomicBoolean teamContained = new AtomicBoolean(false);
            this.teams.forEach(team -> {
                if(team.getName().equals(nameOfTeamToUpdate)){
                    teamContained.set(true);
                }
            });
            if(!teamContained.get()){
                DatabaseContent teamToAdd = referenceAdminStore.get(nameOfTeamToUpdate);
                if (teamToAdd instanceof Team){
                    this.addTeam((Team) teamToAdd);
                }
            }

            //Add Medal
            MedalsUpdate update= Medals.getUpdate(athleteUpdate.getMedals());
            if(update != null){
                this.medals.addMedal(update.getType(), update.getEvent());
            }
        }else{//TODO rm
            throw new Error("Wrong type");
        }

    }


}
