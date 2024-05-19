package org.example.spotifysecondfase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import controller.ListenerController;
import model.Playlist;
import model.UserAccount.Artist.Artist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListenerPanel implements Initializable
{
    @FXML
    private ImageView addToPlaylistImage;

    @FXML
    private Button allArtists;

    @FXML
    private Button allAudios;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label dateLbl;

    @FXML
    private Text dateTxt;

    @FXML
    private Label emailLbl;

    @FXML
    private Text emailTxt;

    @FXML
    private Label following;

    @FXML
    private VBox followingVbox;

    @FXML
    private HBox hbox;

    @FXML
    private ImageView homeImage;

    @FXML
    private ImageView homeLibrary;

    @FXML
    private VBox homeVbox;

    @FXML
    private ImageView likeImage;

    @FXML
    private ImageView lyrics;

    @FXML
    private TextField newPlayList;

    @FXML
    private Button newPlayListBtn;

    @FXML
    private ImageView nextIcon;

    @FXML
    private ImageView pauseIcon;

    @FXML
    private Label phoneLbl;

    @FXML
    private Text phoneTxt;

    @FXML
    private VBox playListVbox;

    @FXML
    private Label playLists;

    @FXML
    private Button premiumBtn;

    @FXML
    private ImageView previousIcon;

    @FXML
    private ImageView searchImage;

    @FXML
    private ImageView spotify;

    @FXML
    private VBox textVbox;

    @FXML
    private VBox titleVbox;

    @FXML
    private Label usernameLbl;

    @FXML
    private Text usernameTxt;

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

    public Label getDateLbl() {
        return dateLbl;
    }

    public void setDateLbl(Label dateLbl) {
        this.dateLbl = dateLbl;
    }

    public Text getDateTxt() {
        return dateTxt;
    }

    public void setDateTxt(Text dateTxt) {
        this.dateTxt = dateTxt;
    }

    public Label getEmailLbl() {
        return emailLbl;
    }

    public void setEmailLbl(Label emailLbl) {
        this.emailLbl = emailLbl;
    }

    public Text getEmailTxt() {
        return emailTxt;
    }

    public void setEmailTxt(Text emailTxt) {
        this.emailTxt = emailTxt;
    }

    public Label getFollowing() {
        return following;
    }

    public void setFollowing(Label following) {
        this.following = following;
    }

    public VBox getFollowingVbox() {
        return followingVbox;
    }

    public void setFollowingVbox(VBox followingVbox) {
        this.followingVbox = followingVbox;
    }

    public HBox getHbox() {
        return hbox;
    }

    public void setHbox(HBox hbox) {
        this.hbox = hbox;
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

    public TextField getNewPlayList() {
        return newPlayList;
    }

    public void setNewPlayList(TextField newPlayList) {
        this.newPlayList = newPlayList;
    }

    public Button getNewPlayListBtn() {
        return newPlayListBtn;
    }

    public void setNewPlayListBtn(Button newPlayListBtn) {
        this.newPlayListBtn = newPlayListBtn;
    }

    public ImageView getNextIcon() {
        return nextIcon;
    }

    public void setNextIcon(ImageView nextIcon) {
        this.nextIcon = nextIcon;
    }

    public ImageView getPauseIcon() {
        return pauseIcon;
    }

    public void setPauseIcon(ImageView pauseIcon) {
        this.pauseIcon = pauseIcon;
    }

    public Label getPhoneLbl() {
        return phoneLbl;
    }

    public void setPhoneLbl(Label phoneLbl) {
        this.phoneLbl = phoneLbl;
    }

    public Text getPhoneTxt() {
        return phoneTxt;
    }

    public void setPhoneTxt(Text phoneTxt) {
        this.phoneTxt = phoneTxt;
    }

    public VBox getPlayListVbox() {
        return playListVbox;
    }

    public void setPlayListVbox(VBox playListVbox) {
        this.playListVbox = playListVbox;
    }

    public Label getPlayLists() {
        return playLists;
    }

    public void setPlayLists(Label playLists) {
        this.playLists = playLists;
    }

    public Button getPremiumBtn() {
        return premiumBtn;
    }

    public void setPremiumBtn(Button premiumBtn) {
        this.premiumBtn = premiumBtn;
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

    public VBox getTextVbox() {
        return textVbox;
    }

    public void setTextVbox(VBox textVbox) {
        this.textVbox = textVbox;
    }

    public VBox getTitleVbox() {
        return titleVbox;
    }

    public void setTitleVbox(VBox titleVbox) {
        this.titleVbox = titleVbox;
    }

    public Label getUsernameLbl() {
        return usernameLbl;
    }

    public void setUsernameLbl(Label usernameLbl) {
        this.usernameLbl = usernameLbl;
    }

    public Text getUsernameTxt() {
        return usernameTxt;
    }

    public void setUsernameTxt(Text usernameTxt) {
        this.usernameTxt = usernameTxt;
    }

    Singup singup;
    Button button;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        for (Playlist p : Singup.listenerController.showPlaylist())
        {
            button = new Button(p.getPlayListName());
            button.setBackground(Background.fill(Color.BLACK));
            button.textFillProperty().setValue(Color.WHITE);
            getPlayListVbox().getChildren().add(button);
        }
        button.setOnMouseClicked(event -> {
            try {
                ChangeScene.playListAudios();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        newPlayListBtn.setOnMouseClicked(event -> {
            Singup.listenerController.makePlaylist(newPlayList.getText());
        });
        for (Artist a : Singup.listenerController.showFollowing())
        {
            Button button = new Button(a.getName());
            button.setBackground(Background.fill(Color.BLACK));
            button.textFillProperty().setValue(Color.WHITE);
            followingVbox.getChildren().add(button);
        }
        usernameTxt.setText(singup.getUserNameTextField().getText());
        emailTxt.setText(singup.getEmailTextField().getText());
        phoneTxt.setText(singup.getPhoneTextField().getText());
        dateTxt.setText(singup.getYear()+"/"+singup.getMonth().getText()+"/"+singup.getDay());
        homeImage.setOnMouseClicked(event -> {
            try {
                ChangeScene.home();
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
        premiumBtn.setOnMouseClicked(event -> {
            try {
                ChangeScene.subscription();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
