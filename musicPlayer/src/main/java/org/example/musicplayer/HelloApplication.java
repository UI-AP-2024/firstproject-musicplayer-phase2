package org.example.musicplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
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
        launch();
    }
}