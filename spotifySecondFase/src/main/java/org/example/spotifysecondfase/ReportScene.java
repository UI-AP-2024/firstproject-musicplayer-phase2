package org.example.spotifysecondfase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportScene implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button doneBtn;
    public Button getDoneBtn() {return doneBtn;}
    public void setDoneBtn(Button doneBtn) {this.doneBtn = doneBtn;}
    @FXML
    private Label reasonLable;
    @FXML
    private Label reportLable;
    public Label getReportLable() {return reportLable;}
    public void setReportLable(Label reportLable) {this.reportLable = reportLable;}
    ArtistInfo artistInfo;
    static boolean reportSceneBool = true;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Singup.listenerController.description(reportLable.getText(),artistInfo.nameOfArtist);
        doneBtn.setOnMouseClicked(event -> {
            try {
                ChangeScene.artistInfo();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
