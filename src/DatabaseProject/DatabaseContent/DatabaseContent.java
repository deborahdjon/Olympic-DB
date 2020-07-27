package DatabaseProject.DatabaseContent;

import java.util.ArrayList;

public abstract class DatabaseContent implements HandleContents, java.io.Serializable {
    private Status status;
    private ArrayList<String> name; //TODO just a String, you can add a name with name + ", "+ newName
    public DatabaseContent(){
        this.status = Status.OLD;
        this.name = new ArrayList<>();
    }

    public Status getStatus(){
        return this.status;
    }
    public void changeStatus(Status newStatus){
        this.status = newStatus;
    }
    public void addName(String newName){
        this.name.add(newName);
    }
    public ArrayList<String> getName(){
        return this.name;
    }
}
