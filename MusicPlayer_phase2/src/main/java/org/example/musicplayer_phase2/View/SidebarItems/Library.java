package org.example.musicplayer_phase2.View.SidebarItems;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.controller.UserAccountController;

public class Library extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        if (UserAccountController.listener == null){
           alert();
        }
        else {
//            Scene scene = new Scene();
        }
    }

    public void alert (){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("invalid person");
        alert.setContentText("for this part you have to login or signup");
        alert.showAndWait();
    }
}
