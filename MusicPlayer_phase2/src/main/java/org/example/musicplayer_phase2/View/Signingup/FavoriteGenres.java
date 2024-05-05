package org.example.musicplayer_phase2.View.Signingup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.model.AboutHumans.Listener;

public class FavoriteGenres extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("favoriteGenres.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //        scene.getStylesheets().add(getClass().getResource("myCss.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("favorite genre page");
        stage.show();
    }

    Listener listener;
    public FavoriteGenres(Listener listener) {
        this.listener = listener;
    }

    public FavoriteGenres() {
    }
}
