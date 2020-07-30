package DatabaseProject.DatabaseContentAdmins;

import DatabaseProject.DatabaseContent.Athlete;
import DatabaseProject.DatabaseContent.OlympicGame;
import DatabaseProject.DatabaseContent.Sport;
import DatabaseProject.DatabaseContent.Team;
import DatabaseProject.DatabaseControl.Reader;

import java.util.ArrayList;

/**Starts and stores all the Admins*/
public class DataStore {
    Admin<Athlete> athleteAdmin;
    Admin<Team> teamAdmin;
    Admin<Sport> sportAdmin;
    Admin<OlympicGame> olympicGameAdmin;

    public DataStore(String filename){
        Reader initialReader = new Reader(filename);

        athleteAdmin = new Admin<>();
        teamAdmin = new Admin<>();
        sportAdmin = new Admin<>();
        olympicGameAdmin = new Admin<>();

        athleteAdmin.setStorage(initialReader.getAthleteInit());
        teamAdmin.setStorage(initialReader.getTeamsAdminStoreInit());
        sportAdmin.setStorage(initialReader.getSportsAdminStoreInit());
        olympicGameAdmin.setStorage(initialReader.getOlympicGamesAdminStoreInit());
    }

    public Admin<Athlete> getAthleteAdmin() {
        return athleteAdmin;
    }
    public Admin<OlympicGame> getOlympicGameAdmin() {
        return olympicGameAdmin;
    }
    public Admin<Sport> getSportAdmin() {
        return sportAdmin;
    }
    public Admin<Team> getTeamAdmin() {
        return teamAdmin;
    }
}
