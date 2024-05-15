package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.phase2.Controller.UserController;
import org.example.phase2.Exceptions.UserNotFoundException;
import org.example.phase2.Exceptions.WrongPasswordException;
import org.example.phase2.Model.Database.Database;
import org.example.phase2.Model.Users.UserAccount;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button artists_btn;

    @FXML
    private Button audios_btn;

    @FXML
    private Button back_btn;

    @FXML
    private HBox hbox;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane initialAnchor;

    @FXML
    private Button library_btn;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passField;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button registerButton;

    @FXML
    private Label registerLabel;

    @FXML
    private Button search_btn;

    @FXML
    private AnchorPane secondaryAnchor;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private VBox vBox;
    private static Stage stage;

    @FXML
    void artistsAction(ActionEvent event) {

    }

    @FXML
    void audiosAction(ActionEvent event) {

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
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Login.fxml")));
        Database.getDatabase().getTitles().add("Login");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void libraryAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setHeaderText(null);
        alert.setContentText("You should first login.");
        alert.showAndWait();
    }

    @FXML
    void loginAction(ActionEvent event) {
        try {
            UserController.getUserController().loginUser(usernameTextField.getText(),passField.getText());
        } catch (UserNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Couldn't find the username");
            alert.showAndWait();
        } catch (WrongPasswordException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROr");
            alert.setHeaderText(null);
            alert.setContentText("Password is wrong");
            alert.showAndWait();
        }
    }

    @FXML
    void registerAction(ActionEvent event) throws IOException {
        Database.getDatabase().getScenes().add(new FXMLLoader(HelloApplication.class.getResource("Login.fxml")));
        Database.getDatabase().getTitles().add("Login");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Signup");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void searchAction(ActionEvent event) {

    }
    public static void getStage(Stage stage){
        LoginController.stage =stage;
    }

}