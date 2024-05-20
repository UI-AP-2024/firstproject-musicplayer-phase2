module org.example.phase2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens org.example.phase2 to javafx.fxml;
    exports org.example.phase2;
}