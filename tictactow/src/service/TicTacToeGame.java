package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Player;

public class TicTacToeGame {

    private final Board board;
    private List<Player> players;
    private Player activePlayer;

    public TicTacToeGame(int boardSize) {
        this.players=new ArrayList<>();
        board= new Board(boardSize);
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void playGame() {
        this.activePlayer=players.get(0);

        while(!board.isDraw()) {
            System.out.println("Enter the position for player "+activePlayer.getPlayerName()+
                " for symbol "+activePlayer.getSymbol());
            Scanner scanner= new Scanner(System.in);
            int i= scanner.nextInt();
            int j= scanner.nextInt();

            board.assignCell(i, j, activePlayer);

            if(board.isWin()) {
                System.out.println("Match win by "+activePlayer.getPlayerName());
                board.displayGrid();
                break;
            }

            board.displayGrid();
            this.activePlayer= players.stream().filter(a-> a!=activePlayer).findFirst().get();
        }

        if(board.isDraw()) {
            System.out.println("Draw Game!");
        }
    }
}
