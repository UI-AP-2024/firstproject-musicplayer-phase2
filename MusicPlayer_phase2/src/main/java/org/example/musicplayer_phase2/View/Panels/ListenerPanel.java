package org.example.musicplayer_phase2.View.Panels;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.SidebarItems.SidebarMake;
import org.example.musicplayer_phase2.model.AboutHumans.Listener;

import java.net.URL;
import java.util.ResourceBundle;

public class ListenerPanel extends Application implements Initializable{

    Listener listener ;
    Label nameLabel ;
    public ListenerPanel(Listener listener) {
        this.listener = listener;
        nameLabel = new Label(listener.getName());
    }

    public ListenerPanel() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("listenerPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        scene.getStylesheets().add(HelloApplication.class.getResource("myCss.css").toExternalForm());
        stage.setTitle("listener panel");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private AnchorPane basedAnchorpane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SidebarMake sidebarMake = new SidebarMake();

        HBox hBox = sidebarMake.getSidebar();

        basedAnchorpane.getChildren().add(hBox);
        try{
        basedAnchorpane.getChildren().add(nameLabel);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
