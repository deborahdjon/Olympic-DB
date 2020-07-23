package DatabaseProject.DatabaseContentAdmins;

import DatabaseProject.DatabaseContent.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Admin<T>{
    private HashMap<String, T> storage;

    public Admin(){
        this.storage = new HashMap<>();

    }

    public static ArrayList<DatabaseContent> search(String searchString, HashMap<String , DatabaseContent> data){
        ArrayList<DatabaseContent> results = new ArrayList<>();
        data.forEach((key,value)->{
            if (key.contains(searchString)) {
                results.add(value);
            }
        });
        return results;
    }

    public void remove(String identefier){
       this.storage.remove(identefier); //Todo: catch element deosn't exist error
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

    public void add(String identifier, T newContent, Status status){
       if(this.storage.get(identifier)!=null && newContent instanceof DatabaseContent){
           ((DatabaseContent) newContent).changeStatus(status);
           storage.put(identifier, newContent);
       }else{
           if(this.storage.get(identifier) instanceof DatabaseContent){
              ((DatabaseContent) this.storage.get(identifier)).update(identifier,(DatabaseContent) newContent);
           }
       }
    }

    public HashMap<String, T> getStorage(){
       return this.storage;
    }



}
