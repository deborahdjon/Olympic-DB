package DatabaseProject.DatabaseContentAdmins;

import DatabaseProject.DatabaseContent.Athlete;
import DatabaseProject.DatabaseContent.OlympicGame;
import DatabaseProject.DatabaseContent.Sport;
import DatabaseProject.DatabaseContent.Team;
import DatabaseProject.DatabaseControl.Reader;

/**Starts all the Admins*/
public class AdminAdmin {
    public AdminAdmin(){
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
