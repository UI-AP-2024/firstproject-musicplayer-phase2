package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.musicap.HelloApplication;
import org.example.musicap.Models.Data.Database;

import java.io.IOException;

public class LayoutViewController implements GeneralOperation {

    Database database = Database.getInstance();
    @FXML
    private Label loginButton;

    @FXML
    private Label signUpButton;
    @FXML
    private Label logoutButton;

    public Label getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(Label logoutButton) {
        this.logoutButton = logoutButton;
    }

    public Label getBackToButton() {
        return backToButton;
    }

    public void setBackToButton(Label backToButton) {
        this.backToButton = backToButton;
    }

    @FXML
    private Label backToButton;

    @FXML
    private Button searchButton;
    @FXML
    private TextField searchField;

    @FXML
    private Label homeLabel;

    @FXML
    private Label libraryLabel;

    @FXML
    private Label artistsLabel;

    @FXML
    private Label audiosLabel;


    @FXML
    private Button playButton;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @FXML
    private Slider timeSlider;

    @FXML
    private Label nameLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label leftTimeLabel;

    @FXML
    private ImageView audioImage;

    @FXML
    private AnchorPane mainBody;

    public AnchorPane getMainBody() {
        return mainBody;
    }

    public void setMainBody(AnchorPane mainBody) {
        this.mainBody = mainBody;
    }

    public Label getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Label loginButton) {
        this.loginButton = loginButton;
    }

    public Label getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(Label signUpButton) {
        this.signUpButton = signUpButton;
    }

    public Label getHomeLabel() {
        return homeLabel;
    }

    public void setHomeLabel(Label homeLabel) {
        this.homeLabel = homeLabel;
    }

    public Label getLibraryLabel() {
        return libraryLabel;
    }

    public void setLibraryLabel(Label libraryLabel) {
        this.libraryLabel = libraryLabel;
    }

    public Label getArtistsLabel() {
        return artistsLabel;
    }

    public void setArtistsLabel(Label artistsLabel) {
        this.artistsLabel = artistsLabel;
    }

    public Label getAudiosLabel() {
        return audiosLabel;
    }

    public void setAudiosLabel(Label audiosLabel) {
        this.audiosLabel = audiosLabel;
    }

    public TextField getSearchField() {
        return searchField;
    }

    public void setSearchField(TextField searchField) {
        this.searchField = searchField;
    }

    public Button getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(Button searchButton) {
        this.searchButton = searchButton;
    }

    public Button getPlayButton() {
        return playButton;
    }

    public void setPlayButton(Button playButton) {
        this.playButton = playButton;
    }

    public Button getPreviousButton() {
        return previousButton;
    }

    public void setPreviousButton(Button previousButton) {
        this.previousButton = previousButton;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public void setNextButton(Button nextButton) {
        this.nextButton = nextButton;
    }

    public Slider getTimeSlider() {
        return timeSlider;
    }

    public void setTimeSlider(Slider timeSlider) {
        this.timeSlider = timeSlider;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(Label nameLabel) {
        this.nameLabel = nameLabel;
    }

    public Label getTimeLabel() {
        return timeLabel;
    }

    public void setTimeLabel(Label timeLabel) {
        this.timeLabel = timeLabel;
    }

    public Label getLeftTimeLabel() {
        return leftTimeLabel;
    }

    public void setLeftTimeLabel(Label leftTimeLabel) {
        this.leftTimeLabel = leftTimeLabel;
    }

    public ImageView getAudioImage() {
        return audioImage;
    }

    public void setAudioImage(ImageView audioImage) {
        this.audioImage = audioImage;
    }

    public void initialize() throws IOException {
        backToButton.setVisible(false);
        if(database.getLogedInUser() == null) logoutButton.setVisible(false);
        homeLabelClick();
    }
    public void playMusic()
    {

    }
    public void nextMusic()
    {

    }

    public void previousMusic()
    {

    }


    @Override
    public void backTo() {
    }

    @Override
    public void logout() {
        database.setLogedInUser(null);
        logoutButton.setVisible(false);
        signUpButton.setVisible(true);
        loginButton.setVisible(true);
    }

    @Override
    public void login() throws IOException {
        backToButton.setVisible(true);
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        AnchorPane newPane = loader.load();
        mainBody.getChildren().add(newPane);
    }

    @Override
    public void signup() throws IOException {
        backToButton.setVisible(true);
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("signup-view.fxml"));
        AnchorPane newPane = loader.load();
        mainBody.getChildren().add(newPane);
    }

    @Override
    public void search() {

    }

    @Override
    public void navigateToSongPage() {

    }

    public void homeLabelClick() throws IOException {
        backToButton.setVisible(false);
        if(database.getLogedInUser() == null)
        {
            logoutButton.setVisible(false);
            loginButton.setVisible(true);
            signUpButton.setVisible(true);
        }
        else
        {
            logoutButton.setVisible(true);
            loginButton.setVisible(false);
            signUpButton.setVisible(false);
        }
        mainBody.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
        AnchorPane newPane = loader.load();
        mainBody.getChildren().add(newPane);
    }
    public void libraryLabelClick()
    {

    }
    public void artistsLabelClick()
    {

    }
    public void audiosLabelClick()
    {

    }
}
