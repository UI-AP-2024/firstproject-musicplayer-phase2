package org.example.musicplayer_phase2.View;

import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;

public class Alerts {

    public static void errorAlert (){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText("page not loaded");
        alert.showAndWait();
    }

//    public static void goodDayAlert (){
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("");
//        alert.setContentText("have a good day");
////        alert.showAndWait();
//    }
}
