package org.example.musicplayer_phase2.View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;

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
        Scene scene = new Scene(fxmlLoader.load() , 600 , 400);

//        scene.getStylesheets().add(getClass().getResource("myCss.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("signup page");
        stage.show();
    }

    //..............................back
    @FXML
    private Button backButton;

    @FXML
    void backButtonClicked(MouseEvent event) {
        Start.backToStartPage();
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
        if (userType != null){
            anchorPane.getChildren().remove(vbox_register);

            if (userType.equals("listener")){

            }

            else if (userType.equals("singer")){

            }

            else if (userType.equals("podcaster")){

            }

        }
    }
//...............................................
}
