package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.musicap.Controllers.ListenerController;
import org.example.musicap.Controllers.NormalListenerController;
import org.example.musicap.Controllers.PremiumListenerController;
import org.example.musicap.Models.User.Artist;
import org.example.musicap.Models.User.Listener;
import org.example.musicap.Models.User.NormalListener;

import java.util.List;

public class ReportViewController implements ShowAlert {

    @FXML
    private TextArea reportTextArea;
    @FXML
    private AnchorPane mainBody;
    private ListenerController listenerController;
    private Artist artistModel;
    private Listener listenerModel;

    public void customInitialize(Listener listenerModel, Artist artistModel)
    {
        this.artistModel = artistModel;
        this.listenerModel = listenerModel;
        if(listenerModel instanceof NormalListener) listenerController = new NormalListenerController();
        else listenerController = new PremiumListenerController();
    }
    @FXML
    private void addReport(MouseEvent event) {
        String report = reportTextArea.getText();
        showAlert(listenerController.reportArtist(artistModel.getUsername(), report), "Report", "Submission");
        mainBody.getChildren().clear();
    }
}
