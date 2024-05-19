package org.example.spotifysecondfase;

import controller.ListenerController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.UserAccount.Listener.Listener;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Subscription implements Initializable {
    @FXML
    private Button allArtists;
    public Button getAllArtists() {return allArtists;}
    public void setAllArtists(Button allArtists) {this.allArtists = allArtists;}
    @FXML
    private Button allAudios;
    public Button getAllAudios() {return allAudios;}
    public void setAllAudios(Button allAudios) {this.allAudios = allAudios;}
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView homeImage;
    public ImageView getHomeImage() {return homeImage;}
    public void setHomeImage(ImageView homeImage) {this.homeImage = homeImage;}
    @FXML
    private ImageView homeLibrary;
    @FXML
    private VBox homeVbox;
    @FXML
    private HBox oneMonthHbox;
    @FXML
    private Label oneMonthLbl;
    @FXML
    private Label oneMonthPrice;
    public Label getOneMonthPrice() {return oneMonthPrice;}
    public void setOneMonthPrice(Label oneMonthPrice) {this.oneMonthPrice = oneMonthPrice;}
    @FXML
    private Button oneMonthStart;
    public Button getOneMonthStart() {return oneMonthStart;}
    public void setOneMonthStart(Button oneMonthStart) {this.oneMonthStart = oneMonthStart;}
    @FXML
    private VBox oneMonthVbox;
    @FXML
    private ImageView onePremiumImage;
    @FXML
    private Label onePremiumLbl;
    @FXML
    private ImageView searchImage;
    public ImageView getSearchImage() {return searchImage;}
    public void setSearchImage(ImageView searchImage) {this.searchImage = searchImage;}
    @FXML
    private ImageView spotify;
    @FXML
    private HBox threeMonthHbox;
    @FXML
    private Label threeMonthLbl;
    @FXML
    private Label threeMonthPrice;
    public Label getThreeMonthPrice() {return threeMonthPrice;}
    public void setThreeMonthPrice(Label threeMonthPrice) {this.threeMonthPrice = threeMonthPrice;}
    @FXML
    private Button threeMonthStart;
    public Button getThreeMonthStart() {return threeMonthStart;}
    public void setThreeMonthStart(Button threeMonthStart) {this.threeMonthStart = threeMonthStart;}
    @FXML
    private VBox threeMonthVbox;
    @FXML
    private ImageView threePremiumImage;
    @FXML
    private Label threePremiumLbl;
    @FXML
    private HBox twoMonthHbox;
    @FXML
    private Label twoMonthLbl;
    @FXML
    private Label twoMonthPrice;
    public Label getTwoMonthPrice() {return twoMonthPrice;}
    public void setTwoMonthPrice(Label twoMonthPrice) {this.twoMonthPrice = twoMonthPrice;}
    @FXML
    private Button twoMonthStart;
    public Button getTwoMonthStart() {return twoMonthStart;}
    public void setTwoMonthStart(Button twoMonthStart) {this.twoMonthStart = twoMonthStart;}
    @FXML
    private VBox twoMonthVbox;
    @FXML
    private ImageView twoPremiumImage;
    @FXML
    private Label twoPremiumLbl;
    Listener listener;
    ListenerController listenerController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeImage.setOnMouseClicked(event -> {
            try {
                ChangeScene.home();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        searchImage.setOnMouseClicked(event -> {
            try {
                ChangeScene.search();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        allArtists.setOnMouseClicked(event -> {
            try {
                ChangeScene.allArtists();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        allAudios.setOnMouseClicked(event -> {
            try {
                ChangeScene.allAudios();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        oneMonthStart.setOnMouseClicked(event -> {
            listenerController.buyOrRenew(Integer.parseInt(oneMonthPrice.getText()));
//            if (listener.getAccountCredit() >= Integer.parseInt(oneMonthPrice.getText()));
//            {
//                listener.setAccountCredit(listener.getAccountCredit() - Integer.parseInt(oneMonthPrice.getText()));
//            }
//            try {
//                throw new Exception("Your credit is not enough");
//            }catch (Exception e)
//            {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText(e.getMessage());
//                alert.showAndWait();
//            }
        });
        twoMonthStart.setOnMouseClicked(event -> {
            listenerController.buyOrRenew(Integer.parseInt(twoMonthPrice.getText()));
        });
        threeMonthStart.setOnMouseClicked(event -> {
            listenerController.buyOrRenew(Integer.parseInt(threeMonthPrice.getText()));
        });
    }
}
