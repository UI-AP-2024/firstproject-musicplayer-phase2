module org.example.musicplayer_phase2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens org.example.musicplayer_phase2 to javafx.fxml;
    exports org.example.musicplayer_phase2;
    exports org.example.musicplayer_phase2.View;
    opens org.example.musicplayer_phase2.View to javafx.fxml;
    exports org.example.musicplayer_phase2.View.Signingup;
    opens org.example.musicplayer_phase2.View.Signingup to javafx.fxml;
//    exports org.example.musicplayer_phase2.View.Panels;
//    opens org.example.musicplayer_phase2.View.Panels to javafx.fxml;
    exports org.example.musicplayer_phase2.View.SidebarItems;
    opens org.example.musicplayer_phase2.View.SidebarItems to javafx.fxml;
    exports org.example.musicplayer_phase2.View.Informations;
    opens org.example.musicplayer_phase2.View.Informations to javafx.fxml;
    exports org.example.musicplayer_phase2.View.SidebarItems.Buttons;
    opens org.example.musicplayer_phase2.View.SidebarItems.Buttons to javafx.fxml;
    exports org.example.musicplayer_phase2.View.SidebarItems.Labels;
    opens org.example.musicplayer_phase2.View.SidebarItems.Labels to javafx.fxml;

    exports org.example.musicplayer_phase2.View.SidebarItems.Slider;
    opens org.example.musicplayer_phase2.View.SidebarItems.Slider to javafx.fxml;
    exports org.example.musicplayer_phase2.View.Panels.PanelForListener;
    opens org.example.musicplayer_phase2.View.Panels.PanelForListener to javafx.fxml;
    exports org.example.musicplayer_phase2.View.Panels.PnaelForSinger;
    opens org.example.musicplayer_phase2.View.Panels.PnaelForSinger to javafx.fxml;
}