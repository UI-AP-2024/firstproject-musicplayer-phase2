package org.example.phase2;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.phase2.Controller.ListenerController;
import org.example.phase2.Exceptions.NotEnoughMoney;
import org.example.phase2.Model.Database.Database;
import org.example.phase2.Model.Database.GeneralOperation;
import org.example.phase2.Model.Users.PremiumListener;
import org.example.phase2.Model.Users.PremiumTypes;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

public class GetPremiumController implements Initializable, GeneralOperation {

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
    private AnchorPane secondaryAnchor;

    @FXML
    private VBox vBox1;

    @FXML
    private VBox vBox2;

    @FXML
    private ImageView search_img;

    @FXML
    private TextField search_tF;
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
    void backAction(ActionEvent event) throws IOException {
        backTo();
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
        PremiumListener premiumListener = (PremiumListener) ListenerController.getListenerController().getListener();
        long leftDays=premiumListener.getLeftDays()+1;
        leftDays2_lbl.setText(String.valueOf(leftDays));
        premiumListener.setLeftDays(premiumListener.getLeftDays()+2);
        currentCredit2_lbl.setText(String.valueOf(ListenerController.getListenerController().getListener().getCredit()));
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
        ListenerController.getListenerController().getListener().setCredit(ListenerController.getListenerController().getListener().getCredit()+50);
        currentCredit2_lbl.setText(String.valueOf(ListenerController.getListenerController().getListener().getCredit()));
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
    void logoutAction(ActionEvent event) throws IOException {
        logout();
    }

    @FXML
    void searchAction(MouseEvent event) throws IOException {
        search();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(FXCollections.observableArrayList("One month","Two months","Six months"));
        currentCredit2_lbl.setText(String.valueOf(ListenerController.getListenerController().getListener().getCredit()));
        if(ListenerController.getListenerController().getListener() instanceof PremiumListener){
            PremiumListener premiumListener = (PremiumListener) ListenerController.getListenerController().getListener();
            long leftDays=premiumListener.getLeftDays()+1;
            leftDays2_lbl.setText(String.valueOf(leftDays));
            premiumListener.setLeftDays(premiumListener.getLeftDays()+2);
        }else{
            leftDays2_lbl.setText("0");
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
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("GetPremium.fxml")));
        Database.getDatabase().getTitles().add("Get Premium");
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
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("GetPremium.fxml")));
        Database.getDatabase().getTitles().add("Get Premium");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SearchController.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Search");
        stage.setScene(scene);
        stage.show();
    }
}
