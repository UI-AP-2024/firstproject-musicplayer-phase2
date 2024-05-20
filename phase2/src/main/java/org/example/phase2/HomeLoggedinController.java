package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.phase2.Controller.ListenerController;
import org.example.phase2.Model.Audios.Audio;
import org.example.phase2.Model.Database.Database;
import org.example.phase2.Model.Database.GeneralOperation;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HomeLoggedinController implements Initializable, GeneralOperation {

    @FXML
    private Button artists_btn;

    @FXML
    private Button audios_btn;

    @FXML
    private Button back_btn;

    @FXML
    private Label favorite_lbl;

    @FXML
    private HBox hBox;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane initialAnchor;

    @FXML
    private Button library_btn;

    @FXML
    private ListView<Label> listView;

    @FXML
    private Button logout_btn;

    @FXML
    private ImageView magnifier_img;

    @FXML
    private TextField search_tF;

    @FXML
    private AnchorPane secondaryAnchor;

    @FXML
    private VBox vBox1;

    @FXML
    private VBox vBox2;
    private static Stage stage;
    public static void setStage(Stage stage){
        HomeLoggedinController.stage =stage;
    }

    @FXML
    void artistsAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Home-loggedin.fxml")));
        Database.getDatabase().getTitles().add("Home");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Artists");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void audiosAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Home-loggedin.fxml")));
        Database.getDatabase().getTitles().add("Home");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ShowAudios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Audios");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        backTo();
    }

    @FXML
    void homeAction(ActionEvent event) {

    }

    @FXML
    void libraryAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Home-loggedin.fxml")));
        Database.getDatabase().getTitles().add("Home");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Listener-panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Listener Panel");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
        logout();
    }

    @FXML
    void searchAction(MouseEvent event) throws IOException {
        search();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Audio> suggestedAudios= ListenerController.getListenerController().showSuggestions(8);
        int i=0;
        for(Audio audio : suggestedAudios){
            Label label=new Label("Name: "+audio.getName()+"ID: "+audio.getId());
            listView.getItems().add(label);
            listView.getItems().get(i++).setOnMouseClicked(mouseEvent -> {
                int index=Database.getDatabase().getAudios().indexOf(audio);
                PlayBar.setIndex(index);
                MusicPageController.setAudio(audio);
                Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Home-loggedin.fxml")));
                Database.getDatabase().getTitles().add("Home");
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MusicPage.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(), 800, 600);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setTitle("Music Page");
                stage.setScene(scene);
                stage.show();
            });
        }
        try {
            vBox1.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("Play-bar.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void backTo() throws IOException {
        FXMLLoader fxmlLoader= Database.getDatabase().getScenes().pop();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle(Database.getDatabase().getTitles().pop());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void logout() throws IOException {
        ListenerController.getListenerController().logout();
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Home-loggedin.fxml")));
        Database.getDatabase().getTitles().add("Home");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void login() throws IOException {

    }

    @Override
    public void signup() throws IOException {

    }

    @Override
    public void search() throws IOException {
        SearchController.setSearchedPhrase(search_tF.getText());
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Home-loggedin.fxml")));
        Database.getDatabase().getTitles().add("Home");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SearchController.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Search");
        stage.setScene(scene);
        stage.show();
    }
}
