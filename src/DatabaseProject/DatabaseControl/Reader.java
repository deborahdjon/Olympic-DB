package DatabaseProject.DatabaseControl;

import DatabaseProject.DatabaseContent.*; // TODO: should I lis all?
import DatabaseProject.DatabaseContent.Event;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


/**Class Concerned with reading in the entries from the file and the user into the program.*/

public class Reader {

    private int lastUnavailableID =0;

    private static ArrayList<String[]> dbContent;

    private HashMap<String, Athlete> athletesAdminStoreInit;
    private HashMap<String, Team> teamsAdminStoreInit;
    private HashMap<String, OlympicGame> olympicGamesAdminStoreInit;
    private HashMap<String, Sport> sportsAdminStoreInit;

    private Athlete athleteToAdd;
    private Team teamToAdd;
    private OlympicGame olympicGameToAdd;
    private Sport sportToAdd;

    /**Initialize the store initialize HashMaps for the Admins*/
    public Reader(String dbFilename){
        this.athletesAdminStoreInit = new HashMap<>();
        this.teamsAdminStoreInit = new HashMap<>();
        this.olympicGamesAdminStoreInit = new HashMap<>();
        this.sportsAdminStoreInit =  new HashMap<>();

        dbContent = readInFile(dbFilename);
        for(String[] entry :dbContent){
            transformEntry(entry);//TODO Splitup
            //TODO Deserialize
        }
    }

    public Reader(String[] entry){
        transformEntry(entry);
    }

