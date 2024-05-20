package org.example.spotifysecondfase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Audio.Audio;
import model.Playlist;
import model.UserAccount.Artist.Artist;
import org.example.spotifysecondfase.view.Exception.FreeAccountLimit;

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
    private Label artistName;

    @FXML
    private Label audioName;

    @FXML
    private Button backButton;

    @FXML
    private ImageView coverImage;

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
    private Button logOutBtn;

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
    private HBox playHbox;

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

    public Button getLogOutBtn() {
        return logOutBtn;
    }

    public void setLogOutBtn(Button logOutBtn) {
        this.logOutBtn = logOutBtn;
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

    public HBox getPlayHbox() {
        return playHbox;
    }

    public void setPlayHbox(HBox playHbox) {
        this.playHbox = playHbox;
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

    Media media;
    MediaPlayer mediaPlayer;
    String playPath = HelloApplication.class.getResource("play.png").toExternalForm();
    Image play = new Image(playPath);
    String pausePath = HelloApplication.class.getResource("play.png").toExternalForm();
    Image pause = new Image(pausePath);
    int i;
    public void music(Audio audio)
    {
        i = PlayMusic.playlists.indexOf(audio);
        media = new Media(audio.getAudioLink());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        pauseIcon.setOnMouseClicked(event -> {
            if (pauseIcon.getImage() == play)
            {
                pauseIcon.setImage(pause);
                mediaPlayer.play();
            }
            if (pauseIcon.getImage() == pause)
            {
                pauseIcon.setImage(play);
                mediaPlayer.pause();
            }
        });
        nextIcon.setOnMouseClicked(event -> {
            if (i < PlayMusic.playlists.size()-1)
            {
                media = new Media(PlayMusic.playlists.get(i+1).getAudioLink());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
                i++;
                audioName.setText(PlayMusic.playlists.get(i).getName());
                artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                nextIcon.setOnMouseClicked(event1 -> {
                    if (i < PlayMusic.playlists.size()-1)
                    {
                        media = new Media(PlayMusic.playlists.get(i+1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i++;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                    else if (i == PlayMusic.playlists.size()-1)
                    {
                        media = new Media(PlayMusic.playlists.get(0).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i = 0;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                });
            }
            else if (i == PlayMusic.playlists.size()-1)
            {
                media = new Media(PlayMusic.playlists.get(0).getAudioLink());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
                i = 0;
                audioName.setText(PlayMusic.playlists.get(i).getName());
                artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                nextIcon.setOnMouseClicked(event1 -> {
                    if (i<PlayMusic.playlists.size()-1)
                    {
                        media = new Media(PlayMusic.playlists.get(i+1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i++;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                    else if (i==PlayMusic.playlists.size()-1)
                    {
                        media = new Media(PlayMusic.playlists.get(0).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i = 0;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                });
            }
        });
        previousIcon.setOnMouseClicked(event -> {
            if (i>0)
            {
                media = new Media(PlayMusic.playlists.get(i-1).getAudioLink());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
                i--;
                audioName.setText(PlayMusic.playlists.get(i).getName());
                artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                previousIcon.setOnMouseClicked(event1 -> {
                    if(i>0)
                    {
                        media = new Media(PlayMusic.playlists.get(i-1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i--;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                    else {
                        media = new Media(PlayMusic.playlists.get(PlayMusic.playlists.size()-1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i = PlayMusic.playlists.size()-1;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());

                    }
                });
            }
            else {
                media = new Media(PlayMusic.playlists.get(PlayMusic.playlists.size()-1).getAudioLink());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
                i = PlayMusic.playlists.size()-1;
                audioName.setText(PlayMusic.playlists.get(i).getName());
                artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                previousIcon.setOnMouseClicked(event1 -> {
                    if(i>0)
                    {
                        media = new Media(PlayMusic.playlists.get(i-1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i--;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());
                    }
                    else {
                        media = new Media(PlayMusic.playlists.get(PlayMusic.playlists.size()-1).getAudioLink());
                        mediaPlayer = new MediaPlayer(media);
                        mediaPlayer.play();
                        i = PlayMusic.playlists.size()-1;
                        audioName.setText(PlayMusic.playlists.get(i).getName());
                        artistName.setText(PlayMusic.playlists.get(i).getArtistName());
                        coverImage.setImage(PlayMusic.playlists.get(i).getImage());

                    }
                });
            }
        });
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
            try {
                Singup.listenerController.makePlaylist(newPlayList.getText());
            } catch (FreeAccountLimit e) {
                throw new RuntimeException(e);
            }
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
