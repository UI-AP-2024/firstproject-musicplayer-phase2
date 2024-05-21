package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import org.example.musicap.Controllers.AccountController;
import org.example.musicap.HelloApplication;

import java.io.IOException;
import java.time.LocalDate;

public class SignupViewController implements ShowAlert {
    private AccountController accountController;

    @FXML
    private AnchorPane mainBody;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private DatePicker dobField;

    @FXML
    private TextArea bioField;

    @FXML
    private ComboBox<String> userTypeComboBox;
    public void initialize()
    {
        LayoutViewController.pagesStack.add("home-view.fxml");
        accountController = AccountController.getAccountController();
    }

    @FXML
    private void handleSubmitButtonAction() throws InterruptedException, IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        LocalDate dob = dobField.getValue();
        String bio = bioField.getText();
        String userType = userTypeComboBox.getValue();
        String result = accountController.signUp(userType, username, password, name, email, phone, dob, bio);
        showAlert(result, "Signup attempt", "Signup");
        Thread.sleep(1000);
        if(result.equals("User added successfully") && userType.equals("Listener")) getFavoriteGenres();
    }

    private void getFavoriteGenres() throws IOException {
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("genres-view.fxml"));
        AnchorPane newPane = loader.load();
        mainBody.getChildren().add(newPane);
    }
}
