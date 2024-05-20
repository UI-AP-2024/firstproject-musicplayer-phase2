package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.phase2.Controller.ListenerController;
import org.example.phase2.Model.Database.Database;
import org.example.phase2.Model.Users.FreeListener;
import org.example.phase2.Model.Users.PremiumListener;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

public class AccountInfoController implements Initializable {

    @FXML
    private Label account_blb;

    @FXML
    private Button artists_btn;

    @FXML
    private Button audios_btn;

    @FXML
    private Button back_btn;

    @FXML
    private Label birthDate1;

    @FXML
    private Label birthDate2;

    @FXML
    private Label credit1;

    @FXML
    private Label credit2;

    @FXML
    private Label emailAddress1;

    @FXML
    private Label emailAddress2;

    @FXML
    private HBox hBox;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane initialAnchor;

    @FXML
    private Label leftDays1;

    @FXML
    private Label leftDays2;

    @FXML
    private Button library_btn;

    @FXML
    private Label name1;

    @FXML
    private Label name2;

    @FXML
    private Label phoneNumber1;

    @FXML
    private Label phoneNumber2;

    @FXML
    private Button search_btn;

    @FXML
    private AnchorPane secondaryAnchor;

    @FXML
    private Label username1;

    @FXML
    private Label username2;

    @FXML
    private VBox vBox;

    @FXML
    private VBox vBox2;
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        AccountInfoController.stage = stage;
    }

    @FXML
    void artistsAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AccountInfo.fxml")));
        Database.getDatabase().getTitles().add("Account Information");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Artists");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void audiosAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AccountInfo.fxml")));
        Database.getDatabase().getTitles().add("Account Information");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ShowAudios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Audios");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader= Database.getDatabase().getScenes().pop();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle(Database.getDatabase().getTitles().pop());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void homeAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AccountInfo.fxml")));
        Database.getDatabase().getTitles().add("Account Information");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-loggedin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void libraryAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("AccountInfo.fxml")));
        Database.getDatabase().getTitles().add("Account Information");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Listener-panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Listener Panel");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void searchAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
//            hBox.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("side-bar.fxml")).load());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            vBox.getChildren().add(new FXMLLoader(HelloApplication.class.getResource("Play-bar.fxml")).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        name2.setText(ListenerController.getListenerController().getListener().getFirstAndLastName());
        username2.setText(ListenerController.getListenerController().getListener().getUsername());
        emailAddress2.setText(ListenerController.getListenerController().getListener().getEmailAddress());
        phoneNumber2.setText(ListenerController.getListenerController().getListener().getPhoneNumber());
        birthDate2.setText(ListenerController.getListenerController().getListener().getBirthDate());
        credit2.setText(String.valueOf(ListenerController.getListenerController().getListener().getCredit()));
        if(ListenerController.getListenerController().getListener() instanceof PremiumListener)
        {
            PremiumListener premiumListener=(PremiumListener)ListenerController.getListenerController().getListener();
            leftDays2.setText(String.valueOf(((PremiumListener) ListenerController.getListenerController().getListener()).getLeftDays()));
            if(premiumListener.getLeftDays()==-1)
            {
                FreeListener newFreelistener = null;
                try {
                    newFreelistener = new FreeListener(premiumListener.getUsername(),premiumListener.getPassword(),premiumListener.getFirstAndLastName(),premiumListener.getEmailAddress(),premiumListener.getPhoneNumber(),premiumListener.getBirthDate2());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                newFreelistener.setCredit(premiumListener.getCredit());
                newFreelistener.setPlaylists(premiumListener.getPlaylists());
                newFreelistener.setNumberOfPlayingEachAudio(premiumListener.getNumberOfPlayingEachAudio());
                newFreelistener.setInterestedGenres(premiumListener.getInterestedGenres());
                newFreelistener.setNumberOfInterestedGenres(premiumListener.getNumberOfInterestedGenres());
                newFreelistener.setLikedAudios(premiumListener.getLikedAudios());
                newFreelistener.setFollowings(premiumListener.getFollowings());
                newFreelistener.setPlayedAudios(premiumListener.getPlayedAudios());
                Database.getDatabase().getUsers().remove(premiumListener);
                Database.getDatabase().getUsers().add(newFreelistener);
                ListenerController.getListenerController().setListener(newFreelistener);
            }
            else
            {
                premiumListener.setLeftDays(premiumListener.getLeftDays()+2);
            }
        }
        else{
            leftDays2.setText(String.valueOf(0));
        }
    }
}