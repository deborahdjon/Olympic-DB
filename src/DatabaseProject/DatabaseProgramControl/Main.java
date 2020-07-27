/*
 * Olympic DB

 * This programme was written for a universety project for the informatics Module
 * Programming2 at the DHBW Stuttgart.
 * @author 9537809
 * @version 1.0

 */
package DatabaseProject.DatabaseProgramControl;

import DatabaseProject.DatabaseContent.*;
import DatabaseProject.DatabaseContentAdmins.Admin;
import DatabaseProject.DatabaseControl.Reader;

//public class Main extends Application{
//
//    @Override
//    public void start(Stage stage) throws Exception {
//    }
//}
public class Main{
    /**
    *Starts the Programme
    * @param args
     * System Arguments
    * */
    public static void main(String[] args) {
        Reader initialReader = new Reader("Resources\\DatabaseProject\\test.db");
        Admin<Athlete> athleteAdmin = new Admin<>();
        Admin<Team> teamAdmin = new Admin<>();
        Admin<Sport> sportAdmin = new Admin<>();
        Admin<OlympicGame> olympicGameAdmin= new Admin<>();

        athleteAdmin.setStorage(initialReader.getAthleteInit());
        teamAdmin.setStorage(initialReader.getTeamsAdminStoreInit());
        sportAdmin.setStorage(initialReader.getSportsAdminStoreInit());
        olympicGameAdmin.setStorage(initialReader.getOlympicGamesAdminStoreInit());
        initialReader = null;


    }
}
