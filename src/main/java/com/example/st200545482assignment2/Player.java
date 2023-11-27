package com.example.st200545482assignment2;

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
     * @return Crafatar URL that leads to a png
     */
    public String getIconFromUuid() {
        return "https://crafatar.com/avatars/" + uuid;
    }
}
