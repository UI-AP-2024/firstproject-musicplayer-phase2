package org.example.prj.view;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class SlotOfGridPinAudioView {

    @FXML
    private Text NameArtist_text;

    @FXML
    private ImageView image;

    @FXML
    private Text nameMusic_text;

    public void setData(String artisName, String musicName, String cover){
        image.setImage(new Image(cover));
        NameArtist_text.setText(artisName);
        nameMusic_text.setText(musicName);
    }

}
