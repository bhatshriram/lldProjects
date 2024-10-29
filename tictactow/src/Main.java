import java.util.List;
import java.util.Scanner;
import model.Player;
import model.Symbol;
import service.Board;
import service.TicTacToeGame;

public class Main {

    public static void main(String[] args) {

        boolean isExit=false;

        while(!isExit) {
            Scanner scanner= new Scanner(System.in);
            System.out.println("Enter the game board size:");
            int size= scanner.nextInt();
            System.out.println("Enter the total number of players:");
            int count= scanner.nextInt();

            TicTacToeGame game= new TicTacToeGame(size);
            int i=1;
            while(i<=count) {
                System.out.println("Enter the symbol for "+i+"th player:");
                Symbol symbol= Symbol.valueOf(scanner.next());
                Player player= new Player(String.valueOf(i), "Player"+i, symbol);
                game.addPlayer(player);
                i++;
            }

            System.out.println("Board status:");
            game.getBoard().displayGrid();
            game.playGame();

            System.out.println("Do you want to play again? Please enter y or n:");
            String ans= scanner.next();
            if(ans.equalsIgnoreCase("n")) {
                isExit=true;
            } else if(ans.equalsIgnoreCase("y")) {
                isExit=false;
            } else {
                System.out.println("Invalid input!");
                isExit=true;
            }
        }


    }
}