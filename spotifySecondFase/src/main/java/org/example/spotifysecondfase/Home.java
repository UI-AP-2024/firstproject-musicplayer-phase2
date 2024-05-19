package org.example.spotifysecondfase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import controller.ListenerController;
import model.Audio.Audio;
import model.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable
{
    @FXML
    private ImageView addToPlaylistImage;

    @FXML
    private Button allArtists;

    @FXML
    private Button allAudios;

    @FXML
    private HBox hbox;

    @FXML
    private HBox hboxForSingOrLog;

    @FXML
    private AnchorPane homeAnchorPane;

    @FXML
    private GridPane homeGridPane;

    @FXML
    private ImageView homeImage;

    @FXML
    private ImageView homeLibrary;

    @FXML
    private VBox homeVbox;

    @FXML
    private Label lable;

    @FXML
    private ImageView likeImage;

    @FXML
    private Button logInOrLogOut;

    @FXML
    private ImageView lyrics;

    @FXML
    private ImageView nextIcon;

    @FXML
    private ImageView pauseIcon;

    @FXML
    private ImageView previousIcon;

    @FXML
    private ImageView searchImage;

    @FXML
    private Button singUp;

    @FXML
    private ImageView spotify;

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

    public HBox getHbox() {
        return hbox;
    }

    public void setHbox(HBox hbox) {
        this.hbox = hbox;
    }

    public HBox getHboxForSingOrLog() {
        return hboxForSingOrLog;
    }

    public void setHboxForSingOrLog(HBox hboxForSingOrLog) {
        this.hboxForSingOrLog = hboxForSingOrLog;
    }

    public AnchorPane getHomeAnchorPane() {
        return homeAnchorPane;
    }

    public void setHomeAnchorPane(AnchorPane homeAnchorPane) {
        this.homeAnchorPane = homeAnchorPane;
    }

    public GridPane getHomeGridPane() {
        return homeGridPane;
    }

    public void setHomeGridPane(GridPane homeGridPane) {
        this.homeGridPane = homeGridPane;
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

    public Label getLable() {
        return lable;
    }

    public void setLable(Label lable) {
        this.lable = lable;
    }

    public ImageView getLikeImage() {
        return likeImage;
    }

    public void setLikeImage(ImageView likeImage) {
        this.likeImage = likeImage;
    }

    public Button getLogInOrLogOut() {
        return logInOrLogOut;
    }

    public void setLogInOrLogOut(Button logInOrLogOut) {
        this.logInOrLogOut = logInOrLogOut;
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

    public ImageView getPreviousIcon() {return previousIcon;}
    public void setPreviousIcon(ImageView previousIcon) {this.previousIcon = previousIcon;}
    public ImageView getSearchImage() {return searchImage;}
    public void setSearchImage(ImageView searchImage) {this.searchImage = searchImage;}
    public Button getSingUp() {return singUp;}
    public void setSingUp(Button singUp) {this.singUp = singUp;}
    public ImageView getSpotify() {return spotify;}
    public void setSpotify(ImageView spotify) {this.spotify = spotify;}
    public Login getLogin() {return login;}
    public void setLogin(Login login) {this.login = login;}

    public VBox vBox(Audio audio)
    {
        String fontFamily = "Arial";
        double fontSize = 12;
        FontWeight fontWeight = FontWeight.SEMI_BOLD;
        Font font=Font.font(fontFamily, fontWeight, fontSize);
        Font font2 = Font.font(fontFamily,fontSize);
        VBox vBox = new VBox();
        Label labelVbox = new Label();
        labelVbox.setFont(font);
        Label labelVbox2 = new Label();
        labelVbox2.setFont(font2);
        ImageView imageView = audio.getCoverImageView();
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        labelVbox.setText(audio.getName());
        labelVbox2.setText(audio.getArtistName());
        vBox.getChildren().addAll(imageView,labelVbox,labelVbox2);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        return vBox;
    }
    Login login = new Login();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int counter = 0;
        if(true)
        {
            singUp.setVisible(false);
            logInOrLogOut.setVisible(false);
//            logInOrLogOut.setText("Log out");
            Button button = new Button(String.valueOf("a"));
//            Button button = new Button(String.valueOf(login.getUserNameTextFeild().getText().charAt(0)));
            button.setFont(Font.font("Arial Bold"));
            Circle circle = new Circle(750,30,10);
            circle.setFill(Color.BLUEVIOLET);
            button.setClip(circle);
            for (int i=0; i<getHomeGridPane().getRowCount(); i++)
            {
                for (int j=0; j<getHomeGridPane().getColumnCount(); j++)
                {
                    //suggested audios
                }
            }
            lable.setText("Suggested audios");
            button.setOnMouseClicked(event -> {
                try {
                    ChangeScene.listenerPanel();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        else {
            Singup.listenerController.ordering();
            lable.setText("Popular audios");
            for (int i=0; i<getHomeGridPane().getRowCount(); i++)
            {
                for (int j=0; j<getHomeGridPane().getColumnCount(); j++)
                {
                    if (Database.getDatabase().getAudio().size() > counter)
                    {
                        VBox vBox = vBox(Database.getDatabase().getAudio().get(counter));
                        getHomeGridPane().add(vBox,i,j);
                    }
                }
            }
        }
        logInOrLogOut.setOnMouseClicked(event -> {
            try {
                ChangeScene.logIn();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        singUp.setOnMouseClicked(event -> {
            try {
                ChangeScene.signup();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
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
    }
}
