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
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;

import java.util.ArrayList;

public class HomeWithoutLogin extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(making() , 600 , 450);
        scene.getStylesheets().add(HelloApplication.class.getResource("myCss.css").toExternalForm());
        stage.setTitle("HOME");
        stage.setScene(scene );
        stage.show();
    }

    ArrayList<Audio> favoriteAudios = new ListenerController().sortAudiosBasedOnLikes();
    public VBox making (){
        GridPane gridPane = new GridPane();
        gridPane.setPrefSize(600 , 350);
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
                //موزیکو پخش کننننننننننننننننن
            });
        }

        ScrollPane scrollPane = new ScrollPane(gridPane);
        VBox vBox = new VBox(scrollPane);

        vBox.setPadding(new Insets(20));
        SidebarMake sidebarMake = new SidebarMake();
        sidebarMake.makeActionsForLabelsAndButtons(sidebarMake);
        vBox.getChildren().add(sidebarMake.getSidebar());

        return vBox;
    }
}
