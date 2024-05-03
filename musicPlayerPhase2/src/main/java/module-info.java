module org.example.musicplayerphase2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.musicplayerphase2 to javafx.fxml;
    exports org.example.musicplayerphase2;
}