package org.example.musicplayer_phase2.View.SidebarItems;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.controller.NecessaryMethods;

import java.io.IOException;


public class SidebarMake extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        homeLabel.setOnMouseClicked(e -> {
            try {
                NecessaryMethods.saveLastScene(e);
                new Home().start(stage);
            } catch (Exception ex) {
                Alerts.errorAlert();
            }
        });

        homeLabel.setOnMouseEntered(e -> {
            homeLabel.setTextFill(Color.BLUE);
        });
    }
    Label homeLabel = new Label("HOME");
    Label artistsLabel = new Label("ARTISTS");
    Label audiossLabel = new Label("AUDIOS");
    Label searchLabel = new Label("SEARCH");
    Label libraryLabel = new Label("LIBRARY");
    HBox hbox = new HBox();

    public HBox getSidebar(){
        hbox.setPrefSize(600 , 50);
        homeLabel.setPrefSize(120 , 50);
        artistsLabel.setPrefSize(120 , 50);
        audiossLabel.setPrefSize(120 , 50);
        searchLabel.setPrefSize(120 , 50);
        libraryLabel.setPrefSize(120 , 50);
        hbox.getChildren().addAll(artistsLabel , audiossLabel , homeLabel , libraryLabel , searchLabel );
        return hbox;
    }
}
