package org.example.prj.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.example.prj.HelloApplication;
import org.example.prj.controller.ListenerController;
import org.example.prj.model.Audio;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FavoriteGenreController implements Initializable {

    @FXML
    private Text NameArtist_text;

    @FXML
    private Text NameMusic_text;

    @FXML
    private Button artists_button;

    @FXML
    private Button audios_button;

    @FXML
    private Button back_button;

    @FXML
    private Button done_button;

    @FXML
    private Text error_text;

    @FXML
    private GridPane gridPain;

    @FXML
    private Button home_button;

    @FXML
    private ImageView image;

    @FXML
    private Button library_button;

    @FXML
    private Button login_button;

    @FXML
    private Button logout_button;

    @FXML
    private Circle next_button;

    @FXML
    private Circle playPause_button;

    @FXML
    private Circle previous_button;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Button register_button;

    @FXML
    private TextField search_Text;

    @FXML
    private Button search_button;

    @FXML
    void artists_Action(ActionEvent event) throws IOException {
        //exception
    }

    @FXML
    void audios_Action(ActionEvent event) throws IOException {
        //exception
    }

    @FXML
    void back_Action(ActionEvent event) {
        //exception
    }

    @FXML
    void home_Action(ActionEvent event) throws IOException {
        //exception
    }

    @FXML
    void library_Action(ActionEvent event) {
        //exception
    }

    @FXML
    void login_Action(ActionEvent event) {
        //exception
    }

    @FXML
    void logout_Action(ActionEvent event) {
        //exception
    }

    @FXML
    void next_Action(MouseEvent event) {
        Audio audio = ListenerController.getListenerController().nextAudioFile();
        playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/pause.png")));
        NameMusic_text.setText(audio.getName());
        NameArtist_text.setText(audio.getNameArtist());
        image.setImage(new Image("file:"+audio.getCover()));
    }

    @FXML
    void playPause_Action(MouseEvent event) {
        if (Detail.getDetail().pause)
            playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/pause.png")));
        else
            playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/play.png")));
        Audio audio = ListenerController.getListenerController().playPauseAudioFile();
        NameMusic_text.setText(audio.getName());
        NameArtist_text.setText(audio.getNameArtist());
        image.setImage(new Image("file:"+audio.getCover()));
    }

    @FXML
    void previous_Action(MouseEvent event) {
        Audio audio = ListenerController.getListenerController().previousAudioFile();
        playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/pause.png")));
        NameMusic_text.setText(audio.getName());
        NameArtist_text.setText(audio.getNameArtist());
        image.setImage(new Image("file:"+audio.getCover()));
    }

    @FXML
    void register_Action(ActionEvent event) {
        //exception
    }

    @FXML
    void search_Action(ActionEvent event) {
        //exception
    }

    private ArrayList<String> al = new ArrayList<>();

    @FXML
    void done_Action(ActionEvent event) throws IOException {
        String result = ListenerController.getListenerController().getGener(al);
        if(result.equals("done successfully")){
            Detail.login = true;
            Detail.listener = true;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
            HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
        }
        else {
            //exception
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> genres = ListenerController.getListenerController().showGener();
        int j=0,i=0;
        gridPain.setAlignment(Pos.CENTER);
        for (String str : genres) {
            Button button = new Button(str);
            button.setStyle("-fx-background-color: #012c2c");
            button.setTextFill(Paint.valueOf("white"));
            gridPain.add(button, j, i);
            gridPain.getChildren().getLast().setOnMouseClicked(e->{
                if(button.getStyle().equals("-fx-background-color: #00c4c8")) {
                    button.setStyle("-fx-background-color: #012c2c");
                    al.remove(str);
                }else{
                    button.setStyle("-fx-background-color: #00c4c8");
                    al.add(str);
                }
            });
            if (j==2){
                i++;
                j=0;
            }
            else
                j++;
        }
        if(Detail.lastScene.empty())
            back_button.setTextFill(Paint.valueOf("ffffff81"));
        if(Detail.getDetail().play)
            playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/pause.png")));
        else
            playPause_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/play.png")));
        next_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/next.png")));
        previous_button.setFill(new ImagePattern(new Image("file:src/main/resources/picture/previous.png")));
    }
}