    /**
     * Reads in all results from the database file into a large ArrayList.
     * Each result in the database file is one String[].
     * @return ArrayList<String[]>.
     * @param filename Name of the database file.
     */
    private ArrayList<String[]> readInFile(String filename){


        ArrayList<String[]> content = new ArrayList<>();
        String[] entry;
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            while ((line = br.readLine())!=null){
                String patternAllCommasNotInQuotes = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
                entry = line.split(patternAllCommasNotInQuotes, -1);
                for(int i = 0; i<entry.length; i++){
                    entry[i] = entry[i].replace("\"", "");
                }

                content.add(entry);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        //Remove database header
        content.remove(0);

        return content;
    }

    /**Function that takes one entry (row from the database file) and converts
     * it into the datastructures from the DatabseContent package.
     * @param entry String array that contains one column entry from the data base at each index.
     * */

    // TODO Extract Sport Events and Olympic Games
    // TODO Extract Teams
    // TODO Extract Athletes

    private void transformEntry(String[] entry){

        // Read all entry fields
        Integer id;
        try{
            id  = Integer.parseInt(entry[0]);
            if(id>this.lastUnavailableID){
                this.lastUnavailableID = id;
            }
        }catch(NumberFormatException e){ // TODO: Only if empty error should be caught, if entered data is not a number,or doesn't exist, Throw anerror
            id = null;
        }
        String athleteName = entry[1];

        String athleteGender = entry[2];
        Integer athleteAge;
        try {
            athleteAge = Integer.parseInt(entry[3]);
        }catch (NumberFormatException e){
            athleteAge = 0;//TODO try convert to SimpleObjectProperty, they allow null
        }
        Integer athleteHeight;
        try{
            athleteHeight=Integer.parseInt(entry[4]);
        }catch(NumberFormatException e){
            athleteHeight = 0;
        }
        Integer athleteWeight;
        try{
            athleteWeight = Integer.parseInt(entry[5]);
        }catch (NumberFormatException e){
            athleteWeight=0;
        }
        String teamName = entry[6];
        String nocName = entry[7];
        String gamesName = entry[8];
        Integer gamesYear = Integer.parseInt(entry[9]);
        String gamesSeason = entry[10];
        String gamesCity = entry[11];
        String sportName = entry[12];
        String eventName = entry[13];
        String medalColor = entry[14];


        // Fill teamToAdd
        OlympicGame firstOlympicGame = new OlympicGame(gamesYear, gamesName, gamesCity, gamesSeason);
        Team firstTeam= new Team(teamName, nocName);
        firstTeam.addOlympicGame(firstOlympicGame);
        this.teamToAdd = firstTeam;
        this.teamsAdminStoreInit.put(this.teamToAdd.getName(), firstTeam);

        // Fill olympicGameToAdd
        this.olympicGameToAdd = firstOlympicGame;
        this.olympicGamesAdminStoreInit.put(this.olympicGameToAdd.getName(), firstOlympicGame);

        // Fill athlete to add
        if (id == null){
            id = this.lastUnavailableID+1;
            this.lastUnavailableID = id;
        }
        Event medalEvent = new Event(eventName);
        Medals medalsInit = new Medals();
        switch (medalColor) {
            case "Bronze" -> medalsInit.addMedal(Medals.MedalType.BRONZE, medalEvent);
            case "Silver" -> medalsInit.addMedal(Medals.MedalType.SILVER, medalEvent);
            case "Gold" -> medalsInit.addMedal(Medals.MedalType.GOLD, medalEvent);
        }
        this.athleteToAdd = new Athlete(id, athleteWeight, athleteHeight,athleteAge, athleteGender, athleteName,firstTeam, medalsInit);
        this.athletesAdminStoreInit.put(this.athleteToAdd.getId().toString(), this.athleteToAdd);

        // Fill sportToAdd
        Event firstEvent = new Event(eventName);
        this.sportToAdd = new Sport(sportName);
        this.sportToAdd.addSportEvent(firstEvent);
        this.sportsAdminStoreInit.put(this.sportToAdd.getName(), this.sportToAdd);
    }

    public HashMap<String, Athlete> getAthleteInit(){
        return this.athletesAdminStoreInit;
    }
    public HashMap<String, Team> getTeamsAdminStoreInit(){
        return this.teamsAdminStoreInit;
    }
    public HashMap<String, OlympicGame> getOlympicGamesAdminStoreInit(){
        return this.olympicGamesAdminStoreInit;
    }
    public HashMap<String, Sport> getSportsAdminStoreInit(){
        return this.sportsAdminStoreInit;
    }

    public Athlete getAthleteToAdd(){
        return this.athleteToAdd;
    }
    public Team getTeamToAdd(){
        return this.teamToAdd;
    }
    public   OlympicGame getOlympicGameToAdd(){
        return this.olympicGameToAdd;
    }
    public  Sport getSportToAdd(){
        return this.sportToAdd;
    }

    /**Serializes all entries that were added or updated by the user.
     * @param toSerialize Hashmap with AdminStore entries that were added or updated by the user.
     * @param fileName name of the file that stores te serialized object*/
    public void serializeDataFromUser(HashMap<String, DatabaseContent> toSerialize, String fileName){
        HashMap<String, DatabaseContent> buffer = new HashMap<>();
        toSerialize.forEach((key,value)->{
            if (value.getStatus() == Status.NEW_FROM_USER || value.getStatus() == Status.UPDATED){
                //Serialize code
            }
        });
    }
    /**Deserializes serialised AdminStore entries.
     * @param filename name of the file that stores the serialized object.
     * @return Hashmap with AdminStore entries that were added or updated by the user in the last
     * time the programme was run.*/
    public HashMap<String, DatabaseContent> deserializeDataFromUser(String filename){
        return null;
    }

    public static String[] newAthlete(String id, String name, String gender, String age, String height,
                                     String weight, String team, String noc, String gameName,String gameYear,
                                     String season, String city, String sport, String event, String medal){

        String[] entry = {id, name, gender, age, height, weight, team, noc, gameName, gameYear,
                            season, city, sport, event, medal};

        /*TODO: Error Handling for user entry
         * name warning
         * gender can't be edited
         * age can't be below athlete age
         * if the height can#t be below athletes height
         * warn if sport doesn't exist
         * warn if event doesnt exist
         *
         * all fields have to be filled except for id
         * */
        return entry;
    }
    public static String[] newResult(String id, String team, String noc, String gameName, String gameYear,
                                 String season, String city, String sport, String event, String medal){
        String[] entry = {id, "NA", "NA", "NA", "NA", "NA", team, noc, gameName, gameYear,
                season, city, sport, event, medal};
        return entry;
    }


}
