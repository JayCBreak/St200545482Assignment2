package com.example.st200545482assignment2;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ServerPlayerInfo {
    private int online;
    private int max;
    @SerializedName("list")
    private List<Player> playerList;

    /**
     * Get the number of players online right now.
     * @return An int of the number of players on the server currently.
     */
    public int getOnline() {
        return online;
    }

    /**
     * Get the total number of players allowed to join.
     * @return An int of the total number of players allowed on the server at any given time.
     */
    public int getMax() {
        return max;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
