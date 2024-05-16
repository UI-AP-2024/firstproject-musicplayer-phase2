package org.example.spotifysecondfase.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Singup implements Initializable
{
    @FXML
    private AnchorPane anchorPane;

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    @FXML
    private Label dateOfBirth;

    public Label getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Label dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @FXML
    private TextField day;

    public TextField getDay() {
        return day;
    }

    public void setDay(TextField day) {
        this.day = day;
    }

    @FXML
    private Label emailLable;

    public Label getEmailLable() {
        return emailLable;
    }

    public void setEmailLable(Label emailLable) {
        this.emailLable = emailLable;
    }

    @FXML
    private TextField emailTextField;

    public TextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(TextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    @FXML
    private Label lable;

    public Label getLable() {
        return lable;
    }

    public void setLable(Label lable) {
        this.lable = lable;
    }

    @FXML
    private ComboBox<?> month;

    public ComboBox<?> getMonth() {
        return month;
    }

    public void setMonth(ComboBox<?> month) {
        this.month = month;
    }

    @FXML
    private Label nameLable;

    public Label getNameLable() {
        return nameLable;
    }

    public void setNameLable(Label nameLable) {
        this.nameLable = nameLable;
    }

    @FXML
    private TextField nameTextField;

    public TextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(TextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    @FXML
    private Label passwordLable;

    public Label getPasswordLable() {
        return passwordLable;
    }

    public void setPasswordLable(Label passwordLable) {
        this.passwordLable = passwordLable;
    }

    @FXML
    private TextField passwordTextField;

    public TextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(TextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    @FXML
    private Label phoneNumber;

    public Label getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Label phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @FXML
    private TextField phoneTextField;

    public TextField getPhoneTextField() {
        return phoneTextField;
    }

    public void setPhoneTextField(TextField phoneTextField) {
        this.phoneTextField = phoneTextField;
    }

    @FXML
    private Button signUp;

    public Button getSignUp() {
        return signUp;
    }

    public void setSignUp(Button signUp) {
        this.signUp = signUp;
    }

    @FXML
    private Label userNameLable;

    public Label getUserNameLable() {
        return userNameLable;
    }

    public void setUserNameLable(Label userNameLable) {
        this.userNameLable = userNameLable;
    }

    @FXML
    private TextField userNameTextField;

    public TextField getUserNameTextField() {
        return userNameTextField;
    }

    public void setUserNameTextField(TextField userNameTextField) {
        this.userNameTextField = userNameTextField;
    }

    @FXML
    private VBox vbox;

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    @FXML
    private HBox hbox;

    public HBox getHbox() {
        return hbox;
    }

    public void setHbox(HBox hbox) {
        this.hbox = hbox;
    }

    @FXML
    private TextField year;

    public TextField getYear() {
        return year;
    }

    public void setYear(TextField year) {
        this.year = year;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
