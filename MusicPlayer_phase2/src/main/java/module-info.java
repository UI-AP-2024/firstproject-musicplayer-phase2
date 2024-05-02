module org.example.musicplayer_phase2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.musicplayer_phase2 to javafx.fxml;
    exports org.example.musicplayer_phase2;
}