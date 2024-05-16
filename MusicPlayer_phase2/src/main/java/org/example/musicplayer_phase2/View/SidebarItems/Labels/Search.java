package org.example.musicplayer_phase2.View.SidebarItems.Labels;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.musicplayer_phase2.View.SidebarItems.SidebarMake;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.AboutHumans.Artist;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Search extends Application implements Initializable {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("search.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 450);
        AboutStyleSheet.putStyleSheet(scene);
        stage.setTitle("SEARCHING");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private VBox sidebarVBox;

    @FXML
    private Button searchButton;

    @FXML
    private TextField serchTextField;

    @FXML
    private ScrollPane resultScrollPane;

    private GridPane resultGridPane = new GridPane();

    @FXML
    void searchClicked(MouseEvent event) {
        ArrayList<Audio> audioResult = new ArrayList<>();
        ArrayList<Artist> artistResult = new ArrayList<>();

        if (serchTextField != null) {
            audioResult = UserAccountController.searchInAudios(serchTextField.getText());
            artistResult = UserAccountController.searchInArtists(serchTextField.getText());

            int index = 0;

            for (Audio a : audioResult){
                Label audioLabel = new Label("audio name: "+ a.getAudioName() + "\nlikes: " + a.getLikesNum());
                audioLabel.setPrefSize(440 , 80);
                resultGridPane.add(audioLabel ,0 , index );
                index++;
            }

            for (Artist a : artistResult){
                Label audioLabel = new Label("artist name: "+ a.getUsername() + "\n" + a.getBiography());
                audioLabel.setPrefSize(440 , 80);
                resultGridPane.add(audioLabel ,0 , index );
                index++;
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SidebarMake sidebarMake = new SidebarMake();
        sidebarVBox.getChildren().add(sidebarMake.getSidebar());

        resultScrollPane.setContent(resultGridPane);
    }
}
