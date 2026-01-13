package LLD.Designs.tictactoe;

public class Player {
    private String playerName;
    private PlayingPiece piece;

    public Player(String playerName, PlayingPiece piece){
        this.playerName = playerName;
        this.piece = piece;
    }

    public String getPlayerName() {
        return playerName;
    }

    public PlayingPiece getPiece() {
        return piece;
    }
}
