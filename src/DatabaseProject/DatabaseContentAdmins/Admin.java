package DatabaseProject.DatabaseContentAdmins;

import DatabaseProject.DatabaseContent.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Admin{
    private HashMap<String, DatabaseContent> storage;

    public Admin(){
        this.storage = new HashMap<String, DatabaseContent>();


    }

    public static ArrayList<DatabaseContent> search(String searchString, HashMap<String , DatabaseContent> data){
        ArrayList<DatabaseProject.DatabaseContent.DatabaseContent> results = new ArrayList<>();
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

    public void initialImport(HashMap<String, DatabaseContent> initialContent, Object desezialize){

       //TODO deserialite all to deserialize objects

       initialContent.forEach((key,value)->{
           if(this.storage.get(key)!=null){
               this.storage.remove(key);
               this.storage.put(key,value);
           }else{
               this.storage.put(key,value);
           }
       });
       // import all of the initial content list
        // function needs to be overridden
    }


    public void add(String identifier, DatabaseContent newContent, Status status){
       if(this.storage.get(identifier)!=null){
           newContent.changeStatus(status);
           storage.put(identifier, newContent);
       }else{
           this.storage.get(identifier).update(identifier, newContent);
       }
    }

    public HashMap<String, DatabaseContent> getStorage(){
       return this.storage;
    }



}
