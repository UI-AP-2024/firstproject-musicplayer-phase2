package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import org.example.musicap.Controllers.AccountController;
import org.example.musicap.HelloApplication;
import org.example.musicap.Models.Data.Database;

import java.io.IOException;

public class LoginViewController implements ShowAlert {

    @FXML
    private AnchorPane mainBody;
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private AccountController accountController;
    private Database database;
    public void initialize()
    {
        LayoutViewController.pagesStack.add("home-view.fxml");
        accountController = AccountController.getAccountController();
        database = Database.getInstance();
    }
    @FXML
    private void handleSubmitButtonAction() throws InterruptedException, IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();
        try{
            String result = accountController.login(username, password);
            showAlert(result, "Login result", "Login");
            Thread.sleep(1000);
            if(result.equals("Welcome to your account")) showUserPanel();
        }
        catch (Exception e)
        {
            showAlert(e.getMessage(), "Login Result", "Login");
        }
    }

    private void showUserPanel() throws IOException {
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("listener-view.fxml"));
        AnchorPane newPane = loader.load();
        mainBody.getChildren().add(newPane);
    }
}
