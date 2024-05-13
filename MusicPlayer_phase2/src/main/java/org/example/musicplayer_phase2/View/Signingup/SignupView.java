package org.example.musicplayer_phase2.View.Signingup;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.Signingup.ListenerSignup;
import org.example.musicplayer_phase2.View.Signingup.podcasterSingerSignup;
import org.example.musicplayer_phase2.View.Start;
import org.example.musicplayer_phase2.controller.NecessaryMethods;

public class SignupView extends Application {
    private String userType = null;
    @FXML
    private VBox vbox_register;
    @FXML
    private SplitMenuButton userTypeMenu;
    @FXML
    private AnchorPane anchorPane;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 450);
        NecessaryMethods.putStyleSheet(scene);
        stage.setScene(scene);
        stage.setTitle("signup page");
        stage.show();
    }

    //..............................back
    @FXML
    private Button backButton;

    @FXML
    void backButtonClicked(MouseEvent event) {
        NecessaryMethods.backToLastPage(event);
    }
//....................................
    @FXML
    private MenuItem listenerItem;
    @FXML
    void listenerItemAction(ActionEvent event) {
        userTypeMenu.setText("Listener");
        userType = "listener";
    }
//.....................................

    @FXML
    private MenuItem podcasterItem;
    @FXML
    void podcasterItemAction(ActionEvent event) {
        userTypeMenu.setText("Podcaster");
        userType = "podcaster";
    }
//......................................

    @FXML
    private MenuItem singerItem;
    @FXML
    void singerItemAction(ActionEvent event) {
        userTypeMenu.setText("Singer");
        userType = "singer";
    }

//..........................................
    @FXML
    private Button registerButton;
    @FXML
    void registerButtonClicked(MouseEvent event) {
       Stage stage = NecessaryMethods.getStage(event);

        if (userType != null){

            if (userType.equals("listener")){
                ListenerSignup listenerSignup = new ListenerSignup();
                try {
                    NecessaryMethods.saveLastScene(event);
                    listenerSignup.start(stage);
                }catch (Exception e){
                    Alerts.errorAlert();
                }
            }

            else if (userType.equals("singer") || userType.equals("podcaster")){
                podcasterSingerSignup podcasterSingerSignup;

                if (userType.equals("singer"))
                    podcasterSingerSignup = new podcasterSingerSignup("singer");
                else
                    podcasterSingerSignup = new podcasterSingerSignup("podcaster");

                try {
                    NecessaryMethods.saveLastScene(event);
                    podcasterSingerSignup.start(stage);
                }catch (Exception e){
                    Alerts.errorAlert();
                }
            }
        }
    }
//...............................................
}
