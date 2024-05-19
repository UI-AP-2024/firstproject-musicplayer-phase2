package org.example.musicplayer_phase2.View.SidebarItems.Labels;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.Informations.PlayMusicPage;
import org.example.musicplayer_phase2.View.SidebarItems.SidebarMake;
import org.example.musicplayer_phase2.View.SidebarItems.Slider.PutSlider;
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;

import java.util.ArrayList;

import static org.example.musicplayer_phase2.controller.PlayingAudios.PlayMusic.*;

public class Home extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(making(), 600, 450);
        AboutStyleSheet.putStyleSheet(scene);
        stage.setTitle("HOME");
        stage.setScene(scene);
        stage.show();
    }

    private VBox making() {
        GridPane gridPane = new GridPane();
        if (UserAccountController.listener != null) {
            putSuggestedAudios(gridPane);
        } else {
            putFavoriteAudios(gridPane);
        }

        gridPane.setHgap(10);
        gridPane.setVgap(10);

        ScrollPane suggestedAudios = new ScrollPane(gridPane);
        suggestedAudios.setPrefSize(600, 350);

        VBox baseVBox = new VBox(suggestedAudios);

        SidebarMake sidebarMake = new SidebarMake();

        VBox vBox = new VBox();
        vBox.getChildren().add(baseVBox);

        vBox.getChildren().add(sidebarMake.getSidebar());
        vBox.setPadding(new Insets(20));
        return vBox;
    }

    private void putSuggestedAudios(GridPane gridPane) {
        int index = 0, sotonIndex = 0;

        ListenerController listenerController = new ListenerController();
        for (Audio a : listenerController.suggestMusic(100, UserAccountController.listener)) {
            Label nameLabel = new Label("name: " + a.getAudioName() + "\nidentifier: " + a.getIdentifier());

            nameLabel.setOnMouseClicked(e -> {
                try {
                    makeReadyToPlay(a , listenerController.suggestMusic(100, UserAccountController.listener) , e);
                } catch (Exception ex) {
                    Alerts.errorAlert();
                }
            });

            nameLabel.setPrefSize(180, 50);

            VBox vBoxForLabel = new VBox(nameLabel);

            gridPane.add(vBoxForLabel, sotonIndex, index);

            sotonIndex++;
            if (sotonIndex % 3 == 0 && sotonIndex != 0) {
                index++;
                sotonIndex = 0;
            }
        }
    }

    private void putFavoriteAudios (GridPane gridPane){
        ArrayList<Audio> favoriteAudios = new ListenerController().sortAudiosBasedOnLikes();
        int index = 0 , sotonIndex = 0;
        for (Audio a : favoriteAudios){

            Label label = new Label(a.getAudioName() +"\n" + a.getLikesNum() + " likes");
            label.setPrefSize(190 , 50);
            VBox vBox = new VBox(label);

            gridPane.add(vBox  , sotonIndex ,index);
            gridPane.setHgap(10);
            gridPane.setVgap(10);

            sotonIndex++;
            if (sotonIndex % 3 == 0 && sotonIndex != 0) {
                index++;
                sotonIndex = 0;
            }

            label.setOnMouseClicked(e -> {
                try {
                    makeReadyToPlay(a , favoriteAudios , e);
                } catch (Exception ex) {
                    Alerts.errorAlert();
                }
            });
        }
    }
}
