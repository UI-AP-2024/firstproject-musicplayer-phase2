module org.example.spotifysecondfase {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires javafx.media;


    opens org.example.spotifysecondfase to javafx.fxml;
    exports org.example.spotifysecondfase.view.Exception;
    opens org.example.spotifysecondfase.view.Exception to javafx.fxml;
    exports org.example.spotifysecondfase;
}