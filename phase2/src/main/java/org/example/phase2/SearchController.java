package org.example.phase2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.example.phase2.Controller.ListenerController;
import org.example.phase2.Model.Database.Database;
import org.example.phase2.Model.Database.GeneralOperation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable, GeneralOperation {

    @FXML
    private Button back_btn;

    @FXML
    private AnchorPane initialAnchor;

    @FXML
    private Label resultLabel;

    @FXML
    private ImageView search_img;

    @FXML
    private TextField search_tF;

    @FXML
    private TextFlow textFlow;
    private static String searchedPhrase;

    public static String getSearchedPhrase() {
        return searchedPhrase;
    }

    public static void setSearchedPhrase(String searchedPhrase) {
        SearchController.searchedPhrase = searchedPhrase;
    }

    private static Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        SearchController.stage = stage;
    }

    @FXML
    void searchAction(MouseEvent event) throws IOException {
        search();
    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        backTo();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String str=ListenerController.getListenerController().search(searchedPhrase);
        Text text=new Text(str);
        textFlow.getChildren().add(text);
    }

    @Override
    public void backTo() throws IOException {
        FXMLLoader fxmlLoader= Database.getDatabase().getScenes().pop();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle(Database.getDatabase().getTitles().pop());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void logout() throws IOException {

    }

    @Override
    public void login() throws IOException {

    }

    @Override
    public void signup() throws IOException {

    }

    @Override
    public void search() throws IOException {
        String str=ListenerController.getListenerController().search(search_tF.getText());
        searchedPhrase=search_tF.getText();
        Text text=new Text(str);
        textFlow.getChildren().add(text);
    }
}
