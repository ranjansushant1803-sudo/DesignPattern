package LLD.Designs.tictactoe;

import java.util.*;

public class Game {

    Board gameBoard;
    Deque<Player> players;

    public Game(){
        gameBoard = new Board(3);
        players = new LinkedList<>();
        PlayingPiece X = new PlayingPieceX();
        Player player1 = new Player("Sushant",X);
        PlayingPiece O = new PlayingPieceO();
        Player player2 = new Player("Bhaskar",O);

        players.add(player1);
        players.add(player2);
    }

    public String startGame(){
        boolean noWinner = true;

        while(noWinner){

            gameBoard.displayBoard();
            Player playerTurn = players.removeFirst();
            List<Pair> availableCells = gameBoard.getFreeCells();
            if(availableCells.isEmpty()){
                noWinner = false;
                continue;
            }

            System.out.println(playerTurn.getPlayerName()+"'s turn. Enter row,column where u want to add your piece");
            Scanner sc = new Scanner(System.in);
            String playerResponse = sc.nextLine();
            if(playerResponse == null){
                throw new RuntimeException("Invalid response");
            }
            String values[] = playerResponse.split(",");
            int row = Integer.parseInt(values[0])-1;
            int col = Integer.parseInt(values[1])-1;
            if(row<0 || row>=gameBoard.getSize() || col<0 || col>= gameBoard.getSize()) {
                throw new RuntimeException("Invalid response");
            }
            boolean pieceAdded = gameBoard.addPiece(row,col,playerTurn.getPiece());
            if(!pieceAdded){//if piece not added
                System.out.println("Incorrect position");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);
            boolean winner = isThereWinner(row,col,playerTurn.getPiece());
            if(winner){
                gameBoard.displayBoard();
                return "Winner is "+playerTurn.getPlayerName();
            }
        }
        return "Its a tie";
    }

    public boolean isThereWinner(int row,int col,PlayingPiece piece){

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for(int i=0;i<gameBoard.getSize();i++){
            if(gameBoard.getBoard()[row][i]==null || gameBoard.getBoard()[row][i]!=piece){
                rowMatch = false;
            }
        }

        for(int i=0;i<gameBoard.getSize();i++){
            if(gameBoard.getBoard()[i][col]==null || gameBoard.getBoard()[i][col]!=piece){
                columnMatch = false;
            }
        }

        for(int i=0;i<gameBoard.getSize();i++){
            if(gameBoard.getBoard()[i][i]==null || gameBoard.getBoard()[i][i]!=piece){
                diagonalMatch = false;
            }
        }

        for(int i=0;i<gameBoard.getSize();i++){
            if(gameBoard.getBoard()[i][gameBoard.getSize()-i-1]==null || gameBoard.getBoard()[i][gameBoard.getSize()-i-1]!=piece){
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
