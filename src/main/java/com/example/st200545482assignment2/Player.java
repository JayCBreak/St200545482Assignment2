package com.example.st200545482assignment2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {
    private String name;
    private String uuid;

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    /**
     * A Method to get a URL of the player's face
     * @return ImageView that leads to a png from the Crafatar API
     */
    public ImageView getIcon() {
        return new ImageView(new Image("https://crafatar.com/avatars/" + uuid));
    }
}
