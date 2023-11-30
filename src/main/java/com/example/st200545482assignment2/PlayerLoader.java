package com.example.st200545482assignment2;

public interface PlayerLoader {
    /**
     * Loads the given playerInfo into the view
     * @param playerInfo A ServerPlayerInfo object containing player numbers and data is used for display in the view
     */
    public void loadPlayers(ServerPlayerInfo playerInfo);
}
