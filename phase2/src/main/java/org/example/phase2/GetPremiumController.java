package org.example.phase2;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.phase2.Controller.ListenerController;
import org.example.phase2.Exceptions.NotEnoughMoney;
import org.example.phase2.Model.Database.Database;
import org.example.phase2.Model.Users.PremiumTypes;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

public class GetPremiumController implements Initializable {

    @FXML
    private Button artists_btn;

    @FXML
    private Button audios_btn;

    @FXML
    private Button back_btn;

    @FXML
    private Button buy_btn;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label creditType1_lbl;

    @FXML
    private Label currentCredit1_lbl;

    @FXML
    private Label currentCredit2_lbl;

    @FXML
    private HBox hBox;

    @FXML
    private Button home_btn;

    @FXML
    private Button increase_btn;

    @FXML
    private Label increase_lbl;

    @FXML
    private AnchorPane initialAnchor;

    @FXML
    private Label leftDays1_lbl;

    @FXML
    private Label leftDays2_lbl;

    @FXML
    private Button library_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private Label premium_lbl;

    @FXML
    private Button search_btn;

    @FXML
    private AnchorPane secondaryAnchor;

    @FXML
    private VBox vBox1;

    @FXML
    private VBox vBox2;
    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        GetPremiumController.stage = stage;
    }

    @FXML
    void artistsAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("GetPremium.fxml")));
        Database.getDatabase().getTitles().add("Get Premium");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AllArtists.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Artists");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void audiosAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("GetPremium.fxml")));
        Database.getDatabase().getTitles().add("Get Premium");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ShowAudios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Audios");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backAction(ActionEvent event) {

    }

    @FXML
    void buyAction(ActionEvent event) {
        String premiumType=comboBox.getSelectionModel().getSelectedItem();
        if(premiumType.equals("One month")){
            try {
                ListenerController.getListenerController().getPremium("ONEMONTH");
            } catch (ParseException e) {
                throw new RuntimeException(e);
            } catch (NotEnoughMoney e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("You don't have enough money.");
                alert.showAndWait();
            }
        }
        if(premiumType.equals("Two months")){
            try {
                ListenerController.getListenerController().getPremium("TWOMONTHS");
            } catch (ParseException e) {
                throw new RuntimeException(e);
            } catch (NotEnoughMoney e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("You don't have enough money.");
                alert.showAndWait();
            }
        }
        if(premiumType.equals("Six months")){
            try {
                ListenerController.getListenerController().getPremium("SIXMONTHS");
            } catch (ParseException e) {
                throw new RuntimeException(e);
            } catch (NotEnoughMoney e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("You don't have enough money.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void homeAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("GetPremium.fxml")));
        Database.getDatabase().getTitles().add("Get Premium");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-loggedin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void increaseAction(ActionEvent event) {

    }

    @FXML
    void libraryAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("GetPremium.fxml")));
        Database.getDatabase().getTitles().add("Get Premium");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Listener-panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Listener Panel");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logoutAction(ActionEvent event) {

    }

    @FXML
    void searchAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(FXCollections.observableArrayList("One month","Two months","Six months"));
    }
}
