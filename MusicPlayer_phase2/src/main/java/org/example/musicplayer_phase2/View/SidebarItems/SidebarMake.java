package org.example.musicplayer_phase2.View.SidebarItems;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.controller.NecessaryMethods;

import java.io.IOException;


public class SidebarMake {
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

    public void makeActionsForLabels(SidebarMake sidebarMake){
        homeActions(sidebarMake);
        artistsActions(sidebarMake);
        audiosAction(sidebarMake);
        libraryAction(sidebarMake);
        searchAction(sidebarMake);
    }

    public void homeActions (SidebarMake sidebarMake){
        homeLabel.setOnMouseEntered(e -> {
            homeLabel.setTextFill(Color.BLUE);
        });
        homeLabel.setOnMouseExited(e -> {
            homeLabel.setTextFill(Color.WHITE);
        });
    }

    public void artistsActions (SidebarMake sidebarMake){
        sidebarMake.artistsLabel.setOnMouseClicked(e -> {
            try {
                NecessaryMethods.saveLastScene(e);
                //پر بشه......................................................
            } catch (Exception ex) {
                Alerts.errorAlert();
            }
        });

        artistsLabel.setOnMouseEntered(e -> {
            artistsLabel.setTextFill(Color.BLUE);
        });
        artistsLabel.setOnMouseExited(e -> {
            artistsLabel.setTextFill(Color.WHITE);
        });
    }

    public void audiosAction (SidebarMake sidebarMake){
        sidebarMake.audiossLabel.setOnMouseClicked(e -> {
            try {
                NecessaryMethods.saveLastScene(e);
                //پر بشه......................................................
            } catch (Exception ex) {
                Alerts.errorAlert();
            }
        });

        audiossLabel.setOnMouseEntered(e -> {
            audiossLabel.setTextFill(Color.BLUE);
        });
        audiossLabel.setOnMouseExited(e -> {
            audiossLabel.setTextFill(Color.WHITE);
        });
    }

    public void libraryAction (SidebarMake sidebarMake){
        sidebarMake.libraryLabel.setOnMouseClicked(e -> {
            try {
                NecessaryMethods.saveLastScene(e);
                //پر بشه......................................................
            } catch (Exception ex) {
                Alerts.errorAlert();
            }
        });

        libraryLabel.setOnMouseEntered(e -> {
            libraryLabel.setTextFill(Color.BLUE);
        });
        libraryLabel.setOnMouseExited(e -> {
            libraryLabel.setTextFill(Color.WHITE);
        });
    }

    public void searchAction (SidebarMake sidebarMake){
        sidebarMake.searchLabel.setOnMouseClicked(e -> {
            try {
                NecessaryMethods.saveLastScene(e);
                //پر بشه......................................................
            } catch (Exception ex) {
                Alerts.errorAlert();
            }
        });

        searchLabel.setOnMouseEntered(e -> {
            searchLabel.setTextFill(Color.BLUE);
        });
        searchLabel.setOnMouseExited(e -> {
            searchLabel.setTextFill(Color.WHITE);
        });
    }
}
