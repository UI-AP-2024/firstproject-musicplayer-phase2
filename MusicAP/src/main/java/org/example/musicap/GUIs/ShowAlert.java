package org.example.musicap.GUIs;

import javafx.scene.control.Alert;

public interface ShowAlert {

    default void showAlert(String message, String title, String header)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
