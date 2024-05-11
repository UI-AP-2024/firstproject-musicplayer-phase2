package org.example.musicplayer_phase2.View.SidebarItems;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class Search extends Application implements Initializable {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("search.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(HelloApplication.class.getResource("myCss.css").toExternalForm());
        stage.setTitle("SEARCHING");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private AnchorPane baseAnchorPane;

    @FXML
    private Button searchButton;

    @FXML
    private TextField serchTextField;

    @FXML
    void searchClicked(MouseEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SidebarMake sidebarMake = new SidebarMake();
        sidebarMake.makeActionsForLabelsAndButtons(sidebarMake);
        baseAnchorPane.getChildren().add(sidebarMake.getSidebar());
    }
}
