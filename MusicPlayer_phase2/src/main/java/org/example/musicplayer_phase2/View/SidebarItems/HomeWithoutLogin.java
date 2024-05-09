package org.example.musicplayer_phase2.View.SidebarItems;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.LoginView;
import org.example.musicplayer_phase2.View.Signingup.SignupView;
import org.example.musicplayer_phase2.View.Start;
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.controller.NecessaryMethods;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;
import org.example.musicplayer_phase2.model.GeneralOperations;

import java.util.ArrayList;

public class HomeWithoutLogin extends Application implements GeneralOperations {
    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(making() , 600 , 400);
        scene.getStylesheets().add(HelloApplication.class.getResource("myCss.css").toExternalForm());
        stage.setTitle("HOME");
        stage.setScene(scene );
        stage.show();
    }

    ArrayList<Audio> favoriteAudios = new ListenerController().sortAudiosBasedOnLikes();
    public VBox making (){
        GridPane gridPane = new GridPane();
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

        putButtons(vBox);

        return vBox;
    }

    public void putButtons (VBox vBox){

        Button loginButton = new Button("Login");
        Button logoutButton = new Button("Logout");

        Button signupButton = new Button("Signup");
        signupButton.setOnMouseClicked(e -> {

            Stage stage = NecessaryMethods.getStage(e);
            signup(stage);
        });

        Button bakeButton = new Button("back");
        bakeButton.setOnMouseClicked(e -> {
            NecessaryMethods.backToLastPage(e);
        });

        HBox buttonsHbox = new HBox(logoutButton , loginButton , signupButton , bakeButton);

        buttonsHbox.setSpacing(10);

        vBox.getChildren().add(buttonsHbox);

        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20));
    }




    @Override
    public void backTo(Stage stage) {

        try {
            start(stage);
        } catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    @Override
    public void logout(Stage stage) {
        //.................................
    }

    @Override
    public void login(Stage stage) {
        try {
            new LoginView().start(stage);
        } catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    @Override
    public void signup(Stage stage) {
        try {
            new SignupView().start(stage);
        } catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    @Override
    public void search(Stage stage) {
        //......................................
    }
}
