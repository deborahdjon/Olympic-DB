package DatabaseProject.DatabaseControl;

import DatabaseProject.DatabaseContent.*; // TODO: should I lis all?
import DatabaseProject.DatabaseContentAdmins.AthletesAdmin;
import DatabaseProject.DatabaseContentAdmins.OlympicGamesAdmin;
import DatabaseProject.DatabaseContentAdmins.SportsAdmin;
import DatabaseProject.DatabaseContentAdmins.TeamsAdmin;

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


    public Reader(String dbFilename){
        dbContent = readInFile(dbFilename);
    }

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

    private void populateDatabaseContentClasses(){
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
        /**HashMap<Integer, Athlete> athletes; //"ID": "Name","Sex","Age","Height","Weight", teams[team_name, noc], medal[]**/

        // 1: Tu erst mal alle teams rein (ohne olympics, remove duplicates)
        // 2:
        /**HashMap<String, Team> teams; // "Teamname": "Teamname" "NOC", olympicGame[]**/

        //1: Tu alle rein, soollen unique sein,  sonst remove duplicates
        /**ArrayList<OlympicGame> olympicGames; //"int Year", "Gamesname","Season","City"**/

        //1: Tu alle sportarten rein, remove dupplicates
        //2: Adde events: checke immer, ob das event schon in event list ist
        /**HashMap<String, Sport> sports; // sportart, event[]**/

        // 1: Alle events rein, duplikate raus
        ArrayList<Event> events; //"Event"

        for(int i = )











    }









    public ArrayList<Object> importDatabase(String databaseFile, AthletesAdmin athletesAdmin, OlympicGamesAdmin olympicGamesAdmin,
                                            TeamsAdmin teamsAdmin, SportsAdmin sportsAdmin){

        // TODO How to make this work poroper call by reference?

        ArrayList<Object> admins = new ArrayList<Object>();
        return admins;
    }

    public void serializeDataFromUser(List toSerialize, String fileName){
        // create and save as

    }
    public void deserializeDataFromUser(String filename){

    }

    public void newResult(int id, String team, String noc, String Game, int Year, String City, String sport, String medal){

    }
}
