
import java.util.Random;

public class Computer {

    public int computerMove;

    private String winComputerCounter;

    public void computerTurn(char[][] board) {
        Random rand = new Random();
        LogicGame comp = new LogicGame();
        
		
		while (true) {
			computerMove = rand.nextInt(9) + 1;
			if (comp.isValidMove(board, computerMove)) {
				break;
			}
		}
		System.out.println("----- Our incredible computer chose:  " + computerMove+" -----");
		comp.placeMove(board, computerMove, 'O');
	}
    }


