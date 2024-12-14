package org.example.prj.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.example.prj.HelloApplication;
import org.example.prj.exception.InaccessibilityException;
import org.example.prj.view.Detail;

import java.io.IOException;

public interface GeneralOperations {
    default void backTo (){
        if(!Detail.lastScene.empty())
            HelloApplication.getStage().setScene(Detail.lastScene.pop());
    }

    default void logout () throws IOException {
        if(Detail.login) {
            Detail.lastScene.removeAllElements();
            Detail.login = false;
            if (Detail.listener){
                Detail.listener=false;
                ListenerController.getListenerController().setUserAccount(null);
            }
            else if (Detail.podcaster){
                Detail.podcaster=false;
                ArtistController.getArtistController().setUserAccount(null);
            }
            else if (Detail.singer){
                Detail.singer=false;
                ArtistController.getArtistController().setUserAccount(null);
            }
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home-view.fxml"));
            HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
        }
        else {
            throw new InaccessibilityException();
        }
    }

    default void login () throws IOException {
        if(Detail.login) {
            throw new InaccessibilityException();
        }
        else{
            Detail.lastScene.push(HelloApplication.getStage().getScene());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
            HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
        }
    }

    default void register() throws IOException {
        if(Detail.login){
            throw new InaccessibilityException();
        }else {
            Detail.lastScene.push(HelloApplication.getStage().getScene());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registerType-view.fxml"));
            HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
        }
    }
    default void search(String text) throws IOException {
        Detail.getDetail().search = ListenerController.getListenerController().searchAudioFile(text);
        Detail.lastScene.push(HelloApplication.getStage().getScene());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("search-view.fxml"));
        HelloApplication.getStage().setScene(new Scene(fxmlLoader.load()));
    }

}
