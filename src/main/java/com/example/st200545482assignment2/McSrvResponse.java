package com.example.st200545482assignment2;

import com.google.gson.annotations.SerializedName;

public class McSrvResponse {
    private boolean online;
    private String ip;
    private int port;
    private String hostname;
    private String version;
    private String icon;
    @SerializedName("players")
    private ServerPlayerInfo playerInfo;

    /**
     * Get if a server is currently online or not.
     * @return The boolean variable online.
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * Get the IP of the server requested.
     * @return A String variable containing the IP.
     */
    public String getIp() {
        return ip;
    }

    /**
     * Get the port of the server requested.
     * @return An int variable containing the port number.
     */
    public int getPort() {
        return port;
    }

    /**
     * Get the hostname of the server if it has one.
     * @return A String variable containing the hostname.
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Get the Minecraft version required to connect to the server.
     * @return A String variable containing the version number of the server.
     */
    public String getVersion() {
        return version;
    }

    /**
     * Get the icon that is shown to players to connect to the server.
     * @return A String containing a base64 encoded PNG of the server's icon.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Get an object that has information about the current players on the server.
     * @return A ServerPlayerInfo object containing currently online players and the server's maximum
     */
    public ServerPlayerInfo getPlayerInfo() {
        return playerInfo;
    }
}
