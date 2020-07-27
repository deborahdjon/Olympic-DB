/*
 * Olympic DB

 * This programme was written for a universety project for the informatics Module
 * Programming2 at the DHBW Stuttgart.
 * @author 9537809
 * @version 1.0

 */
package DatabaseProject.DatabaseProgramControl;

import DatabaseProject.DatabaseContent.*;
import DatabaseProject.DatabaseContentAdmins.Admin;
import DatabaseProject.DatabaseContentAdmins.AdminAdmin;
import DatabaseProject.DatabaseControl.Reader;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *Starts the Programme
 * */
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        AdminAdmin adminAdmin = new AdminAdmin();
        Parent root =  FXMLLoader.load(this.getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Olympic Games Database");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }
    public static void main(String[] args){
        launch(args);
    }

}