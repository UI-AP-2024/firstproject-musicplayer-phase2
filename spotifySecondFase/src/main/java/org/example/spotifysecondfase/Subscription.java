package org.example.spotifysecondfase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.spotifysecondfase.ChangeScene;
import org.example.spotifysecondfase.Singup;
import org.example.spotifysecondfase.view.Exception.NotEnoughCredit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Subscription implements Initializable {
    @FXML
    private ImageView addToPlaylistImage;

    @FXML
    private Button allArtists;

    @FXML
    private Button allAudios;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label artistName;

    @FXML
    private Label audioName;

    @FXML
    private Button backButton;

    @FXML
    private ImageView coverImage;

    @FXML
    private VBox hboxVbox;

    @FXML
    private ImageView homeImage;

    @FXML
    private ImageView homeLibrary;

    @FXML
    private VBox homeVbox;

    @FXML
    private HBox iconsHbox;

    @FXML
    private ImageView likeImage;

    @FXML
    private ImageView lyrics;

    @FXML
    private ImageView nextIcon;

    @FXML
    private HBox oneMonthHbox;

    @FXML
    private Label oneMonthLbl;

    @FXML
    private Label oneMonthPrice;

    @FXML
    private Button oneMonthStart;

    @FXML
    private VBox oneMonthVbox;

    @FXML
    private ImageView onePremiumImage;

    @FXML
    private Label onePremiumLbl;

    @FXML
    private ImageView pauseIcon;

    @FXML
    private HBox playHbox;

    @FXML
    private ImageView previousIcon;

    @FXML
    private ImageView searchImage;

    @FXML
    private ImageView spotify;

    @FXML
    private HBox threeMonthHbox;

    @FXML
    private Label threeMonthLbl;

    @FXML
    private Label threeMonthPrice;

    @FXML
    private Button threeMonthStart;

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

    @FXML
    private Button twoMonthStart;

    @FXML
    private VBox twoMonthVbox;

    @FXML
    private ImageView twoPremiumImage;

    @FXML
    private Label twoPremiumLbl;

    public ImageView getAddToPlaylistImage() {
        return addToPlaylistImage;
    }

    public void setAddToPlaylistImage(ImageView addToPlaylistImage) {
        this.addToPlaylistImage = addToPlaylistImage;
    }

    public Button getAllArtists() {
        return allArtists;
    }

    public void setAllArtists(Button allArtists) {
        this.allArtists = allArtists;
    }

    public Button getAllAudios() {
        return allAudios;
    }

    public void setAllAudios(Button allAudios) {
        this.allAudios = allAudios;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public Label getArtistName() {
        return artistName;
    }

    public void setArtistName(Label artistName) {
        this.artistName = artistName;
    }

    public Label getAudioName() {
        return audioName;
    }

    public void setAudioName(Label audioName) {
        this.audioName = audioName;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public ImageView getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(ImageView coverImage) {
        this.coverImage = coverImage;
    }

    public VBox getHboxVbox() {
        return hboxVbox;
    }

    public void setHboxVbox(VBox hboxVbox) {
        this.hboxVbox = hboxVbox;
    }

    public ImageView getHomeImage() {
        return homeImage;
    }

    public void setHomeImage(ImageView homeImage) {
        this.homeImage = homeImage;
    }

    public ImageView getHomeLibrary() {
        return homeLibrary;
    }

    public void setHomeLibrary(ImageView homeLibrary) {
        this.homeLibrary = homeLibrary;
    }

    public VBox getHomeVbox() {
        return homeVbox;
    }

    public void setHomeVbox(VBox homeVbox) {
        this.homeVbox = homeVbox;
    }

    public HBox getIconsHbox() {
        return iconsHbox;
    }

    public void setIconsHbox(HBox iconsHbox) {
        this.iconsHbox = iconsHbox;
    }

    public ImageView getLikeImage() {
        return likeImage;
    }

    public void setLikeImage(ImageView likeImage) {
        this.likeImage = likeImage;
    }

    public ImageView getLyrics() {
        return lyrics;
    }

    public void setLyrics(ImageView lyrics) {
        this.lyrics = lyrics;
    }

    public ImageView getNextIcon() {
        return nextIcon;
    }

    public void setNextIcon(ImageView nextIcon) {
        this.nextIcon = nextIcon;
    }

    public HBox getOneMonthHbox() {
        return oneMonthHbox;
    }

    public void setOneMonthHbox(HBox oneMonthHbox) {
        this.oneMonthHbox = oneMonthHbox;
    }

    public Label getOneMonthLbl() {
        return oneMonthLbl;
    }

    public void setOneMonthLbl(Label oneMonthLbl) {
        this.oneMonthLbl = oneMonthLbl;
    }

    public Label getOneMonthPrice() {
        return oneMonthPrice;
    }

    public void setOneMonthPrice(Label oneMonthPrice) {
        this.oneMonthPrice = oneMonthPrice;
    }

    public Button getOneMonthStart() {
        return oneMonthStart;
    }

    public void setOneMonthStart(Button oneMonthStart) {
        this.oneMonthStart = oneMonthStart;
    }

    public VBox getOneMonthVbox() {
        return oneMonthVbox;
    }

    public void setOneMonthVbox(VBox oneMonthVbox) {
        this.oneMonthVbox = oneMonthVbox;
    }

    public ImageView getOnePremiumImage() {
        return onePremiumImage;
    }

    public void setOnePremiumImage(ImageView onePremiumImage) {
        this.onePremiumImage = onePremiumImage;
    }

    public Label getOnePremiumLbl() {
        return onePremiumLbl;
    }

    public void setOnePremiumLbl(Label onePremiumLbl) {
        this.onePremiumLbl = onePremiumLbl;
    }

    public ImageView getPauseIcon() {
        return pauseIcon;
    }

    public void setPauseIcon(ImageView pauseIcon) {
        this.pauseIcon = pauseIcon;
    }

    public HBox getPlayHbox() {
        return playHbox;
    }

    public void setPlayHbox(HBox playHbox) {
        this.playHbox = playHbox;
    }

    public ImageView getPreviousIcon() {
        return previousIcon;
    }

    public void setPreviousIcon(ImageView previousIcon) {
        this.previousIcon = previousIcon;
    }

    public ImageView getSearchImage() {
        return searchImage;
    }

    public void setSearchImage(ImageView searchImage) {
        this.searchImage = searchImage;
    }

    public ImageView getSpotify() {
        return spotify;
    }

    public void setSpotify(ImageView spotify) {
        this.spotify = spotify;
    }

    public HBox getThreeMonthHbox() {
        return threeMonthHbox;
    }

    public void setThreeMonthHbox(HBox threeMonthHbox) {
        this.threeMonthHbox = threeMonthHbox;
    }

    public Label getThreeMonthLbl() {
        return threeMonthLbl;
    }

    public void setThreeMonthLbl(Label threeMonthLbl) {
        this.threeMonthLbl = threeMonthLbl;
    }

    public Label getThreeMonthPrice() {
        return threeMonthPrice;
    }

    public void setThreeMonthPrice(Label threeMonthPrice) {
        this.threeMonthPrice = threeMonthPrice;
    }

    public Button getThreeMonthStart() {
        return threeMonthStart;
    }

    public void setThreeMonthStart(Button threeMonthStart) {
        this.threeMonthStart = threeMonthStart;
    }

    public VBox getThreeMonthVbox() {
        return threeMonthVbox;
    }

    public void setThreeMonthVbox(VBox threeMonthVbox) {
        this.threeMonthVbox = threeMonthVbox;
    }

    public ImageView getThreePremiumImage() {
        return threePremiumImage;
    }

    public void setThreePremiumImage(ImageView threePremiumImage) {
        this.threePremiumImage = threePremiumImage;
    }

    public Label getThreePremiumLbl() {
        return threePremiumLbl;
    }

    public void setThreePremiumLbl(Label threePremiumLbl) {
        this.threePremiumLbl = threePremiumLbl;
    }

    public HBox getTwoMonthHbox() {
        return twoMonthHbox;
    }

    public void setTwoMonthHbox(HBox twoMonthHbox) {
        this.twoMonthHbox = twoMonthHbox;
    }

    public Label getTwoMonthLbl() {
        return twoMonthLbl;
    }

    public void setTwoMonthLbl(Label twoMonthLbl) {
        this.twoMonthLbl = twoMonthLbl;
    }

    public Label getTwoMonthPrice() {
        return twoMonthPrice;
    }

    public void setTwoMonthPrice(Label twoMonthPrice) {
        this.twoMonthPrice = twoMonthPrice;
    }

    public Button getTwoMonthStart() {
        return twoMonthStart;
    }

    public void setTwoMonthStart(Button twoMonthStart) {
        this.twoMonthStart = twoMonthStart;
    }

    public VBox getTwoMonthVbox() {
        return twoMonthVbox;
    }

    public void setTwoMonthVbox(VBox twoMonthVbox) {
        this.twoMonthVbox = twoMonthVbox;
    }

    public ImageView getTwoPremiumImage() {
        return twoPremiumImage;
    }

    public void setTwoPremiumImage(ImageView twoPremiumImage) {
        this.twoPremiumImage = twoPremiumImage;
    }

    public Label getTwoPremiumLbl() {
        return twoPremiumLbl;
    }

    public void setTwoPremiumLbl(Label twoPremiumLbl) {
        this.twoPremiumLbl = twoPremiumLbl;
    }

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
            try {
                Singup.listenerController.buyOrRenew(Integer.parseInt(oneMonthPrice.getText()));
            } catch (NotEnoughCredit e) {
                throw new RuntimeException(e);
            }
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
            try {
                Singup.listenerController.buyOrRenew(Integer.parseInt(twoMonthPrice.getText()));
            } catch (NotEnoughCredit e) {
                throw new RuntimeException(e);
            }
        });
        threeMonthStart.setOnMouseClicked(event -> {
            try {
                Singup.listenerController.buyOrRenew(Integer.parseInt(threeMonthPrice.getText()));
            } catch (NotEnoughCredit e) {
                throw new RuntimeException(e);
            }
        });
    }
}
