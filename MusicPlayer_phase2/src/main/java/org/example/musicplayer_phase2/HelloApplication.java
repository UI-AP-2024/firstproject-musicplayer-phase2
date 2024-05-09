package org.example.musicplayer_phase2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.model.AboutHumans.Admin;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static org.example.musicplayer_phase2.model.AboutHumans.Admin.getAdmin;


public class HelloApplication extends Application {

    public static Scene lastScene;
    public static String lastTitle;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 450);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("myCss.css").toExternalForm());
        stage.setTitle("welcome :)");
        stage.show();
    }

    public static final Admin admin = getAdmin("Fatemeh" , "fatemeh" , "1234!@#$" , "fatemefahimpoour1399@gmail.com" , "09131111111" , LocalDate.of(2005 , 12 ,12));

    public static void main(String[] args) throws IOException {
        launch();
    }
}