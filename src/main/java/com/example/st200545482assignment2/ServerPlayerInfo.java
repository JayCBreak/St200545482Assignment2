package com.example.st200545482assignment2;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ServerPlayerInfo {
    private int online;
    private int max;
    @SerializedName("list")
    private List<Player> playerList;

    public int getOnline() {
        return online;
    }

    public int getMax() {
        return max;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
