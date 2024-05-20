package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.phase2.Controller.ListenerController;
import org.example.phase2.Exceptions.FreeAccountLimitException;
import org.example.phase2.Model.Database.Database;

import java.io.IOException;

public class AddToPlaylistController {

    @FXML
    private Button add_btn;

    @FXML
    private Button back_btn;

    @FXML
    private AnchorPane initialAnchor;

    @FXML
    private Label playlist_lbl;

    @FXML
    private TextField textField;

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        AddToPlaylistController.stage = stage;
    }

    @FXML
    void addAction(ActionEvent event) {
        String playlist=textField.getText();
        long id=MusicPageController.getAudio().getId();
        int checkAdd=0;
        if(ListenerController.getListenerController().getListener()!=null){
            try {
                checkAdd=ListenerController.getListenerController().addMusicToPlaylist(playlist,String.valueOf(id));
            } catch (FreeAccountLimitException e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMATION");
                alert.setHeaderText(null);
                alert.setContentText("You can't add more than 10 music to your playlist.");
                alert.showAndWait();
            }
            if(checkAdd==1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMATION");
                alert.setHeaderText(null);
                alert.setContentText("Music added to your playlist successfully");
                alert.showAndWait();
            }
            if(checkAdd==-1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMATION");
                alert.setHeaderText(null);
                alert.setContentText("There was a problem. Please try again.");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION");
            alert.setHeaderText(null);
            alert.setContentText("You should first login.");
            alert.showAndWait();
        }
    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader= Database.getDatabase().getScenes().pop();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle(Database.getDatabase().getTitles().pop());
        stage.setScene(scene);
        stage.show();
    }

}
