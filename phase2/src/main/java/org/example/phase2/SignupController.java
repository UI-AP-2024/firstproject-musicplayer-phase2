package org.example.phase2;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.phase2.Controller.UserController;
import org.example.phase2.Exceptions.EasyPassword;
import org.example.phase2.Exceptions.InvalidFormatException;
import org.example.phase2.Exceptions.UsernameExist;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    @FXML
    private Button back_btn;

    @FXML
    private Button Search_btn;

    @FXML
    private Label accountLabel;

    @FXML
    private Button artists_btn;

    @FXML
    private Button audios_btn;

    @FXML
    private Label bioLabel;

    @FXML
    private TextField bioTextField;

    @FXML
    private Label birthLabel;

    @FXML
    private TextField birthTextField;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private HBox hBox;

    @FXML
    private Button home_btn;

    @FXML
    private AnchorPane initialAnchor;

    @FXML
    private Button library_btn;

    @FXML
    private Button login_btn;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Label phoneLabel;

    @FXML
    private TextField phoneTextField;

    @FXML
    private AnchorPane secondaryAnchor;

    @FXML
    private VBox side_vBox;

    @FXML
    private Button signUp_btn;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField usernameTextField;
    private static Stage stage;
    public static void getStage(Stage stage){
        SignupController.stage =stage;
    }

    @FXML
    void artistsAction(ActionEvent event) {

    }

    @FXML
    void audiosAction(ActionEvent event) {

    }

    @FXML
    void homeAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home-loggedout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void libraryAction(ActionEvent event) {

    }

    @FXML
    void loginAction(ActionEvent event) {

    }

    @FXML
    void searchAction(ActionEvent event) {

    }
    @FXML
    void backAction(ActionEvent event) {

    }

    @FXML
    void signUpAction(ActionEvent event) {
        String str=combo.getSelectionModel().getSelectedItem();
        if(str.equals("Listener")){
            try {
                UserController.getUserController().registerUser("L",usernameTextField.getText(),passwordTextField.getText(),nameTextField.getText(),emailTextField.getText(),phoneTextField.getText(),birthTextField.getText());
            } catch (ParseException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Enter your birthdate in correct format.");
                alert.showAndWait();
            } catch (InvalidFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Invalid phone number or email address.");
                alert.showAndWait();
            } catch (EasyPassword e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Your password is too easy, please change it.");
                alert.showAndWait();
            } catch (UsernameExist e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("this username already exists, please change your username.");
            }
            //Going to listener's panel.
        }
        bioLabel.setVisible(true);
        bioTextField.setVisible(true);
        if(str.equals("Podcaster")){
            try {
                UserController.getUserController().registerUser("P",usernameTextField.getText(),passwordTextField.getText(),nameTextField.getText(),emailTextField.getText(),phoneTextField.getText(),birthTextField.getText(),bioTextField.getText());
            } catch (ParseException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Enter your birthdate in correct format.");
                alert.showAndWait();
            } catch (InvalidFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Invalid phone number or email address.");
                alert.showAndWait();
            } catch (EasyPassword e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Your password is too easy, please change it.");
                alert.showAndWait();
            } catch (UsernameExist e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("this username already exists, please change your username.");
            }
            //Going to Artist's panel.
        }
        if(str.equals("Singer")){
            try {
                UserController.getUserController().registerUser("S",usernameTextField.getText(),passwordTextField.getText(),nameTextField.getText(),emailTextField.getText(),phoneTextField.getText(),birthTextField.getText(),bioTextField.getText());
            } catch (ParseException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Enter your birthdate in correct format.");
                alert.showAndWait();
            } catch (InvalidFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Invalid phone number or email address.");
                alert.showAndWait();
            } catch (EasyPassword e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Your password is too easy, please change it.");
                alert.showAndWait();
            } catch (UsernameExist e) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("this username already exists, please change your username.");
            }
            //Going to Artist's panel.
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        combo.setItems(FXCollections.observableArrayList("Listener","Podcaster","Singer"));
        bioTextField.setVisible(false);
        bioLabel.setVisible(false);

    }
}
