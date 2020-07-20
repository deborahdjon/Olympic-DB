package DatabaseProject.DatabaseControl;

import DatabaseProject.DatabaseContent.*; // TODO: should I lis all?

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Reader {
    /**
     * Class Concerned with reading in the entries from the file and the user into the program.
     * @param dbFilename Name of the database file.
     */

    private int lastId;

    private static ArrayList<String[]> dbContent;
    // 0-"ID",
    // 1-"Name",
    // 2-"Sex",
    // 3-"Age",
    // 4-"Height",
    // 5-"Weight",
    // 6-"Team",
    // 7-"NOC",
    // 8-"Games",
    // 9-"Year",
    // 10-"Season",
    // 11-"City",
    // 12-"Sport",
    // 13-"Event",
    // 14-"Medal"
    // 15-"newOrWasUpdated" boolean;

    // Hashmaps are used for time efficienccy, that Way I cam use the key to ckeck quickly whether an entry exists or not
    // I don't have to go through the entire list.

    // 1:Indecies are ids check by indecy if it exists
    private HashMap<Integer, Athlete> athletes; //"ID": "Name","Sex","Age","Height","Weight", teams[team_name, noc], medal[]

    // 1: Tu erst mal alle teams rein (ohne olympics, remove duplicates)
    // 2: adde die olympic games
    private HashMap<String, Team> teams; // "Teamname": "Teamname" "NOC", olympicGame[]

    //1: Tu alle rein, soollen unique sein,  sonst remove duplicates
    private ArrayList<OlympicGame> olympicGames; //"int Year", "Gamesname","Season","City"

    //1: Tu alle sportarten rein, remove dupplicates
    //2: Adde events: checke immer, ob das event schon in event list ist
    private HashMap<String, Sport> sports; // sportart, event[]

    // 1: Alle events rein, duplikate raus
    private ArrayList<Event> events; //"Event"


    private Athlete athleteToAdd;
    private Team teamToAdd;
    private OlympicGame olympicGameToAdd;
    private Sport sportToAdd;
    private Event eventToAdd;

    public Reader(String dbFilename){
        dbContent = readInFile(dbFilename);
        for(String[] entry :dbContent){
            transformEntry(entry);
        }
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


    //ArrayList<String[]> dbContent
//        for(int i =0; i<dbContent.size(); i++){
//        entry = dbContent.get(i);
//        // check if athlete exists
//        //if no create athlete
//    }
    private void transformEntry(String[] entry){
        /**
         * Function that takes one entry (row from the database file) and converts
         * it into the datastructures from the DatabseContent package.
         * @param entry String array that contains one column entry from the data base at each index.
         * @return none*/


        Integer id;

        // In case user entry no id given
        try{
            id  = Integer.parseInt(entry[0]);
//            System.out.println(id);
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

        // Fill olympicGameToAdd
        this.olympicGameToAdd = firstOlympicGame;

        // Fill athlete to add
        Team firstAthleteTeam = new Team(teamName, nocName, firstOlympicGame );
        Event medalEvent = new Event(eventName);
        Medals medalsInit = new Medals();
        if(medalColor.equals("Bronze")){
            medalsInit.addMedal(medalEvent, Medals.MedalType.BRONZE);
        }else if(medalColor.equals("Silver")){
            medalsInit.addMedal(medalEvent, Medals.MedalType.SILVER);
        }else if(medalColor.equals("Gold")){
            medalsInit.addMedal(medalEvent, Medals.MedalType.GOLD);
        }
        this.athleteToAdd = new Athlete(id, athleteWeight, athleteHeight,athleteAge, athleteGender, athleteName,firstAthleteTeam, medalsInit);


        // Fill sportToAdd
        Event firstEvent = new Event(eventName);
        this.sportToAdd = new Sport(sportName, firstEvent); //TODO: maybe I need to split this logically

        // Fill eventToAdd
        this.eventToAdd = firstEvent;


        //TODO: ifelse for athleteWeight and geight

    }

    public static ArrayList<Object> importEntry(Athlete athleteToAdd, Team teamToAdd, OlympicGame olympicGameToAdd, Sport sportToAdd, Event eventToAdd, boolean fromUser, Integer lastId,
                                                    HashMap<Integer, Athlete> existingAthletes, HashMap<String, Team> existingTeams, HashMap<String, Sport> existingSports){
        // Hashmaps are used for time efficienccy, that Way I cam use the key to ckeck quickly whether an entry exists or not
        // I don't have to go through the entire list.
        boolean exists;
        // 1:Indecies are ids check by indecy if it exists
        existingAthletes.putIfAbsent(athleteToAdd.getId(), athleteToAdd);
        if(existingAthletes.get(athleteToAdd.getId()) == null){ // TODO: checked der das??

            if(athleteToAdd.getId() == null){
                athleteToAdd.setId(lastId);
                lastId = lastId+1; //TODO: What to do with this?
            }

            if(fromUser = true){
                athleteToAdd.changeStatus(Status.NEW_FROM_USER);
            }else {
                athleteToAdd.changeStatus(Status.OLD);
            }
            existingAthletes.put(athleteToAdd.getId(), athleteToAdd);
        }else{

        }
        /**HashMap<Integer, Athlete> athletes; //"ID": "Name","Sex","Age","Height","Weight", teams[team_name, nocName], medalColor[]**/

        // 1: Tu erst mal alle teams rein (ohne olympics, remove duplicates)
        /**HashMap<String, Team> teams; // "Teamname": "Teamname" "NOC", olympicGame[]**/

        //1: Tu alle rein, soollen unique sein,
        /**ArrayList<OlympicGame> olympicGames; //"int Year", "Gamesname","City"**/

        //1: Tu alle sportarten rein, remove dupplicates
        //2: Adde events: checke immer, ob das eventName schon in eventName list ist
        /**HashMap<String, Sport> sports; // sportart, eventName[]**/

        // 1: Alle events rein, duplikate raus

        return null;  // Returrntype could be a class here
    }










    public void serializeDataFromUser(List toSerialize, String fileName){
        // create and save as

    }
    public void deserializeDataFromUser(String filename){

    }

    public void newResult(int id, String team, String noc, String Game, int Year, String City, String sport, String medal){

    }
}
