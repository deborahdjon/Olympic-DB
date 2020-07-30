package DatabaseProject.DatabaseProgramControl;

import DatabaseProject.DatabaseContent.Athlete;
import DatabaseProject.DatabaseContent.DatabaseContent;
import DatabaseProject.DatabaseContentAdmins.Admin;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class AthleteSearchController extends Controller{


    @FXML private TableView <Athlete> tableViewAthlete;
    @FXML private TableColumn<Athlete, String> columnAthleteName;
    @FXML private TextField textFieldAthleteSearch;
    private Admin<Athlete> athleteAdmin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnAthleteName.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    public void setAthleteAdmin(Admin<Athlete> athleteAdmin){
        this.athleteAdmin = athleteAdmin;
    }

    /**Function for finding and displaying athletes in the view.*/
    public void searchAthlete(){
        String searchString = textFieldAthleteSearch.getText();
        ObservableList results = athleteAdmin.searchByName(searchString,  athleteAdmin.getStorage());
        tableViewAthlete.setItems(results);
    }

    /** Function for navigating to the AthleteDetails page.
     * @param actionEvent button click.*/
    @FXML
    public void switchSceneToAthleteDetails(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(this.getClass().getClassLoader().getResource("DatabaseProject\\AthleteDetails.fxml"));
        Parent nextView = loader.load();
        Scene nextScene = new Scene(nextView);

        AthleteDetailsController athleteDetailsController = loader.getController();
        athleteDetailsController.initDataStore(this.getDataStore());
        Athlete selectedAthlete = tableViewAthlete.getSelectionModel().getSelectedItem();

        athleteDetailsController.id.setText(selectedAthlete.getId().toString());
        athleteDetailsController.athleteName.setText(selectedAthlete.getName());
        athleteDetailsController.athleteAge.setText(selectedAthlete.getAge().toString());
        athleteDetailsController.athleteHeight.setText(selectedAthlete.getHeight().toString());
        athleteDetailsController.athleteWeight.setText(selectedAthlete.getWeight().toString());
        athleteDetailsController.athleteGender.setText(selectedAthlete.getGender());

        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }


}

