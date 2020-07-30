/** Olympic DB

 * This programme was written for a universety project for the informatics Module
 * Programming2 at the DHBW Stuttgart.
 * @author 9537809
 * @version 1.0
 */
package DatabaseProject.DatabaseProgramControl;


import DatabaseProject.DatabaseContent.Athlete;
import DatabaseProject.DatabaseContentAdmins.DataStore;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

/**
 *Starts the Programme
 * */
public class Main extends Application {
    private DataStore dataStore ;

    public void start(Stage primaryStage) throws Exception {
        //FXMLLoader loader = new FXMLLoader(new File("C:\\Users\\debor\\IdeaProjects\\9537809\\Resources\\DatabaseProject\\MainMenu.fxml").toURI().toURL());
        //Parent root = loader.load();
        // Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("DatabaseProject\\MainMenu.fxml"));

        this.dataStore =  new DataStore("Resources\\DatabaseProject\\test.db");
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(this.getClass().getClassLoader().getResource("DatabaseProject\\MainMenu.fxml"));
        Parent root = loader.load();

        MainMenuController mainMenuController = loader.getController();
        mainMenuController.initDataStore(this.dataStore);


        primaryStage.setTitle("Olympic Games Database");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    public static void main(String[] args){
        launch(args);
    }



}