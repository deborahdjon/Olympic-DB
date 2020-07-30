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
import javafx.stage.Stage;

import java.util.Objects;

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
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(this.getClass().getClassLoader().getResource("DatabaseProject\\AthleteSearch.fxml"));
        Parent nextView = loader.load();
        Scene nextScene = new Scene(nextView);

        AthleteSearchController athleteSearchController = loader.getController();
        athleteSearchController.initDataStore(this.dataStore);
        athleteSearchController.setAthleteAdmin(getDataStore().getAthleteAdmin());

        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    /** Function for navigating to the SportSearch page.
     * @param actionEvent button click.*/
    @FXML
    public void switchSceneToSportSearch(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(this.getClass().getClassLoader().getResource("DatabaseProject\\SportSearch.fxml"));
        Parent nextView = loader.load();
        Scene nextScene = new Scene(nextView);

        SportSearchController sportSearchController = loader.getController();
        sportSearchController.initDataStore(this.dataStore);

        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    /** Function for navigating to the EventSearch page.
     * @param actionEvent button click.*/
    @FXML
    public void switchSceneToEventSearch(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(this.getClass().getClassLoader().getResource("DatabaseProject\\EventSearch.fxml"));
        Parent nextView = loader.load();
        Scene nextScene = new Scene(nextView);

        EventSearchController eventSearchController = loader.getController();
        eventSearchController.initDataStore(this.dataStore);

        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    /** Function for navigating to the AthleteDetails page.
     * @param actionEvent button click.*/
    @FXML
    public void switchSceneToOlympicGameSearch(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(this.getClass().getClassLoader().getResource("DatabaseProject\\OlympicGameSearch.fxml"));
        Parent nextView = loader.load();
        Scene nextScene = new Scene(nextView);

        OlympicGameSearchController olympicGameSearchController = loader.getController();
        olympicGameSearchController.initDataStore(this.dataStore);

        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    /** Function for navigating to the TeamSearch page.
     * @param actionEvent button click.*/
    @FXML
    protected void switchSceneToTeamSearch(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(this.getClass().getClassLoader().getResource("DatabaseProject\\TeamSearch.fxml"));
        Parent nextView = loader.load();
        Scene nextScene = new Scene(nextView);

        TeamSearchController teamSearchController = loader.getController();
        teamSearchController.initDataStore(this.dataStore);

        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }


    /** Function for navigating to the NewEntry page.
     * @param actionEvent button click.*/
    @FXML
    public void switchSceneToNewEntry(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(this.getClass().getClassLoader().getResource("DatabaseProject\\NewEntry.fxml"));
        Parent nextView = loader.load();
        Scene nextScene = new Scene(nextView);

        NewEntryController newEntryController = loader.getController();
        newEntryController.initDataStore(this.dataStore);

        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    /** Function for navigating to the NewAthlete page.
     * @param actionEvent button click.*/
    @FXML
    public void switchSceneToNewAthlete(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(this.getClass().getClassLoader().getResource("DatabaseProject\\NewAthlete.fxml"));
        Parent nextView = loader.load();
        Scene nextScene = new Scene(nextView);

        NewAthleteController newAthleteController = loader.getController();
        newAthleteController.initDataStore(this.dataStore);

        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    /** Function for navigating to the MainMenu page.
     * @param actionEvent button click.*/
    @FXML
    protected void switchSceneToMainMenu(ActionEvent actionEvent) throws Exception{
        Parent athleteSearchView = FXMLLoader.load((Objects.requireNonNull(this.getClass().getClassLoader().getResource("DatabaseProject\\MainMenu.fxml"))));
        Scene athleteSearchScene = new Scene(athleteSearchView);
        Stage athleteSearchStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        athleteSearchStage.setScene(athleteSearchScene);
        athleteSearchStage.show();
    }



}
