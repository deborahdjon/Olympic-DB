package DatabaseProject.DatabaseProgramControl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class SceneSwitcher {

    @FXML
    public void switchSceneToAthleteSearch(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "DatabaseProject\\AthleteSearch.fxml");
    }

    @FXML
    public void switchSceneToSportSearch(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "DatabaseProject\\SportSearch.fxml");
    }

    @FXML
    public void switchSceneToEventSearch(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "DatabaseProject\\EventSearch.fxml");
    }

    @FXML
    public void switchSceneToOlympicGameSearch(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "DatabaseProject\\OlympicGameSearch.fxml");
    }
    @FXML
    public void switchSceneToNewEntry(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "DatabaseProject\\NewEntry.fxml");

    }
    @FXML
    public void switchSceneToNewAthlete(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "DatabaseProject\\NewAthlete.fxml");
    }


    @FXML
    protected void switchSceneToMainMenu(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "DatabaseProject\\MainMenu.fxml");
    }

    protected void switchScene(ActionEvent actionEvent, String nextPage) throws Exception{
        Parent athleteSearchView = FXMLLoader.load((Objects.requireNonNull(this.getClass().getClassLoader().getResource(nextPage))));
        Scene athleteSearchScene = new Scene(athleteSearchView);
        Stage athleteSearchStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        athleteSearchStage.setScene(athleteSearchScene);
        athleteSearchStage.show();

    }
}
