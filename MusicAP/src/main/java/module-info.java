module org.example.musicap {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.musicap to javafx.fxml;
    exports org.example.musicap;
    exports org.example.musicap.GUIs to javafx.fxml;
    opens org.example.musicap.GUIs to javafx.fxml;
}