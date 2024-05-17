package org.example.musicplayer_phase2.View.SidebarItems.Slider;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.musicplayer_phase2.controller.AboutView.AboutStyleSheet;
import org.example.musicplayer_phase2.controller.AboutView.NecessaryMethods;

public class PutSlider extends Application{
    private static Slider slider = new Slider();
    private Label play_pauseMusicLabel = new Label("PLAY");
    private Label nextLabel = new Label("NEXT");
    private Label lastLabel = new Label("LAST");
    private HBox hBoxForLabels = new HBox(lastLabel , play_pauseMusicLabel , nextLabel);
    private VBox baseVBox = new VBox(slider , hBoxForLabels);
    public VBox getBaseVBox() {
        makingReady();
        return baseVBox;
    }

    private void makingReady(){
        hBoxForLabels.setSpacing(20);
        hBoxForLabels.setAlignment(Pos.CENTER);

        nextLabel.setPrefSize(50 , 25);
        lastLabel.setPrefSize(50 , 25);
        play_pauseMusicLabel.setPrefSize(75 , 25);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(getBaseVBox() , 600 , 450);
        AboutStyleSheet.putStyleSheet(scene);
        stage.setScene(scene);
        stage.show();
    }
}
