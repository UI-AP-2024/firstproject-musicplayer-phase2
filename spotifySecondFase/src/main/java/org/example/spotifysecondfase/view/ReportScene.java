package org.example.spotifysecondfase.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.example.spotifysecondfase.controller.ListenerController;

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
    ListenerController listenerController;
    ArtistInfo artistInfo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listenerController.description(reportLable.getText(),artistInfo.artistName);
        doneBtn.setOnMouseClicked(event -> {
            try {
                ChangeScene.artistInfo();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
