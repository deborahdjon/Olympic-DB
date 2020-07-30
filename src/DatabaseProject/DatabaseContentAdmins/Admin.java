package DatabaseProject.DatabaseContentAdmins;

import DatabaseProject.DatabaseContent.*;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static javafx.collections.FXCollections.observableList;

public class Admin<T>{
    private HashMap<String, T> storage;

    public Admin(){
        this.storage = new HashMap<>();

    }

    public ObservableList<T> search(String searchString, HashMap<String , T> data){
        ArrayList<T> results = new ArrayList<>();
        data.forEach((key,value)->{
            if (value instanceof DatabaseContent){
                if (key.toLowerCase().contains(searchString.toLowerCase())) {
                    results.add(value);
                }
            }
        });
        return observableList(results);
    }

    public  ObservableList<T> searchByName(String searchString, HashMap<String , T> data){
        ArrayList<T> results = new ArrayList<>();
        data.forEach((key,value)->{
            if (value instanceof DatabaseContent){

                if (((DatabaseContent) value).getName().toLowerCase().contains(searchString.toLowerCase())) {
                    results.add(value);
                }
            }
        });

        return observableList(results);
    }

    public void remove(String identifier){
       this.storage.remove(identifier); //Todo: catch element deosn't exist error
    }

    public void setStorage(HashMap<String,T> storage){
        this.storage = storage;
    }

    public void initialImport(HashMap<String, T> initialContent, Object desezialize){

       //TODO deserialite all to deserialize objects

        initialContent.forEach((key,value)->{
           if(this.storage.get(key)!=null){
               if(value instanceof DatabaseContent){
                   this.storage.remove(key);
                   this.storage.put(key,value);
               }//TODO else throw error

           }else{
               if(value instanceof DatabaseContent){
                   this.storage.put(key,value);
               }
           } //TODO throw error wrong type
       });
       // import all of the initial content list
        // function needs to be overridden
    }

    public void add(String identifier, T newContent, Status status, HashMap<String, DatabaseContent> referenceAdminstore){
       if(this.storage.get(identifier)!=null && newContent instanceof DatabaseContent){
           ((DatabaseContent) newContent).changeStatus(status);
           storage.put(identifier, newContent);
       }else{
           if(this.storage.get(identifier) instanceof DatabaseContent){
              ((DatabaseContent) this.storage.get(identifier)).update(identifier,(DatabaseContent) newContent, referenceAdminstore);
           }
       }
    }

    public HashMap<String, T> getStorage(){
       return this.storage;
    }



}
