package org.example.musicplayer_phase2.View.Panels;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Sidebar;
import org.example.musicplayer_phase2.model.AboutHumans.Listener;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListenerPanel extends Application implements Initializable{

    public ListenerPanel() {

    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("listenerPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

//        putSidebar();

        scene.getStylesheets().add(HelloApplication.class.getResource("myCss.css").toExternalForm());
        stage.setTitle("listener panel");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private AnchorPane basedAnchorpane;
    private void putSidebar (){
        Sidebar sidebar = new Sidebar();
        try {
            basedAnchorpane.getChildren().add(sidebar.getSidebar());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        putSidebar();
        basedAnchorpane.getChildren().add(new Button());
    }
}
