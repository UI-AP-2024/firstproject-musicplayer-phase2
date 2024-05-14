package org.example.musicplayer_phase2.View.Panels;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.SidebarItems.SidebarMake;
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.controller.AboutLIstener.PremiumController;
import org.example.musicplayer_phase2.controller.NecessaryMethods;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.AboutHumans.Artist;
import org.example.musicplayer_phase2.model.AboutHumans.Listener;
import org.example.musicplayer_phase2.model.AboutMusic.Playlist;
import org.example.musicplayer_phase2.model.Types.Free;
import org.example.musicplayer_phase2.model.Types.Premium;

import java.net.URL;
import java.util.ResourceBundle;

public class ListenerPanel extends Application implements Initializable {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("listenerPanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        NecessaryMethods.putStyleSheet(scene);
        stage.setTitle("listener panel");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private ScrollPane scrollPaneForPlaylists;

    @FXML
    private VBox sidebareVBox;

    @FXML
    private ScrollPane followingScrollPane;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField passwordTextFild;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField subscriptionTextField;
    @FXML
    private TextField creditTextfield;
    @FXML
    private Label buyLabel;
    @FXML
    private Label makePlaylistLabel;
    @FXML
    private TextField newPlaylistTextField;

    @FXML
    void buyClicked(MouseEvent event) {

    }

    @FXML
    void buyEnter(MouseEvent event) {

    }

    @FXML
    void buyExit(MouseEvent event) {

    }

    @FXML
    void makePlaylistLabelClicked(MouseEvent event) {
        if (newPlaylistTextField != null){
            try {
                new ListenerController().makePlaylist(newPlaylistTextField.getText() , UserAccountController.listener);
                new ListenerPanel().start(NecessaryMethods.getStage(event));
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.getMessage());
            }
        }
    }

    @FXML
    void makePlaylistLabelEnter(MouseEvent event) {
        makePlaylistLabel.setTextFill(Color.BLUE);
    }

    @FXML
    void makePlaylistLabelExit(MouseEvent event) {
        makePlaylistLabel.setTextFill(Color.WHITE);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SidebarMake sidebarMake = new SidebarMake();
        sidebarMake.makeActionsForLabelsAndButtons(sidebarMake);
        sidebareVBox.getChildren().add(sidebarMake.getSidebar());

        GridPane playlistGridpane = new GridPane();
        putPlaylists(playlistGridpane);
        scrollPaneForPlaylists.setContent(playlistGridpane);

        GridPane followingArtists = new GridPane();
        putFollowings(followingArtists);
        followingScrollPane.setContent(followingArtists);

        fillLabelsAndTextFields();
    }

    private void putPlaylists(GridPane gridPane) {
        if (UserAccountController.listener != null) {
            int index = 0;
            for (Playlist a : UserAccountController.listener.getAllPlaylists()) {
                Label label = new Label(a.getPlaylistName());
                label.setPrefSize(200, 50);
                gridPane.add(label, 0, index);
                ++index;
            }
        }
    }

    private void putFollowings(GridPane gridPane) {
        if (UserAccountController.listener != null) {
            int index = 0;
            for (Artist a : UserAccountController.listener.getFollowingArtists()) {
                Label label = new Label(a.getUsername());
                label.setPrefSize(170, 50);
                gridPane.add(label, 0, index);
                ++index;
            }
        }
    }

    private void fillLabelsAndTextFields() {
        if (UserAccountController.listener != null) {
            nameTextField.setText("name: " + UserAccountController.listener.getName());
            usernameTextField.setText("username: " + UserAccountController.listener.getUsername());
            passwordTextFild.setText("password: " + UserAccountController.listener.getPassword());
            creditTextfield.setText("your credit: "+ UserAccountController.listener.getCredit());
            if (UserAccountController.listener instanceof Premium)
                subscriptionTextField.setText("end of subscription: " + UserAccountController.listener.getEndSubscription());
            else if (UserAccountController.listener instanceof Free)
                subscriptionTextField.setText("you didn't get premium");

            nameTextField.setEditable(false);
            usernameTextField.setEditable(false);
            passwordTextFild.setEditable(false);
            creditTextfield.setEditable(false);
            subscriptionTextField.setEditable(false);
        }
    }
}
