package DatabaseProject.DatabaseProgramControl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class AthleteDetailsController {
    @FXML
    public void switchSceneToMainMenu(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "DatabaseProject\\MainMenu.fxml");
    }

    @FXML
    public void switchSceneToAthleteSearch(ActionEvent actionEvent) throws Exception{
        switchScene(actionEvent, "DatabaseProject\\AthleteSearch.fxml");
    }



    public void switchScene(ActionEvent actionEvent, String nextPage) throws Exception{
        Parent athleteSearchView = FXMLLoader.load((Objects.requireNonNull(this.getClass().getClassLoader().getResource(nextPage))));
        Scene athleteSearchScene = new Scene(athleteSearchView);
        Stage athleteSearchStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        athleteSearchStage.setScene(athleteSearchScene);
        athleteSearchStage.show();

    }


}

