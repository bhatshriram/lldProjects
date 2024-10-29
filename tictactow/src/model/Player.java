package model;

public class Player {

    private String playerId;
    private String playerName;
    private Symbol symbol;

    public Player(String id, String name, Symbol symbol) {
        this.playerId=id;
        this.playerName=name;
        this.symbol=symbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
