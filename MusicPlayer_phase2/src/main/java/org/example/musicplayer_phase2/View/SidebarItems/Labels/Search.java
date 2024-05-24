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
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.Informations.PlayMusicPage;
import org.example.musicplayer_phase2.View.Informations.ShowArtistsInformation;
import org.example.musicplayer_phase2.View.SidebarItems.SidebarMake;
import org.example.musicplayer_phase2.View.SidebarItems.Slider.PutSlider;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.AboutHumans.Artist;
import org.example.musicplayer_phase2.model.AboutMusic.Audio;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static org.example.musicplayer_phase2.controller.PlayingAudios.PlayMusic.*;


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
        ArrayList<Audio> audioResult;
        ArrayList<Artist> artistResult = new ArrayList<>();

        if (serchTextField != null) {
            audioResult = UserAccountController.searchInAudios(serchTextField.getText());
            artistResult = UserAccountController.searchInArtists(serchTextField.getText());

            int index = 0;

            for (Audio a : audioResult){
                Label audioLabel = new Label("audio name: "+ a.getAudioName() + "\nlikes: " + a.getLikesNum());
                audioLabel.setOnMouseClicked(e -> {
                    try {
                        ArrayList<Audio> hereAudio= audioResult;
                        hereAudio.add(a);
                        makeReadyToPlay(a , hereAudio , e);
                    } catch (Exception ex) {
                        Alerts.errorAlert();
                    }
                });
                audioLabel.setPrefSize(440 , 80);
                resultGridPane.add(audioLabel ,0 , index );
                index++;
            }

            for (Artist a : artistResult){
                Label artistLabel = new Label("artist name: "+ a.getUsername() + "\n" + a.getBiography());
                artistLabel.setOnMouseClicked(e -> {
                    try {
                        NecessaryMethods.saveLastScene(e);
                        ShowArtistsInformation.setArtist(a);
                        new ShowArtistsInformation().start(NecessaryMethods.getStage(e));
                    } catch (Exception ex) {
                        Alerts.errorAlert();
                    }
                });
                artistLabel.setPrefSize(440 , 80);
                resultGridPane.add(artistLabel ,0 , index );
                index++;
            }
        } else {
            audioResult = new ArrayList<>();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SidebarMake sidebarMake = new SidebarMake();
        sidebarVBox.getChildren().add(sidebarMake.getSidebar());

        resultScrollPane.setContent(resultGridPane);
    }
}
