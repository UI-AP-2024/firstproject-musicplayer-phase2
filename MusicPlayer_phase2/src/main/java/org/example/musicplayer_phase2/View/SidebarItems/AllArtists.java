package org.example.musicplayer_phase2.View.SidebarItems;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.Informations.ShowArtistsInformation;
import org.example.musicplayer_phase2.controller.AboutArtist.ArtistController;
import org.example.musicplayer_phase2.controller.NecessaryMethods;
import org.example.musicplayer_phase2.model.AboutHumans.Artist;

public class AllArtists extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(making() , 600 , 450);
        NecessaryMethods.putStyleSheet(scene);
        stage.setTitle("ARTISTS");
        stage.setScene(scene );
        stage.show();
    }

    private VBox making(){
        GridPane gridPane = new GridPane();
        putArtists(gridPane);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        ScrollPane artistsScrollPane = new ScrollPane(gridPane);
        artistsScrollPane.setPrefSize(600 , 350);

        VBox baseVBox = new VBox(artistsScrollPane);

        SidebarMake sidebarMake = new SidebarMake();
        sidebarMake.makeActionsForLabelsAndButtons(sidebarMake);

        VBox vBox = new VBox();
        vBox.getChildren().add(baseVBox);
        vBox.getChildren().add(sidebarMake.getSidebar());
        vBox.setPadding(new Insets(20));
        return vBox;
    }

    private void putArtists (GridPane gridPane){
        int index = 0 , sotonIndex = 0;
        for (Artist a : ArtistController.sortArtistsBasedOnFollowers()){
            Label nameLabel = new Label("name: " + a.getName() + "\n" +"username: " + a.getUsername() + "\nfollowers: " + a.getFollowers());
            nameLabel.setOnMouseClicked(e -> {
                try {
                    NecessaryMethods.saveLastScene(e);
                    ShowArtistsInformation.setArtist(a);
                    new ShowArtistsInformation().start(NecessaryMethods.getStage(e));
                } catch (Exception ex) {
                    Alerts.errorAlert();
                }
            });


            nameLabel.setPrefSize(180 , 50);

            VBox vBoxForLabel = new VBox(nameLabel );

            gridPane.add(vBoxForLabel , sotonIndex , index);

            sotonIndex++;
            if (sotonIndex % 3 == 0 && sotonIndex != 0) {
                index++;
                sotonIndex = 0;
            }
        }
    }
}