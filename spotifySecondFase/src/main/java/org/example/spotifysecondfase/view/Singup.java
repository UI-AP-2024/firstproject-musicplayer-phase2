package org.example.spotifysecondfase.view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.controlsfx.tools.Borders;
import org.example.spotifysecondfase.controller.ArtistController;
import org.example.spotifysecondfase.controller.ListenerController;
import org.example.spotifysecondfase.model.UserAccount.Artist.Artist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Singup implements Initializable
{
    ListenerController listenerController;
    ArtistController artistController;
    @FXML
    private AnchorPane anchorPane;
    public AnchorPane getAnchorPane() {return anchorPane;}
    public void setAnchorPane(AnchorPane anchorPane) {this.anchorPane = anchorPane;}
    @FXML
    private Label dateOfBirth;
    public Label getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Label dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    @FXML
    private TextField day;
    public TextField getDay() {return day;}
    public void setDay(TextField day) {this.day = day;}
    @FXML
    private Label emailLable;
    public Label getEmailLable() {return emailLable;}
    public void setEmailLable(Label emailLable) {this.emailLable = emailLable;}
    @FXML
    private TextField emailTextField;
    public TextField getEmailTextField() {return emailTextField;}
    public void setEmailTextField(TextField emailTextField) {this.emailTextField = emailTextField;}
    @FXML
    private Label lable;
    public Label getLable() {return lable;}
    public void setLable(Label lable) {this.lable = lable;}
    @FXML
    private MenuButton month;
    public MenuButton getMonth() {return month;}
    public void setMonth(MenuButton month) {this.month = month;}
    @FXML
    private Label nameLable;
    public Label getNameLable() {return nameLable;}
    public void setNameLable(Label nameLable) {this.nameLable = nameLable;}
    @FXML
    private TextField nameTextField;
    public TextField getNameTextField() {return nameTextField;}
    public void setNameTextField(TextField nameTextField) {this.nameTextField = nameTextField;}
    @FXML
    private Label passwordLable;
    public Label getPasswordLable() {return passwordLable;}
    public void setPasswordLable(Label passwordLable) {this.passwordLable = passwordLable;}
    @FXML
    private TextField passwordTextField;
    public TextField getPasswordTextField() {return passwordTextField;}
    public void setPasswordTextField(TextField passwordTextField) {this.passwordTextField = passwordTextField;}
    @FXML
    private Label phoneNumber;
    public Label getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(Label phoneNumber) {this.phoneNumber = phoneNumber;}
    @FXML
    private TextField phoneTextField;
    public TextField getPhoneTextField() {return phoneTextField;}
    public void setPhoneTextField(TextField phoneTextField) {this.phoneTextField = phoneTextField;}
    @FXML
    private Button signUp;
    public Button getSignUp() {return signUp;}
    public void setSignUp(Button signUp) {this.signUp = signUp;}
    @FXML
    private Label userNameLable;
    public Label getUserNameLable() {return userNameLable;}
    public void setUserNameLable(Label userNameLable) {this.userNameLable = userNameLable;}
    @FXML
    private TextField userNameTextField;
    public TextField getUserNameTextField() {return userNameTextField;}
    public void setUserNameTextField(TextField userNameTextField) {this.userNameTextField = userNameTextField;}
    @FXML
    private VBox vbox;
    public VBox getVbox() {return vbox;}
    public void setVbox(VBox vbox) {this.vbox = vbox;}
    @FXML
    private HBox hbox;
    public HBox getHbox() {return hbox;}
    public void setHbox(HBox hbox) {this.hbox = hbox;}
    @FXML
    private TextField year;
    public TextField getYear() {return year;}
    public void setYear(TextField year) {this.year = year;}
    @FXML
    private MenuButton accountType;
    public MenuButton getAccountType() {return accountType;}
    public void setAccountType(MenuButton accountType) {this.accountType = accountType;}
    MenuItem m1 = new MenuItem("Farvardin");
    MenuItem m2 = new MenuItem("Ordibehesht");
    MenuItem m3 = new MenuItem("Khordad");
    MenuItem m4 = new MenuItem("Tir");
    MenuItem m5 = new MenuItem("Mordad");
    MenuItem m6 = new MenuItem("Shahrivar");
    MenuItem m7 = new MenuItem("Mehr");
    MenuItem m8 = new MenuItem("Aban");
    MenuItem m9 = new MenuItem("Azar");
    MenuItem m10 = new MenuItem("Dey");
    MenuItem m11= new MenuItem("Bahman");
    MenuItem m12= new MenuItem("Esfand");

    public void monthMenuButton()
    {
        m1.setOnAction(event -> {
            month.setText(m1.getText());
        });
        m2.setOnAction(event -> {
            month.setText(m2.getText());
        });
        m3.setOnAction(event -> {
            month.setText(m3.getText());
        });
        m4.setOnAction(event -> {
            month.setText(m4.getText());
        });
        m5.setOnAction(event -> {
            month.setText(m5.getText());
        });
        m6.setOnAction(event -> {
            month.setText(m6.getText());
        });
        m7.setOnAction(event -> {
            month.setText(m7.getText());
        });
        m8.setOnAction(event -> {
            month.setText(m8.getText());
        });
        m9.setOnAction(event -> {
            month.setText(m9.getText());
        });
        m10.setOnAction(event -> {
            month.setText(m10.getText());
        });
        m11.setOnAction(event -> {
            month.setText(m11.getText());
        });
        m12.setOnAction(event -> {
            month.setText(m12.getText());
        });
    }
    MenuItem listener = new MenuItem("Listener");
    MenuItem singer = new MenuItem("Singer");
    MenuItem podcaster = new MenuItem("Podcaster");
//    public void accountMenuButton()
//    {
//
//        getAccountType().getItems().addAll(listener,singer,podcaster);
//        m2.setOnAction(event -> {
//            Label label = new Label("Biography");
//            TextField textField = new TextField();
//            textField.setPromptText("Bio");
//            textField.setBackground(Background.fill(Color.BLACK));
//            textField.setBorder(Border.stroke(Color.WHITE));
//            textField.setStyle("-fx-border-radius: 5px");
//            getVbox().getChildren().addAll(label,textField);
//        });
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAccountType().getItems().addAll(listener,singer,podcaster);
        getMonth().getItems().addAll(m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12);
        listener.setOnAction(event -> {
            monthMenuButton();
            listenerController.newListener(userNameTextField.getText(),passwordTextField.getText(),nameTextField.getText(),emailTextField.getText(),phoneTextField.getText(),year.getText(),month.getText(),day.getText());
            if(!listenerController.checkEmail(emailTextField.getText()) | !listenerController.checkPhoneNumber(phoneTextField.getText()))
            {
                try {
                    throw new Exception("Email or Phone number format isn't correct");
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
            if(!listenerController.findUser(userNameTextField.getText(),passwordTextField.getText()))
            {
                try {
                    throw new Exception("This account in already exist");
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
            if (listenerController.checkEmail(emailTextField.getText()) & listenerController.checkPhoneNumber(phoneTextField.getText()) & listenerController.findUser(userNameTextField.getText(),passwordTextField.getText()))
            {
                try {
                    throw new Exception("Sign up was successful");
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
                getSignUp().setOnMouseClicked(event1 -> {
                    try {
                        ChangeScene.chooseGenres();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

        });
        singer.setOnAction (event -> {
            monthMenuButton();
            Label label = new Label("Biography");
            TextField biography = new TextField();
            biography.setPromptText("Bio");
            biography.setBackground(Background.fill(Color.BLACK));
            biography.setBorder(Border.stroke(Color.WHITE));
            biography.setStyle("-fx-border-radius: 5px");
            getVbox().getChildren().addAll(label,biography);
            Artist artist = artistController.artist(userNameTextField.getText(),passwordTextField.getText(),nameTextField.getText(),emailTextField.getText(),phoneTextField.getText(),year.getText(),month.getText(),day.getText(),biography.getText());
            if(!artistController.checkEmail(emailTextField.getText()) | !artistController.checkPhoneNumber(phoneTextField.getText()))
            {
                try {
                    throw new Exception("Email or Phone number format isn't correct");
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
            if(!artistController.findUser(userNameTextField.getText(),passwordTextField.getText()))
            {
                try {
                    throw new Exception("This account in already exist");
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
            if (artistController.checkEmail(emailTextField.getText()) & artistController.checkPhoneNumber(phoneTextField.getText()) & artistController.findUser(userNameTextField.getText(),passwordTextField.getText()))
            {
                listenerController.artistsList(artist);
                try {
                    throw new Exception("Sign up was successful");
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
                getSignUp().setOnMouseClicked(event1 -> {
                    try {
                        ChangeScene.home();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        });
        podcaster.setOnAction(event -> {
            monthMenuButton();
            Label label = new Label("Biography");
            TextField biography = new TextField();
            biography.setPromptText("Bio");
            biography.setBackground(Background.fill(Color.BLACK));
            biography.setBorder(Border.stroke(Color.WHITE));
            biography.setStyle("-fx-border-radius: 5px");
            getVbox().getChildren().addAll(label,biography);
            Artist artist = artistController.artist(userNameTextField.getText(),passwordTextField.getText(),nameTextField.getText(),emailTextField.getText(),phoneTextField.getText(),year.getText(),month.getText(),day.getText(),biography.getText());
            if(!artistController.checkEmail(emailTextField.getText()) | !artistController.checkPhoneNumber(phoneTextField.getText()))
            {
                try {
                    throw new Exception("Email or Phone number format isn't correct");
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
            if(!artistController.findUser(userNameTextField.getText(),passwordTextField.getText()))
            {
                try {
                    throw new Exception("This account in already exist");
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
            if (artistController.checkEmail(emailTextField.getText()) & artistController.checkPhoneNumber(phoneTextField.getText()) & artistController.findUser(userNameTextField.getText(),passwordTextField.getText()))
            {
                listenerController.artistsList(artist);
                try {
                    throw new Exception("Sign up was successful");
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
                getSignUp().setOnMouseClicked(event1 -> {
                    try {
                        ChangeScene.home();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        });
    }
}
