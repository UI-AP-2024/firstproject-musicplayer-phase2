module org.example.phase2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.phase2 to javafx.fxml;
    exports org.example.phase2;
}