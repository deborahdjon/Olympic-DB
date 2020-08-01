package DatabaseProject.DatabaseProgramControl;



import DatabaseProject.DatabaseContent.Athlete;
import DatabaseProject.DatabaseContentAdmins.DataStore;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class AthleteDetailsController extends Controller {
    @FXML private Label id;
    @FXML private Label athleteName;
    @FXML private Label athleteAge;
    @FXML private Label athleteHeight;
    @FXML private Label athleteWeight;
    @FXML private Label athleteGender;
    @FXML private ListView<String> goldMedals;
    @FXML private ListView<String>  silverMedals;
    @FXML private ListView<String>  bronzeMedals;
    @FXML private ListView<String>  athleteTeams;

    private Athlete selectedAthlete;

    public void setSelectedAthlete(Athlete selectedAthlete) {
        this.selectedAthlete = selectedAthlete;
        selectedAthlete.getName();
        this.selectedAthlete.getName();

    }

    public void initData(){
        this.id.setText(selectedAthlete.getId().toString());
        this.athleteName.setText(selectedAthlete.getName());
        this.athleteAge.setText(selectedAthlete.getAge().toString());
        this.athleteHeight.setText(selectedAthlete.getHeight().toString());
        this.athleteWeight.setText(selectedAthlete.getWeight().toString());
        this.athleteGender.setText(selectedAthlete.getGender());
        this.goldMedals.setItems(selectedAthlete.getMedals().getGoldMedalsList());
        this.silverMedals.setItems(selectedAthlete.getMedals().getSilverMedalsList());
        this.bronzeMedals.setItems(selectedAthlete.getMedals().getBronzeMedalsList());
        this.athleteTeams.setItems(selectedAthlete.getTeamsNamesList());
    }


}

