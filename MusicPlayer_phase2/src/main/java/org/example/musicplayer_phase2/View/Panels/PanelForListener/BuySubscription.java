package org.example.musicplayer_phase2.View.Panels.PanelForListener;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.HelloApplication;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.SidebarItems.SidebarMake;
import org.example.musicplayer_phase2.controller.AboutLIstener.ListenerController;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import org.example.musicplayer_phase2.controller.UserAccountController;
import org.example.musicplayer_phase2.model.Exceptions.NotEnoughCredit;
import org.example.musicplayer_phase2.model.Types.PremiumType;

import java.net.URL;
import java.util.ResourceBundle;

public class BuySubscription extends Application implements Initializable {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("buySubscription.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 600 , 450);
        AboutStyleSheet.putStyleSheet(scene);
        stage.setTitle("buy subscription");
        stage.setScene(scene);
        stage.show();
    }

    private PremiumType choosePremiumType = null;

    @FXML
    private TextField increasCreditTextField;

    @FXML
    private Button increaseButton;

    @FXML
    private SplitMenuButton premiumType;

    @FXML
    private VBox sidebareVBox;

    @FXML
    void buyClicked(MouseEvent event) {
        if (choosePremiumType != null){
            try {
                new ListenerController().buySubscription(choosePremiumType , UserAccountController.listener);

                try {
                    new ListenerPanel().start(NecessaryMethods.getStage(event));
                } catch (Exception e) {
                    Alerts.errorAlert();
                }
            } catch (NotEnoughCredit e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("fail in buying");
                alert.setContentText(e.getMessage());
            }
        }
    }

    @FXML
    void click180(ActionEvent event) {
        choosePremiumType = PremiumType.ONEHUNDREDEIGHTY;
        premiumType.setText("180 days");
    }

    @FXML
    void click30(ActionEvent event) {
        choosePremiumType = PremiumType.THIRTY;
        premiumType.setText("30 days");
    }

    @FXML
    void click60(ActionEvent event) {
        choosePremiumType = PremiumType.SIXTY;
        premiumType.setText("60 days");
    }

    @FXML
    void increaseClicked(MouseEvent event) {
        try {
            Double increase = Double.parseDouble(increasCreditTextField.getText());
            UserAccountController.listener.setCredit(UserAccountController.listener.getCredit() + increase);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("successful work");
            alert.setContentText("your credit: " + UserAccountController.listener.getCredit());
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("invalid amount");
            alert.setContentText("you hava to enter a number");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SidebarMake sidebarMake = new SidebarMake();
        sidebareVBox.getChildren().add(sidebarMake.getSidebar());
    }
}
