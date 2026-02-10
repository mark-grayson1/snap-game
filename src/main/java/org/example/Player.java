package org.example;

public class Player {
    String playerName = "";
    int playerNumber = 1;

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerName() {
        return playerName + " " + playerNumber;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
