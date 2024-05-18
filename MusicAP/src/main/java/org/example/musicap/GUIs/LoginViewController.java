package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.example.musicap.Controllers.AccountController;
import org.example.musicap.Models.Data.Database;

public class LoginViewController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private AccountController accountController;
    private Database database;
    public void initialize()
    {
        accountController = AccountController.getAccountController();
        database = Database.getInstance();
    }
    @FXML
    private void handleSubmitButtonAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        showAlert(accountController.login(username, password));
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Login attempt!");
        alert.setHeaderText("Login");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
