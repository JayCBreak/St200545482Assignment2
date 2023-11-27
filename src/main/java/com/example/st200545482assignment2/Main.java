package com.example.st200545482assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/*IN CASE YOU MISSED TE BLACKBOARD COMMENT
* If you do not have a minecraft server of your own....which is likely, you can use one of the following or others
* My server: systembreak.xyz
* Popular Public Server Hypixel: mc.hypixel.net
*
* Optional: specify a port by appending :25565 or otherwise to the end of the IP BUT the API will also auto find it
*/



public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Minecraft Server Lookup!");
        stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("images/icon.png"))));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}