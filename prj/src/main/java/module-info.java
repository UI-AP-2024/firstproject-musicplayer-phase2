module org.example.prj {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    exports org.example.prj;
    exports org.example.prj.view to javafx.fxml;

    opens org.example.prj.view to javafx.fxml;
}
