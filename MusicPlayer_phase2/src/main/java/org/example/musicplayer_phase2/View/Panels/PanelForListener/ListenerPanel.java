package org.example.musicplayer_phase2.View.Panels.PanelForListener;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.SidebarItems.SidebarMake;
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.AboutHumans.Artist;
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
        AboutStyleSheet.putStyleSheet(scene);
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
        NecessaryMethods.saveLastScene(event);
        try {
            new BuySubscription().start(NecessaryMethods.getStage(event));
        } catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    @FXML
    void buyEnter(MouseEvent event) {
        buyLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void buyExit(MouseEvent event) {
        buyLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
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
                alert.showAndWait();
            }
        }
    }

    @FXML
    void makePlaylistLabelEnter(MouseEvent event) {
        makePlaylistLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
    }

    @FXML
    void makePlaylistLabelExit(MouseEvent event) {
        makePlaylistLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SidebarMake sidebarMake = new SidebarMake();
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
            for (Playlist p : UserAccountController.listener.getAllPlaylists()) {
                Label label = new Label(p.getPlaylistName());
                label.setOnMouseClicked(e -> {
                    try {
                        PlaylistInformation.setPlaylist(p);
                        new PlaylistInformation().start(NecessaryMethods.getStage(e));
                    } catch (Exception ex) {
                        Alerts.errorAlert();
                    }
                });
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
            usernameTextField.setText("username: " + UserAccountController.listener.getUsername());
            passwordTextFild.setText("password: " + UserAccountController.listener.getPassword());
            creditTextfield.setText("your credit: "+ UserAccountController.listener.getCredit());
            if (UserAccountController.listener instanceof Premium)
                subscriptionTextField.setText("end subscription: " + UserAccountController.listener.getEndSubscription());
            else if (UserAccountController.listener instanceof Free)
                subscriptionTextField.setText("you didn't get premium");

            usernameTextField.setEditable(false);
            passwordTextFild.setEditable(false);
            creditTextfield.setEditable(false);
            subscriptionTextField.setEditable(false);
        }
    }
}
