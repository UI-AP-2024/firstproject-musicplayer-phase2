package org.example.musicplayer_phase2.View.SidebarItems;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.View.Alerts;
import org.example.musicplayer_phase2.View.Panels.PanelForListener.ListenerPanel;
import org.example.musicplayer_phase2.View.SidebarItems.Buttons.LoginView;
import org.example.musicplayer_phase2.View.SidebarItems.Buttons.Logout;
import org.example.musicplayer_phase2.View.SidebarItems.Labels.AllArtists;
import org.example.musicplayer_phase2.View.SidebarItems.Labels.Audios;
import org.example.musicplayer_phase2.View.SidebarItems.Labels.Home;
import org.example.musicplayer_phase2.View.SidebarItems.Labels.Search;
import org.example.musicplayer_phase2.View.SidebarItems.Slider.PutSlider;
import org.example.musicplayer_phase2.View.Signingup.SignupView;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;
import org.example.musicplayer_phase2.controller.GeneralOperations;
import org.example.musicplayer_phase2.controller.UserAccountController;


public class SidebarMake implements GeneralOperations {

    public SidebarMake() {
        makeActionsForLabelsAndButtons(this);
        sidebarVBox.getChildren().add(new PutSlider().getBaseVBox());
    }

    private Label homeLabel = new Label("HOME");
    private Label artistsLabel = new Label("ARTISTS");
    private Label audiossLabel = new Label("AUDIOS");
    private Label searchLabel = new Label("SEARCH");
    private Label libraryLabel = new Label("LIBRARY");
    //...................................................
    private Button loginButton = new Button("Login");
    private  Button signupButton = new Button("Signup");
    private  Button bakeButton = new Button("back");
    private Button logoutButton = new Button("Logout");
    //....................................................
    private HBox labelHBox = new HBox();
    private VBox sidebarVBox = new VBox();
    public HBox makeSidebar(){
        labelHBox.setPrefSize(570 , 50);
        homeLabel.setPrefSize(120 , 50);
        artistsLabel.setPrefSize(120 , 50);
        audiossLabel.setPrefSize(120 , 50);
        searchLabel.setPrefSize(120 , 50);
        libraryLabel.setPrefSize(120 , 50);
        labelHBox.getChildren().addAll(artistsLabel , audiossLabel , homeLabel , libraryLabel , searchLabel );
        return labelHBox;
    }
    public HBox makeButtons (){
        HBox hBox = new HBox(bakeButton , signupButton , loginButton , logoutButton);
        hBox.setSpacing(10);
        return hBox;
    }
    public VBox getSidebar(){
        sidebarVBox.getChildren().addAll(makeSidebar() , makeButtons());
        sidebarVBox.setPrefSize(600 , 70);
        sidebarVBox.setSpacing(10);
        sidebarVBox.setPadding(new Insets(10));
        return sidebarVBox;
    }
    private void makeActionsForLabelsAndButtons(SidebarMake sidebarMake){
        homeActions(sidebarMake);
        artistsActions(sidebarMake);
        audiosAction(sidebarMake);
        libraryAction(sidebarMake);
        searchAction(sidebarMake);

        loginAction(sidebarMake);
        signupAction(sidebarMake);
        backAction(sidebarMake);
        logoutAction(sidebarMake);
    }
    //labels.............................................
    public void homeActions (SidebarMake sidebarMake){
        sidebarMake.homeLabel.setOnMouseClicked(e -> {
            try{
                Home home = new Home();
                home.start(NecessaryMethods.getStage(e));
            }catch (Exception exception){
                Alerts.errorAlert();
            }

        });
        sidebarMake.homeLabel.setOnMouseEntered(e -> {
            homeLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
        });
        sidebarMake.homeLabel.setOnMouseExited(e -> {
            homeLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
        });
    }

    private void artistsActions (SidebarMake sidebarMake){
        sidebarMake.artistsLabel.setOnMouseClicked(e -> {
            try {
                saveToBackTo(e);
                AllArtists allArtists = new AllArtists();
                allArtists.start(NecessaryMethods.getStage(e));
            } catch (Exception ex) {
                Alerts.errorAlert();
            }
        });

        artistsLabel.setOnMouseEntered(e -> {
            artistsLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
        });
        artistsLabel.setOnMouseExited(e -> {
            artistsLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
        });
    }

    private void audiosAction (SidebarMake sidebarMake){
        sidebarMake.audiossLabel.setOnMouseClicked(e -> {
            try {
                saveToBackTo(e);
                Audios audios = new Audios();
                audios.start(NecessaryMethods.getStage(e));
            } catch (Exception ex) {
                Alerts.errorAlert();
            }
        });

        audiossLabel.setOnMouseEntered(e -> {
            audiossLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
        });
        audiossLabel.setOnMouseExited(e -> {
            audiossLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
        });
    }

    private void libraryAction (SidebarMake sidebarMake){
        sidebarMake.libraryLabel.setOnMouseClicked(e -> {
            if (UserAccountController.listener == null){
                Alerts.nullListener();
            }
            else {
                try {
                    saveToBackTo(e);
                    new ListenerPanel().start(NecessaryMethods.getStage(e));
                } catch (Exception ex) {
                    Alerts.errorAlert();
                }
            }
        });

        libraryLabel.setOnMouseEntered(e -> {
            libraryLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
        });
        libraryLabel.setOnMouseExited(e -> {
            libraryLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
        });
    }

    private void searchAction (SidebarMake sidebarMake){
        sidebarMake.searchLabel.setOnMouseClicked(e -> {
            search(e);
        });

        searchLabel.setOnMouseEntered(e -> {
            searchLabel.setTextFill(AboutStyleSheet.getLabelEnterColor());
        });
        searchLabel.setOnMouseExited(e -> {
            searchLabel.setTextFill(AboutStyleSheet.getLabelExitColor());
        });
    }

    //buttons.........................................
    private void loginAction(SidebarMake sidebarMake){
        sidebarMake.loginButton.setOnMouseClicked(e -> {
            saveToBackTo(e);
            Logout.makeEverybodyNull();
            Stage stage = NecessaryMethods.getStage(e);
            login(stage);
        });
    }

    private void signupAction(SidebarMake sidebarMake){
        sidebarMake.signupButton.setOnMouseClicked(e -> {
            saveToBackTo(e);
            Logout.makeEverybodyNull();
            Stage stage = NecessaryMethods.getStage(e);
            signup(stage);
        });
    }

    private void backAction(SidebarMake sidebarMake){
        sidebarMake.bakeButton.setOnMouseClicked(e -> {
            NecessaryMethods.backToLastPage(e);
        });

    }

    private void logoutAction (SidebarMake sidebarMake){
        sidebarMake.logoutButton.setOnMouseClicked(e ->{
            saveToBackTo(e);
            logout(NecessaryMethods.getStage(e));
        });
    }
    //general operations ..................................
    @Override
    public void saveToBackTo(MouseEvent event) {
        NecessaryMethods.saveLastScene(event);
    }

    @Override
    public void logout(Stage stage) {
        try {
            new Logout().start(stage);
        } catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    @Override
    public void login(Stage stage) {
        try {
            new LoginView().start(stage);
        } catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    @Override
    public void signup(Stage stage) {
        try {
            new SignupView().start(stage);
        } catch (Exception e) {
            Alerts.errorAlert();
        }
    }

    @Override
    public void search(MouseEvent event) {
        try {
            saveToBackTo(event);
            new Search().start(NecessaryMethods.getStage(event));
        } catch (Exception ex) {
            Alerts.errorAlert();
        }
    }
}
