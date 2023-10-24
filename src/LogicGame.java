
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author n
 */
public class LogicGame {
   
    Board finalBoard = new Board();
    
    //Logica para verificar si está el mismo simbolo en línea de 3
    public  boolean verifyWon(char[][] board, char symbol) {
		if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
			(board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
			(board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
			(board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
			(board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
			
			(board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
			(board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
			return true;
		}
		return false;
	}
    
    public boolean isValidMove (char[][] board, String position) {
		switch(position) {
			case "1":
                            //Return true si el espacio está vacio, de lo contrario devuelve false y da el mensaje
				return (board[0][0] == ' ');
			case "2":
				return (board[0][1] == ' ');
			case "3":
				return (board[0][2] == ' ');
			case "4":
				return (board[1][0] == ' ');
			case "5":
				return (board[1][1] == ' ');
			case "6":
				return (board[1][2] == ' ');
			case "7":
				return (board[2][0] == ' ');
			case "8":
				return (board[2][1] == ' ');
			case "9":
				return (board[2][2] == ' ');
			default:
				return false;
		}
	}

	public void playerTurn(char[][] board, Scanner scanner) {
		 String userInput;
                 
finalBoard.printBoard(board);
 System.out.println("Where would you like to play? (1-9)");

    do {
        userInput = scanner.nextLine().trim();
        if (userInput.isEmpty() || !isValidMove(board, userInput)) {
            System.out.println("Please enter a valid move.");
        }
    } while (userInput.isEmpty() || !isValidMove(board, userInput));

    placeMove(board, userInput, 'X');
}
    
        public void placeMove(char[][] board, String position, char symbol) {
		switch(position) {
			case "1":
				board[0][0] = symbol;
				break;
			case "2":
				board[0][1] = symbol;
				break;
			case "3":
				board[0][2] = symbol;
				break;
			case "4":
				board[1][0] = symbol;
				break;
			case "5":
				board[1][1] = symbol;
				break;
			case "6":
				board[1][2] = symbol;
				break;
			case "7":
				board[2][0] = symbol;
				break;
			case "8":
				board[2][1] = symbol;
				break;
			case "9":
				board[2][2] = symbol;
				break;
			default:
				System.out.println("Espacio inexistente! :(");
		}
	}
        
        public boolean isGameFinished(char[][] board) {
		
            Board printB = new Board();
            
		if (verifyWon(board, 'X')) {	
			printB.printBoard(board);
			return true;
		}
		
		if (verifyWon(board, 'O')) {	
			printB.printBoard(board);
			System.out.println("Computer wins!");
			return true;
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
                                        //Ver video para explicar este for 
				}
			}
		}
		printB.printBoard(board);
		System.out.println("The game ended in a tie!");
		return true;
	}
        
    public void logicTwoPlayers(char[][] board, Scanner scanner) {

        String inputPlayer1;
        String inputPlayer2;

            while (true) {

                System.out.println("Donde queres colocar tu simbolo? (1-9)");
                inputPlayer1 = scanner.nextLine();
                if (isValidMove(board, inputPlayer1)) {
                    break;
                } else {
                    System.out.println(inputPlayer1 + " is not a valid move.");
                }
            
            placeMove(board, inputPlayer1, 'X');
            
            
            System.out.println("Donde queres colocar tu simbolo? (1-9)");
            inputPlayer2 = scanner.nextLine();
            if (isValidMove(board, inputPlayer2)) {
            } else {
                System.out.println(inputPlayer2 + " is not a valid move.");
            }
        
        placeMove(board, inputPlayer2, 'O');
            }
    }

    public boolean TwoPlayersFinished(char[][] board) {

        Board printB = new Board();

        if (verifyWon(board, 'X')) {
            printB.printBoard(board);
            return true;
        }

        if (verifyWon(board, 'O')) {
            printB.printBoard(board);
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                    //Ver video para explicar este for 
                }
            }
        }
        printB.printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }
}
