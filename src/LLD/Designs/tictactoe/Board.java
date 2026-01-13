package LLD.Designs.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Board {
    private int size;
    private PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece piece){
        if(board[row][column]!=null)
            return false;
        board[row][column] = piece;
        return true;
    }

    public List<Pair> getFreeCells(){
        return IntStream.range(0,size)
                .boxed()
                .flatMap(row -> IntStream.range(0,size) // expand row from 0 to size
                        .filter(col -> board[row][col]==null) // filter all positions which are null
                        .mapToObj(col -> new Pair(row,col)))//create pair objects for each position
                .toList(); // add to list
    }

    public void displayBoard(){
        for (int i = 0; i < size; i++) {
            System.out.print(" | ");
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getPieceType().name() + "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }
}
