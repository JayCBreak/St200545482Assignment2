package com.example.st200545482assignment2;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class McSrvResponse {
    private boolean online;
    private String ip;
    private int port;
    private String hostname;
    private String version;
    private String icon;
    @SerializedName("players")
    private ArrayList<ServerPlayerInfo> playerInfo;

    public boolean isOnline() {
        return online;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getHostname() {
        return hostname;
    }

    public String getVersion() {
        return version;
    }

    public String getIcon() {
        return icon;
    }

    public ArrayList<ServerPlayerInfo> getPlayerInfo() {
        return playerInfo;
    }
}
