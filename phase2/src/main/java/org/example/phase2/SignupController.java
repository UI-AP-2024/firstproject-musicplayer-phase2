package org.example.phase2;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    @FXML
    private Label accountLabel;

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
    private AnchorPane initialAnchor;

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
    private Button signUp_btn;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField usernameTextField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        combo.setItems(FXCollections.observableArrayList("Item1","Item2"));
        String str=combo.getSelectionModel().getSelectedItem();
        System.out.println(str);
    }


}