package com.example.st200545482assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SceneChanger {
    /**
     * Default changeScene's method from all our other classes.
     * @param event The ActionEvent that is currently running.
     * @param fxmlFileName A String containing the name of an FXML file to load.
     * @throws IOException
     */
    public static void changeScenes(ActionEvent event, String fxmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());
        //get the stage from the ActionEvent
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Allows changing scene's while passing through a List of Player objects to the new scene.
     * @param event The ActionEvent that is currently running.
     * @param fxmlFileName A String containing the name of an FXML file to load.
     * @param playerInfo A List of Player objects that the new scene can use.
     * @throws IOException
     */
    public static void changeScenes(ActionEvent event, String fxmlFileName, ServerPlayerInfo playerInfo) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFileName));
        Scene scene = new Scene(fxmlLoader.load());

        //get the Controller for the destination view and call the "loadPlayers()" method
        PlayerLoader controller = fxmlLoader.getController();
        controller.loadPlayers(playerInfo);

        //get the stage from the ActionEvent
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
