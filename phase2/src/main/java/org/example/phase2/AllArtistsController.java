package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.example.phase2.Controller.ListenerController;
import org.example.phase2.Model.Audios.Audio;
import org.example.phase2.Model.Database.Database;
import org.example.phase2.Model.Database.GeneralOperation;
import org.example.phase2.Model.Users.Artist;
import org.example.phase2.Model.Users.UserAccount;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AllArtistsController implements Initializable, GeneralOperation {

    @FXML
    private Label allArtists_lbl;

    @FXML
    private Button artists_btn;

    @FXML
    private Button audios_btn;

    @FXML
    private Button back_btn;

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
    private ImageView magnifier_image;

    @FXML
    private TextField search_tF;

    @FXML
    private AnchorPane secondaryAnchor;

    @FXML
    private Button signup_btn;

    @FXML
    private VBox vBox1;

    @FXML
    private VBox vBox2;

    private ArrayList<UserAccount> users;
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        AllArtistsController.stage = stage;
    }
    @FXML
    void artistsAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml")));
        Database.getDatabase().getTitles().add("All Artists");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Artists");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void audiosAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml")));
        Database.getDatabase().getTitles().add("All Artists");
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
    void homeAction(ActionEvent event) throws IOException {
        if(ListenerController.getListenerController().getListener()!=null){
            Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml")));
            Database.getDatabase().getTitles().add("All Artists");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-loggedin.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        }
        else{
            Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml")));
            Database.getDatabase().getTitles().add("All Artists");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void libraryAction(ActionEvent event) throws IOException {
        if(ListenerController.getListenerController().getListener()!=null){
            Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml")));
            Database.getDatabase().getTitles().add("All Artists");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Listener-panel.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Listener Panel");
            stage.setScene(scene);
            stage.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("INFORMATION");
            alert.setHeaderText(null);
            alert.setContentText("You should first login.");
            alert.showAndWait();
        }
    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
        if(ListenerController.getListenerController().getListener()==null){
            login();
        }else{
            logout();
        }
    }

    @FXML
    void searchAction(MouseEvent event) throws IOException {
        search();
    }

    @FXML
    void signupAction(ActionEvent event) throws IOException {
        signup();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int i=0;
        users= Database.getDatabase().getUsers();
        for(UserAccount user : users){
            if(user instanceof Artist){
                Artist artist=(Artist) user;
                Label label = new Label("Name: "+artist.getFirstAndLastName()+"\t\t\t"+"Biography: "+artist.getBiography());
                listView.getItems().add(label);
                listView.getItems().get(i++).setOnMouseClicked(mouseEvent -> {
                    ArtistInfoController.setArtist(artist);
                    Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml")));
                    Database.getDatabase().getTitles().add("All Artists");
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ArtistInfo.fxml"));
                    Scene scene = null;
                    try {
                        scene = new Scene(fxmlLoader.load(), 800, 600);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stage.setTitle("Artist Information");
                    stage.setScene(scene);
                    stage.show();
                });
            }
        }
        try {
            vBox1.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("Play-bar.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(ListenerController.getListenerController().getListener()==null){
            logout_btn.setText("Login");
            signup_btn.setVisible(true);
        }else{
            logout_btn.setText("Logout");
            signup_btn.setVisible(false);
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
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml")));
        Database.getDatabase().getTitles().add("All Artists");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void login() throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml")));
        Database.getDatabase().getTitles().add("All Artists");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void signup() throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml")));
        Database.getDatabase().getTitles().add("All Artists");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Signup");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void search() throws IOException {
        SearchController.setSearchedPhrase(search_tF.getText());
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml")));
        Database.getDatabase().getTitles().add("All Artists");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SearchController.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Search");
        stage.setScene(scene);
        stage.show();
    }
}
