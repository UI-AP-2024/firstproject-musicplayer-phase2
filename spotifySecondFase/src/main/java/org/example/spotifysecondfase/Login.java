package org.example.spotifysecondfase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import controller.UserAccountController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable
{
    private UserAccountController userAccountController;
    public UserAccountController getUserAccountController() {return userAccountController;}
    public void setUserAccountController(UserAccountController userAccountController) {this.userAccountController = userAccountController;}
    @FXML
    private AnchorPane anchorPane;

    public AnchorPane getAnchorPane() {return anchorPane;}
    public void setAnchorPane(AnchorPane anchorPane) {this.anchorPane = anchorPane;}
    @FXML
    private Label lable;

    public Label getLable() {return lable;}
    public void setLable(Label lable) {this.lable = lable;}
    @FXML
    private Button logIn;
    public Button getLogIn() {return logIn;}
    public void setLogIn(Button logIn) {this.logIn = logIn;}
    @FXML
    private Label passWordLable;
    public Label getPassWordLable() {return passWordLable;}
    public void setPassWordLable(Label passWordLable) {this.passWordLable = passWordLable;}
    @FXML
    private TextField passWordTextField;
    public TextField getPassWordTextField() {return passWordTextField;}
    public void setPassWordTextField(TextField passWordTextField) {this.passWordTextField = passWordTextField;}
    @FXML
    private Label userNameLable;
    public Label getUserNameLable() {return userNameLable;}
    public void setUserNameLable(Label userNameLable) {this.userNameLable = userNameLable;}
    @FXML
    private TextField userNameTextFeild;
    public TextField getUserNameTextFeild() {return userNameTextFeild;}
    public void setUserNameTextFeild(TextField userNameTextFeild) {this.userNameTextFeild = userNameTextFeild;}
    private static Boolean bool = false;
    public static Boolean getBool() {return bool;}
    public static void setBool(Boolean bool) {Login.bool = bool;}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bool = getUserAccountController().findUser(userNameTextFeild.getText(),passWordTextField.getText());
        logIn.setOnMouseClicked(event -> {
            if(bool)
            {
                try {
                    ChangeScene.home();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}
