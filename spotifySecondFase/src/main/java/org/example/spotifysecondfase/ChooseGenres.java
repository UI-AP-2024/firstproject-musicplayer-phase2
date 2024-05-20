package org.example.spotifysecondfase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import model.Audio.Audio;
import model.Genre;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class ChooseGenres implements Initializable
{
    @FXML
    private ImageView InterviewImage;

    @FXML
    private Label InterviewLbl;

    @FXML
    private ImageView SocietyImage;

    @FXML
    private Label SocietyLbl;

    @FXML
    private VBox SocietyVbox;

    @FXML
    private ImageView TrueCrimeImage;

    @FXML
    private Label TrueCrimeLbl;

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
    private Button btn;

    @FXML
    private ImageView countryImage;

    @FXML
    private Label countryLbl;

    @FXML
    private VBox countryVbox;

    @FXML
    private ImageView coverImage;

    @FXML
    private GridPane gridPane;

    @FXML
    private VBox hboxVbox;

    @FXML
    private ImageView hipHopImage;

    @FXML
    private Label hipHopLbl;

    @FXML
    private ImageView home;

    @FXML
    private ImageView hustoryImage;

    @FXML
    private Label hustoryLbl;

    @FXML
    private VBox hustoryVbox;

    @FXML
    private HBox iconsHbox;

    @FXML
    private ImageView jazzImage;

    @FXML
    private ImageView jazzImage2;

    @FXML
    private Label jazzLbl;

    @FXML
    private Label jazzLbl2;

    @FXML
    private VBox jazzVbox;

    @FXML
    private VBox jazzVbox2;

    @FXML
    private VBox jazzVbox3;

    @FXML
    private VBox jazzVbox6;

    @FXML
    private VBox jazzVbox7;

    @FXML
    private Label lable;

    @FXML
    private ImageView library;

    @FXML
    private ImageView likeImage;

    @FXML
    private ImageView lyrics;

    @FXML
    private ImageView nextIcon;

    @FXML
    private ImageView pauseIcon;

    @FXML
    private HBox playHbox;

    @FXML
    private ImageView popImage;

    @FXML
    private Label popLbl;

    @FXML
    private VBox popVbox;

    @FXML
    private ImageView previousIcon;

    @FXML
    private ImageView rockImage;

    @FXML
    private Label rockLbl;

    @FXML
    private VBox rockVbox;

    @FXML
    private ImageView search;

    @FXML
    private ImageView spotify;

    @FXML
    private VBox vbox;
    @FXML
    private Button backButton1;

    public Button getBackButton1() {
        return backButton1;
    }

    public void setBackButton1(Button backButton1) {
        this.backButton1 = backButton1;
    }

    public ImageView getInterviewImage() {
        return InterviewImage;
    }

    public void setInterviewImage(ImageView interviewImage) {
        InterviewImage = interviewImage;
    }

    public Label getInterviewLbl() {
        return InterviewLbl;
    }

    public void setInterviewLbl(Label interviewLbl) {
        InterviewLbl = interviewLbl;
    }

    public ImageView getSocietyImage() {
        return SocietyImage;
    }

    public void setSocietyImage(ImageView societyImage) {
        SocietyImage = societyImage;
    }

    public Label getSocietyLbl() {
        return SocietyLbl;
    }

    public void setSocietyLbl(Label societyLbl) {
        SocietyLbl = societyLbl;
    }

    public VBox getSocietyVbox() {
        return SocietyVbox;
    }

    public void setSocietyVbox(VBox societyVbox) {
        SocietyVbox = societyVbox;
    }

    public ImageView getTrueCrimeImage() {
        return TrueCrimeImage;
    }

    public void setTrueCrimeImage(ImageView trueCrimeImage) {
        TrueCrimeImage = trueCrimeImage;
    }

    public Label getTrueCrimeLbl() {
        return TrueCrimeLbl;
    }

    public void setTrueCrimeLbl(Label trueCrimeLbl) {
        TrueCrimeLbl = trueCrimeLbl;
    }

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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public ImageView getCountryImage() {
        return countryImage;
    }

    public void setCountryImage(ImageView countryImage) {
        this.countryImage = countryImage;
    }

    public Label getCountryLbl() {
        return countryLbl;
    }

    public void setCountryLbl(Label countryLbl) {
        this.countryLbl = countryLbl;
    }

    public VBox getCountryVbox() {
        return countryVbox;
    }

    public void setCountryVbox(VBox countryVbox) {
        this.countryVbox = countryVbox;
    }

    public ImageView getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(ImageView coverImage) {
        this.coverImage = coverImage;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public VBox getHboxVbox() {
        return hboxVbox;
    }

    public void setHboxVbox(VBox hboxVbox) {
        this.hboxVbox = hboxVbox;
    }

    public ImageView getHipHopImage() {
        return hipHopImage;
    }

    public void setHipHopImage(ImageView hipHopImage) {
        this.hipHopImage = hipHopImage;
    }

    public Label getHipHopLbl() {
        return hipHopLbl;
    }

    public void setHipHopLbl(Label hipHopLbl) {
        this.hipHopLbl = hipHopLbl;
    }

    public ImageView getHome() {
        return home;
    }

    public void setHome(ImageView home) {
        this.home = home;
    }

    public ImageView getHustoryImage() {
        return hustoryImage;
    }

    public void setHustoryImage(ImageView hustoryImage) {
        this.hustoryImage = hustoryImage;
    }

    public Label getHustoryLbl() {
        return hustoryLbl;
    }

    public void setHustoryLbl(Label hustoryLbl) {
        this.hustoryLbl = hustoryLbl;
    }

    public VBox getHustoryVbox() {
        return hustoryVbox;
    }

    public void setHustoryVbox(VBox hustoryVbox) {
        this.hustoryVbox = hustoryVbox;
    }

    public HBox getIconsHbox() {
        return iconsHbox;
    }

    public void setIconsHbox(HBox iconsHbox) {
        this.iconsHbox = iconsHbox;
    }

    public ImageView getJazzImage() {
        return jazzImage;
    }

    public void setJazzImage(ImageView jazzImage) {
        this.jazzImage = jazzImage;
    }

    public ImageView getJazzImage2() {
        return jazzImage2;
    }

    public void setJazzImage2(ImageView jazzImage2) {
        this.jazzImage2 = jazzImage2;
    }

    public Label getJazzLbl() {
        return jazzLbl;
    }

    public void setJazzLbl(Label jazzLbl) {
        this.jazzLbl = jazzLbl;
    }

    public Label getJazzLbl2() {
        return jazzLbl2;
    }

    public void setJazzLbl2(Label jazzLbl2) {
        this.jazzLbl2 = jazzLbl2;
    }

    public VBox getJazzVbox() {
        return jazzVbox;
    }

    public void setJazzVbox(VBox jazzVbox) {
        this.jazzVbox = jazzVbox;
    }

    public VBox getJazzVbox2() {
        return jazzVbox2;
    }

    public void setJazzVbox2(VBox jazzVbox2) {
        this.jazzVbox2 = jazzVbox2;
    }

    public VBox getJazzVbox3() {
        return jazzVbox3;
    }

    public void setJazzVbox3(VBox jazzVbox3) {
        this.jazzVbox3 = jazzVbox3;
    }

    public VBox getJazzVbox6() {
        return jazzVbox6;
    }

    public void setJazzVbox6(VBox jazzVbox6) {
        this.jazzVbox6 = jazzVbox6;
    }

    public VBox getJazzVbox7() {
        return jazzVbox7;
    }

    public void setJazzVbox7(VBox jazzVbox7) {
        this.jazzVbox7 = jazzVbox7;
    }

    public Label getLable() {
        return lable;
    }

    public void setLable(Label lable) {
        this.lable = lable;
    }

    public ImageView getLibrary() {
        return library;
    }

    public void setLibrary(ImageView library) {
        this.library = library;
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

    public ImageView getPopImage() {
        return popImage;
    }

    public void setPopImage(ImageView popImage) {
        this.popImage = popImage;
    }

    public Label getPopLbl() {
        return popLbl;
    }

    public void setPopLbl(Label popLbl) {
        this.popLbl = popLbl;
    }

    public VBox getPopVbox() {
        return popVbox;
    }

    public void setPopVbox(VBox popVbox) {
        this.popVbox = popVbox;
    }

    public ImageView getPreviousIcon() {
        return previousIcon;
    }

    public void setPreviousIcon(ImageView previousIcon) {
        this.previousIcon = previousIcon;
    }

    public ImageView getRockImage() {
        return rockImage;
    }

    public void setRockImage(ImageView rockImage) {
        this.rockImage = rockImage;
    }

    public Label getRockLbl() {
        return rockLbl;
    }

    public void setRockLbl(Label rockLbl) {
        this.rockLbl = rockLbl;
    }

    public VBox getRockVbox() {
        return rockVbox;
    }

    public void setRockVbox(VBox rockVbox) {
        this.rockVbox = rockVbox;
    }

    public ImageView getSearch() {
        return search;
    }

    public void setSearch(ImageView search) {
        this.search = search;
    }

    public ImageView getSpotify() {
        return spotify;
    }

    public void setSpotify(ImageView spotify) {
        this.spotify = spotify;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
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
//    public static VBox vBox(Genre genre)
//    {
//        VBox vBox = new VBox();
//        Label label = new Label();
//        ImageView imageView = genre.getImageView();
//        imageView.setFitHeight(50);
//        imageView.setFitWidth(50);
//        label.setText(genre.name());
//        vBox.getChildren().addAll(imageView,label);
//        vBox.setAlignment(Pos.CENTER);
//        vBox.setSpacing(10);
//        return vBox;
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        music(PlayMusic.audio);
        int counter = 0;
        AtomicInteger chooseGenre = new AtomicInteger();
//        for (int i=0; i<gridPane.getRowCount();i++)
//        {
//            for (int j=0; j<gridPane.getColumnCount(); j++)
//            {
////                Genre genre = Genre.genresArray().get(counter);
//        Genre genre;
////                VBox vBox = vBox(genre);
////                gridPane.add(vBox,i,j);
                jazzImage.setOnMouseClicked(event -> {
                    Genre.addgenres(Genre.JAZZ);
                    jazzVbox.setBorder(Border.stroke(Color.WHITE));
                    chooseGenre.getAndIncrement();
                    jazzImage.setOnMouseClicked(event1 -> {
                        if (jazzVbox.getBorder().getStrokes().equals(Color.WHITE))
                        {
                            jazzVbox.setBorder(Border.stroke(Color.BLACK));
                            chooseGenre.getAndDecrement();
                            Genre.removegenres(Genre.JAZZ);
                        }
                        if (chooseGenre.get() > 4) {
                            try {
                                throw new Exception("You cant choose genres more than four");
                            } catch (Exception e) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setContentText(e.getMessage());
                                alert.showAndWait();
                            }
                        }
                    });
                });
        getInterviewImage().setOnMouseClicked(event -> {
            Genre.addgenres(Genre.INTERVIEW);
            jazzVbox6.setBorder(Border.stroke(Color.WHITE));
            chooseGenre.getAndIncrement();
            getInterviewImage().setOnMouseClicked(event1 -> {
                if (jazzVbox6.getBorder().getStrokes().equals(Color.WHITE))
                {
                    jazzVbox6.setBorder(Border.stroke(Color.BLACK));
                    chooseGenre.getAndDecrement();
                    Genre.removegenres(Genre.INTERVIEW);
                }
                if (chooseGenre.get() > 4) {
                    try {
                        throw new Exception("You cant choose genres more than four");
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText(e.getMessage());
                        alert.showAndWait();
                    }
                }
            });
        });
        getSocietyImage().setOnMouseClicked(event -> {
            Genre.addgenres(Genre.SOCIETY);
            getSocietyVbox().setBorder(Border.stroke(Color.WHITE));
            chooseGenre.getAndIncrement();
            getSocietyImage().setOnMouseClicked(event1 -> {
                if (getSocietyVbox().getBorder().getStrokes().equals(Color.WHITE))
                {
                    getSocietyVbox().setBorder(Border.stroke(Color.BLACK));
                    chooseGenre.getAndDecrement();
                    Genre.removegenres(Genre.SOCIETY);
                }
                if (chooseGenre.get() > 4) {
                    try {
                        throw new Exception("You cant choose genres more than four");
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText(e.getMessage());
                        alert.showAndWait();
                    }
                }
            });
        });
        hipHopImage.setOnMouseClicked(event -> {
            Genre.addgenres(Genre.HIPHOP);
            jazzVbox3.setBorder(Border.stroke(Color.WHITE));
            chooseGenre.getAndIncrement();
            hipHopImage.setOnMouseClicked(event1 -> {
                if (jazzVbox3.getBorder().getStrokes().equals(Color.WHITE))
                {
                    jazzVbox3.setBorder(Border.stroke(Color.BLACK));
                    chooseGenre.getAndDecrement();
                    Genre.removegenres(Genre.HIPHOP);
                }
                if (chooseGenre.get() > 4) {
                    try {
                        throw new Exception("You cant choose genres more than four");
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText(e.getMessage());
                        alert.showAndWait();
                    }
                }
            });
        });
        countryImage.setOnMouseClicked(event -> {
            Genre.addgenres(Genre.COUNTRY);
            countryVbox.setBorder(Border.stroke(Color.WHITE));
            chooseGenre.getAndIncrement();
            countryImage.setOnMouseClicked(event1 -> {
                if (countryVbox.getBorder().getStrokes().equals(Color.WHITE))
                {
                    countryVbox.setBorder(Border.stroke(Color.BLACK));
                    chooseGenre.getAndDecrement();
                    Genre.removegenres(Genre.COUNTRY);
                }
                if (chooseGenre.get() > 4) {
                    try {
                        throw new Exception("You cant choose genres more than four");
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText(e.getMessage());
                        alert.showAndWait();
                    }
                }
            });
        });
        rockImage.setOnMouseClicked(event -> {
            Genre.addgenres(Genre.ROCK);
            rockVbox.setBorder(Border.stroke(Color.WHITE));
            chooseGenre.getAndIncrement();
            rockImage.setOnMouseClicked(event1 -> {
                if (rockVbox.getBorder().getStrokes().equals(Color.WHITE))
                {
                    rockVbox.setBorder(Border.stroke(Color.BLACK));
                    chooseGenre.getAndDecrement();
                    Genre.removegenres(Genre.ROCK);
                }
                if (chooseGenre.get() > 4) {
                    try {
                        throw new Exception("You cant choose genres more than four");
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText(e.getMessage());
                        alert.showAndWait();
                    }
                }
            });
        });
        popImage.setOnMouseClicked(event -> {
            Genre.addgenres(Genre.POP);
            popVbox.setBorder(Border.stroke(Color.WHITE));
            chooseGenre.getAndIncrement();
            popImage.setOnMouseClicked(event1 -> {
                if (popVbox.getBorder().getStrokes().equals(Color.WHITE))
                {
                    popVbox.setBorder(Border.stroke(Color.BLACK));
                    chooseGenre.getAndDecrement();
                    Genre.removegenres(Genre.POP);
                }
                if (chooseGenre.get() > 4) {
                    try {
                        throw new Exception("You cant choose genres more than four");
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText(e.getMessage());
                        alert.showAndWait();
                    }
                }
            });
        });
        getTrueCrimeImage().setOnMouseClicked(event -> {
            Genre.addgenres(Genre.TRUECRIME);
            jazzVbox7.setBorder(Border.stroke(Color.WHITE));
            chooseGenre.getAndIncrement();
            getTrueCrimeImage().setOnMouseClicked(event1 -> {
                if (jazzVbox7.getBorder().getStrokes().equals(Color.WHITE))
                {
                    jazzVbox7.setBorder(Border.stroke(Color.BLACK));
                    chooseGenre.getAndDecrement();
                    Genre.removegenres(Genre.TRUECRIME);
                }
                if (chooseGenre.get() > 4) {
                    try {
                        throw new Exception("You cant choose genres more than four");
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText(e.getMessage());
                        alert.showAndWait();
                    }
                }
            });
        });
        hustoryImage.setOnMouseClicked(event -> {
            Genre.addgenres(Genre.HISTORY);
            hustoryVbox.setBorder(Border.stroke(Color.WHITE));
            chooseGenre.getAndIncrement();
            hustoryImage.setOnMouseClicked(event1 -> {
                if (hustoryVbox.getBorder().getStrokes().equals(Color.WHITE))
                {
                    hustoryVbox.setBorder(Border.stroke(Color.BLACK));
                    chooseGenre.getAndDecrement();
                    Genre.removegenres(Genre.HISTORY);
                }
                if (chooseGenre.get() > 4) {
                    try {
                        throw new Exception("You cant choose genres more than four");
                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText(e.getMessage());
                        alert.showAndWait();
                    }
                }
            });
        });

        getHome().setOnMouseClicked(event -> {
            try {
                ChangeScene.home();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        getAllAudios().setOnMouseClicked(event -> {
            try {
                ChangeScene.allAudios();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        getSearch().setOnMouseClicked(event -> {
            try {
                ChangeScene.search();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        getAllArtists().setOnMouseClicked(event -> {
            try {
                ChangeScene.allArtists();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
