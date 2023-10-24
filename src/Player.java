
import java.util.Scanner;

public class Player {
    

    private String name;

    private String playerMove;

    private String winPlayerCounter;

    public void playerTurn(char[][] board, Scanner scanner) {
        
        LogicGame player = new LogicGame();

        String userInput;
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            userInput = scanner.nextLine();
            if (player.isValidMove(board, Integer.valueOf(userInput))) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        player.placeMove(board, Integer.valueOf(userInput), 'X');
    }

}
