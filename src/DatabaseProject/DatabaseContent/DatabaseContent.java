package DatabaseProject.DatabaseContent;

import javafx.beans.property.SimpleStringProperty;

public abstract class DatabaseContent implements HandleContents, java.io.Serializable {
    private Status status;
    private SimpleStringProperty name; //TODO just a String, you can add a name with name + ", "+ newName
    public DatabaseContent(){
        this.status = Status.OLD;
    }

    public Status getStatus(){
        return this.status;
    }
    public void changeStatus(Status newStatus){
        this.status = newStatus;
    }
    public void setName(String name){
        this.name = new SimpleStringProperty(name);
    }
    public void addName(String newName){
        this.name= new SimpleStringProperty(this.name.get()+", "+newName);
    }
    public String getName(){
        return this.name.get();
    }
}
