package org.example.spotifysecondfase.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.spotifysecondfase.controller.ListenerController;
import org.example.spotifysecondfase.model.Audio.Audio;
import org.example.spotifysecondfase.model.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable
{
    private ListenerController listenerController;
    public ListenerController getListenerController() {return listenerController;}
    public void setListenerController(ListenerController listenerController) {this.listenerController = listenerController;}
    @FXML
    private Button allArtists;
    public Button getAllArtists() {return allArtists;}
    public void setAllArtists(Button allArtists) {this.allArtists = allArtists;}
    @FXML
    private Button allAudios;
    public void setAllAudios(Button allAudios) {this.allAudios = allAudios;}
    public Button getAllAudios() {return allAudios;}
    @FXML
    private AnchorPane homeAnchorPane;
    public AnchorPane getHomeAnchorPane() {return homeAnchorPane;}
    public void setHomeAnchorPane(AnchorPane homeAnchorPane) {this.homeAnchorPane = homeAnchorPane;}
    @FXML
    private GridPane homeGridPane;
    public GridPane getHomeGridPane() {return homeGridPane;}
    public void setHomeGridPane(GridPane homeGridPane) {this.homeGridPane = homeGridPane;}
    @FXML
    private HBox homeHbox;
    public HBox getHomeHbox() {return homeHbox;}
    public void setHomeHbox(HBox homeHbox) {this.homeHbox = homeHbox;}
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
    private ImageView musicCover;
    public ImageView getMusicCover() {return musicCover;}
    public void setMusicCover(ImageView musicCover) {this.musicCover = musicCover;}
    @FXML
    private ImageView nextIcon;
    public ImageView getNextIcon() {return nextIcon;}
    public void setNextIcon(ImageView nextIcon) {this.nextIcon = nextIcon;}
    @FXML
    private ImageView pauseIcon;
    public ImageView getPauseIcon() {return pauseIcon;}
    public void setPauseIcon(ImageView pauseIcon) {this.pauseIcon = pauseIcon;}
    @FXML
    private ImageView previosIcon;
    public ImageView getPreviosIcon() {return previosIcon;}
    public void setPreviosIcon(ImageView previosIcon) {this.previosIcon = previosIcon;}
    @FXML
    private ImageView searchImage;
    public ImageView getSearchImage() {return searchImage;}
    public void setSearchImage(ImageView searchImage) {this.searchImage = searchImage;}
    @FXML
    private Label lable;
    public Label getLable() {return lable;}
    public void setLable(Label lable) {this.lable = lable;}
    @FXML
    private HBox hboxForSingOrLog;
    public HBox getHboxForSingOrLog() {return hboxForSingOrLog;}
    public void setHboxForSingOrLog(HBox hboxForSingOrLog) {this.hboxForSingOrLog = hboxForSingOrLog;}
    @FXML
    private Button logInOrLogOut;
    public Button getLogInOrLogOut() {return logInOrLogOut;}
    public void setLogInOrLogOut(Button logInOrLogOut) {this.logInOrLogOut = logInOrLogOut;}
    @FXML
    private Button singUp;
    public Button getSingUp() {return singUp;}
    public void setSingUp(Button singUp) {this.singUp = singUp;}
    @FXML
    private ImageView spotify;
    public ImageView getSpotify() {return spotify;}
    public void setSpotify(ImageView spotify) {this.spotify = spotify;}
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
    Login login;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int counter = 0;
        if(login.getBool())
        {
            logInOrLogOut.setText("Log out");
            for (int i=0; i<getHomeGridPane().getRowCount(); i++)
            {
                for (int j=0; j<getHomeGridPane().getColumnCount(); j++)
                {
                    //suggested audios
                }
            }
            lable.setText("Suggested audios");
        }
        else {
            listenerController.ordering();
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

        });
    }
}
