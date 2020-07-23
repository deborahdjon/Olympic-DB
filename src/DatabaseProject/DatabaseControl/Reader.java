package DatabaseProject.DatabaseControl;

import DatabaseProject.DatabaseContent.*; // TODO: should I lis all?
import DatabaseProject.DatabaseContent.Event;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;



public class Reader {
    /**
     * Class Concerned with reading in the entries from the file and the user into the program.
     * @param dbFilename Name of the database file.
     */

    private int lastId=0;

    private static ArrayList<String[]> dbContent;

    private HashMap<String, Athlete> athletesInit;
    private HashMap<String, Team> teamsInit;
    private HashMap<String, OlympicGame> olympicGamesInit;
    private HashMap<String, Sport> sportsInit;


    private Athlete athleteToAdd;
    private Team teamToAdd;
    private OlympicGame olympicGameToAdd;
    private Sport sportToAdd;

    public Reader(String dbFilename){
        dbContent = readInFile(dbFilename);
        for(String[] entry :dbContent){
            transformEntry(entry);
        }
    }

    public Reader(String[] entry){
        transformEntry(entry);
    }

    //TODO: Reader with all attributes (add entry)
    //TODO: Reader with all attributes but no id (new result)



    private ArrayList<String[]> readInFile(String filename){
        /**
         * Reads in all results from the database file into a large ArrayList.
         * Each result in the database file is one String[].
         * @return ArrayList<String[]>.
         * @param filename Name of the database file.
         * @throws FileNotFoundException when file does not exist.
         * @throws IOException when the wrong datatype is assigned or passed.
         */


        ArrayList<String[]> content = new ArrayList<String[]>();
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


    private void transformEntry(String[] entry){
        /**
         * Function that takes one entry (row from the database file) and converts
         * it into the datastructures from the DatabseContent package.
         * @param entry String array that contains one column entry from the data base at each index.
         * @return none*/

        // Read all entry fileds
        Integer id;
        // In case user entry no id given
        try{
            id  = Integer.parseInt(entry[0]);
            if(id>this.lastId){
                this.lastId = id;
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
            athleteAge = null;
        }
        Integer athleteHeight;
        try{
            athleteHeight=Integer.parseInt(entry[4]);
        }catch(NumberFormatException e){
            athleteHeight = null;
        }
        Integer athleteWeight;
        try{
            athleteWeight = Integer.parseInt(entry[5]);
        }catch (NumberFormatException e){
            athleteWeight=null;
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
        OlympicGame firstOlympicGame = new OlympicGame(gamesYear, gamesName, gamesCity);
        Team firstTeam= new Team(teamName, nocName, firstOlympicGame);
        this.teamToAdd = firstTeam;
        this.teamsInit.put(this.teamToAdd.getName().get(0), firstTeam);

        // Fill olympicGameToAdd
        this.olympicGameToAdd = firstOlympicGame;
        this.olympicGamesInit.put(this.olympicGameToAdd.getName().get(0), firstOlympicGame);

        // Fill athlete to add
        Team firstAthleteTeam = new Team(teamName, nocName, firstOlympicGame );
        Event medalEvent = new Event(eventName);
        Medals medalsInit = new Medals();
        if(medalColor.equals("Bronze")){
            medalsInit.addMedal(Medals.MedalType.BRONZE, medalEvent);
        }else if(medalColor.equals("Silver")){
            medalsInit.addMedal(Medals.MedalType.SILVER, medalEvent);
        }else if(medalColor.equals("Gold")){
            medalsInit.addMedal(Medals.MedalType.GOLD, medalEvent);
        }
        this.athleteToAdd = new Athlete(id, athleteWeight, athleteHeight,athleteAge, athleteGender, athleteName,firstAthleteTeam, medalsInit);
        this.athletesInit.put(this.athleteToAdd.getId().toString(), this.athleteToAdd);

        // Fill sportToAdd
        Event firstEvent = new Event(eventName);
        this.sportToAdd = new Sport(sportName);
        this.sportToAdd.addSportEvent(firstEvent);
        this.sportsInit.put(this.sportToAdd.getName().get(0), this.sportToAdd);

    }







    public void serializeDataFromUser(HashMap<String, DatabaseContent> toSerialize, String fileName){
        HashMap<String, DatabaseContent> buffer = new HashMap<>();
        toSerialize.forEach((key,value)->{
            if (value.getStatus() == Status.NEW_FROM_USER || value.getStatus() == Status.UPDATED){
                //Serialize code
            }
        });
    }
    public DatabaseContent deserializeDataFromUser(String filename){
        return null;
    }

    public static String[] newResult(String id, String name, String gender, String age, String height,
                                     String weight, String team, String noc, String gameName,String gameYear,
                                     String season, String city, String sport, String event, String medal){

        String[] entry = {id, name, gender, age, height, weight, team, noc, gameName, gameYear,
                            season, city, sport, event, medal};

        /**TODO: Error Handling for user entry
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
}
