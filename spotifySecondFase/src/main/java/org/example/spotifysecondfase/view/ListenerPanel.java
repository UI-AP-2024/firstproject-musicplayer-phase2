package org.example.spotifysecondfase.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.example.spotifysecondfase.controller.ListenerController;
import org.example.spotifysecondfase.model.Playlist;
import org.example.spotifysecondfase.model.UserAccount.Artist.Artist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListenerPanel implements Initializable
{
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
    public AnchorPane getAnchorPane() {return anchorPane;}
    public void setAnchorPane(AnchorPane anchorPane) {this.anchorPane = anchorPane;}
    @FXML
    private Label following;
    public Label getFollowing() {return following;}
    public void setFollowing(Label following) {this.following = following;}
    @FXML
    private VBox followingVbox;
    public VBox getFollowingVbox() {return followingVbox;}
    public void setFollowingVbox(VBox followingVbox) {this.followingVbox = followingVbox;}
    @FXML
    private ImageView homeImage;
    public ImageView getHomeImage() {return homeImage;}
    public void setHomeImage(ImageView homeImage) {this.homeImage = homeImage;}
    @FXML
    private ImageView homeLibrary;
    public ImageView getHomeLibrary() {return homeLibrary;}
    public void setHomeLibrary(ImageView homeLibrary) {this.homeLibrary = homeLibrary;}
    @FXML
    private VBox homeVbox;
    public VBox getHomeVbox() {return homeVbox;}
    public void setHomeVbox(VBox homeVbox) {this.homeVbox = homeVbox;}
    @FXML
    private Button newPlayListBtn;
    public Button getNewPlayListBtn() {return newPlayListBtn;}
    public void setNewPlayListBtn(Button newPlayListBtn) {this.newPlayListBtn = newPlayListBtn;}
    @FXML
    private VBox playListVbox;
    public VBox getPlayListVbox() {return playListVbox;}
    public void setPlayListVbox(VBox playListVbox) {this.playListVbox = playListVbox;}
    @FXML
    private Label playLists;
    public Label getPlayLists() {return playLists;}
    public void setPlayLists(Label playLists) {this.playLists = playLists;}
    @FXML
    private Button premiumBtn;
    public Button getPremiumBtn() {return premiumBtn;}
    public void setPremiumBtn(Button premiumBtn) {this.premiumBtn = premiumBtn;}
    @FXML
    private ImageView searchImage;
    public ImageView getSearchImage() {return searchImage;}
    public void setSearchImage(ImageView searchImage) {this.searchImage = searchImage;}
    @FXML
    private ImageView spotify;
    public ImageView getSpotify() {return spotify;}
    public void setSpotify(ImageView spotify) {this.spotify = spotify;}
    @FXML
    private Label phoneLbl;
    public Label getPhoneLbl() {return phoneLbl;}
    public void setPhoneLbl(Label phoneLbl) {this.phoneLbl = phoneLbl;}
    @FXML
    private Text phoneTxt;
    public Text getPhoneTxt() {return phoneTxt;}
    public void setPhoneTxt(Text phoneTxt) {this.phoneTxt = phoneTxt;}
    @FXML
    private VBox textVbox;
    public VBox getTextVbox() {return textVbox;}
    public void setTextVbox(VBox textVbox) {this.textVbox = textVbox;}
    @FXML
    private VBox titleVbox;
    public VBox getTitleVbox() {return titleVbox;}
    public void setTitleVbox(VBox titleVbox) {this.titleVbox = titleVbox;}
    @FXML
    private Label usernameLbl;
    public Label getUsernameLbl() {return usernameLbl;}
    public void setUsernameLbl(Label usernameLbl) {this.usernameLbl = usernameLbl;}
    @FXML
    private Text usernameTxt;
    public Text getUsernameTxt() {return usernameTxt;}
    public void setUsernameTxt(Text usernameTxt) {this.usernameTxt = usernameTxt;}
    @FXML
    private Label emailLbl;
    public Label getEmailLbl() {return emailLbl;}
    public void setEmailLbl(Label emailLbl) {this.emailLbl = emailLbl;}
    @FXML
    private Text emailTxt;
    public Text getEmailTxt() {return emailTxt;}
    public void setEmailTxt(Text emailTxt) {this.emailTxt = emailTxt;}
    @FXML
    private Label dateLbl;
    public Label getDateLbl() {return dateLbl;}
    public void setDateLbl(Label dateLbl) {this.dateLbl = dateLbl;}
    @FXML
    private Text dateTxt;
    public Text getDateTxt() {return dateTxt;}
    public void setDateTxt(Text dateTxt) {this.dateTxt = dateTxt;}
    ListenerController listenerController;
    Singup singup;
    private Button button;
    public Button getButton() {return button;}
    public void setButton(Button button) {this.button = button;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        for (Playlist p : listenerController.showPlaylist())
        {
            button = new Button(p.getPlayListName());
            getButton().setBackground(Background.fill(Color.BLACK));
            getButton().textFillProperty().setValue(Color.WHITE);
            getPlayListVbox().getChildren().add(getButton());
        }
        button.setOnMouseClicked(event -> {
            try {
                ChangeScene.playListAudios();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        newPlayListBtn.setOnMouseClicked(event -> {
            //make playlist
        });
        for (Artist a : listenerController.showFollowing())
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

    }
}
