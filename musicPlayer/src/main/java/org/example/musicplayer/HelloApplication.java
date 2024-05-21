package org.example.musicplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import org.example.musicplayer.model.UserAccount.UserAccountModel;
import java.io.IOException;


public class HelloApplication extends Application {
    public static Media currentMusic;
    public static UserAccountModel currentUser;
    public static boolean loggedIn = false;
    public static Stage currentstage;
   public static BorderPane mianPane = new BorderPane();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("base-page-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        currentstage = stage;
        currentstage.setTitle("mohsenify");
        currentstage.setScene(scene);
        currentstage.show();
    }
    public static void main(String[] args) {
        String path1 = "https://dl.violinmusics.ir/Music/Instrumental/2021/08.%20Nino%20Rota%20-%20Romeo%20and%20Juliet.mp3";
        Media music1 = new Media(path1);
        currentMusic = music1;
        launch();
    }
}