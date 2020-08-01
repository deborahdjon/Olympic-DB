package DatabaseProject.DatabaseProgramControl;

import DatabaseProject.DatabaseContent.OlympicGame;
import DatabaseProject.DatabaseContentAdmins.DataStore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public abstract class Controller  implements Initializable {

    private DataStore dataStore;

    public DataStore getDataStore() {
        return dataStore;
    }

    public void initDataStore(DataStore dataStore){
        this.dataStore = dataStore;
    }

    /** Function for navigating to the AthleteSearch page.
     * @param actionEvent button click.*/
    @FXML
    public void switchSceneToAthleteSearch(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "AthleteSearch.fxml");
    }

    /** Function for navigating to the SportSearch page.
     * @param actionEvent button click.*/
    @FXML
    public void switchSceneToSportSearch(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "SportSearch.fxml");
    }

    /** Function for navigating to the EventSearch page.
     * @param actionEvent button click.*/
    @FXML
    public void switchSceneToEventSearch(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "EventSearch.fxml");
    }

    /** Function for navigating to the AthleteDetails page.
     * @param actionEvent button click.*/
    @FXML
    public void switchSceneToOlympicGameSearch(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent,"OlympicGameSearch.fxml");
    }

    /** Function for navigating to the TeamSearch page.
     * @param actionEvent button click.*/
    @FXML
    protected void switchSceneToTeamSearch(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "TeamSearch.fxml");
    }


    /** Function for navigating to the NewEntry page.
     * @param actionEvent button click.*/
    @FXML
    public void switchSceneToNewEntry(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "NewEntry.fxml");
    }

    /** Function for navigating to the NewAthlete page.
     * @param actionEvent button click.*/
    @FXML
    public void switchSceneToNewAthlete(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "NewAthlete.fxml" );
    }

    /** Function for navigating to the MainMenu page.
     * @param actionEvent button click.*/
    @FXML
    protected void switchSceneToMainMenu(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "MainMenu.fxml" );
    }

    protected void switchScene(ActionEvent actionEvent, String sceneFXML) throws IOException {
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(this.getClass().getClassLoader().getResource("DatabaseProject\\"+sceneFXML));
        Parent nextView = loader.load();
        Scene nextScene = new Scene(nextView);

        switch (sceneFXML){
            case "AthleteSearch.fxml":
                AthleteSearchController athleteSearchController = loader.getController();
                athleteSearchController.initDataStore(this.dataStore);
                athleteSearchController.setAthleteAdmin(getDataStore().getAthleteAdmin());
                break;

            case "SportSearch.fxml":
                SportSearchController sportSearchController = loader.getController();
                sportSearchController.initDataStore(this.dataStore);
                break;

            case "EventSearch.fxml":
                EventSearchController eventSearchController = loader.getController();
                eventSearchController.initDataStore(this.dataStore);
                break;

            case "OlympicGameSearch.fxml":
                OlympicGameSearchController olympicGameSearchController = loader.getController();
                olympicGameSearchController.initDataStore(this.dataStore);
                break;

            case "TeamSearch.fxml":
                TeamSearchController teamSearchController = loader.getController();
                teamSearchController.initDataStore(this.dataStore);
                break;

            case "NewEntry.fxml":
                NewEntryController newEntryController = loader.getController();
                newEntryController.initDataStore(this.dataStore);
                break;

            case "NewAthlete.fxml":
                NewAthleteController newAthleteController = loader.getController();
                newAthleteController.initDataStore(this.dataStore);
                break;

            case "MainMenu.fxml":
                MainMenuController mainMenuController = loader.getController();
                mainMenuController.initDataStore(this.dataStore);
                break;
        }


        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    protected static void warnEmptyField(){
        Alert enterData = new Alert(Alert.AlertType.WARNING);
        enterData.setTitle("Warning");
        enterData.setContentText("Please enter a name");
        enterData.show();
    }




}
