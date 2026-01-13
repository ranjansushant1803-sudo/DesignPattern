package LLD.Designs.tictactoe;

import java.io.BufferedReader;
import java.io.Reader;

public class TicTacToe {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.startGame());
    }
}
