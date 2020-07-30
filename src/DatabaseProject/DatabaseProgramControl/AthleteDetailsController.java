package DatabaseProject.DatabaseProgramControl;



import DatabaseProject.DatabaseContent.Athlete;
import DatabaseProject.DatabaseContentAdmins.DataStore;
import javafx.fxml.FXML;

import javax.swing.text.html.ListView;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AthleteDetailsController extends Controller {
    @FXML Label id;
    @FXML Label athleteName;
    @FXML Label athleteAge;
    @FXML Label athleteHeight;
    @FXML Label athleteWeight;
    @FXML Label athleteGender;
    @FXML ListView goldMedals;
    @FXML ListView silverMedals;
    @FXML ListView bronzeMedals;
    @FXML ListView athleteTeams;

    private Athlete selectedAthlete;

    public void setSelectedAthlete(Athlete selectedAthlete) {
        this.selectedAthlete = selectedAthlete;
        selectedAthlete.getName();
        this.selectedAthlete.getName();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initDataStore(this.getDataStore());

    }
}

