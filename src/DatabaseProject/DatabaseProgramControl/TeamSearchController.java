package DatabaseProject.DatabaseProgramControl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TeamSearchController extends Controller{

    /** Function for navigating to the TeamDetails page.
     * @param actionEvent button click.*/
    @FXML
    public void switchSceneToTeamDetails(ActionEvent actionEvent) throws Exception{
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(this.getClass().getClassLoader().getResource("DatabaseProject\\TeamDetails.fxml"));
        Parent nextView = loader.load();
        Scene nextScene = new Scene(nextView);

        TeamDetailsController teamDetailsController = loader.getController();
        teamDetailsController.initDataStore(this.getDataStore());

        Stage nextStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        nextStage.setScene(nextScene);
        nextStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

