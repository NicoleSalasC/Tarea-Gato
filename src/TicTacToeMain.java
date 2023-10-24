
import java.util.Scanner;

public class TicTacToeMain {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Board finalBoard = new Board();
        LogicGame connector = new LogicGame();
        Computer connectComp = new Computer();

        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        System.out.println("Como te gustaria jugar?\n 1. Jugador-Jugador\n 2. Jugador-Computadora");
        String opcion = scanner.next();

        switch (opcion) {
            case "1":
                System.out.println("Ingrese el nombre del jugador 1:");
                String jugador1 = scanner.next();

                System.out.println("Ingrese el nombre del jugador 2:");
                String jugador2 = scanner.next();

                finalBoard.printBoard(board);

          
                    connector.logicTwoPlayers(board, scanner);
                    if (connector.verifyWon(board, 'X')) {
                        System.out.println(jugador1 + " ha ganado! :D");

                        finalBoard.printBoard(board);
                        break;
                    }else if(connector.verifyWon(board, 'O')){
                        System.out.println(jugador2 + " ha ganado! :D");

                        finalBoard.printBoard(board);
                        break;
                    }else{
                     System.out.println("The game ended in a tie!");

                    
                    }
                  
                
            case "2":

                int playerWinCounter = 0;
                int computerWinCounter = 0;
                System.out.println("Ingrese su nombre:");
                String namePlayer = scanner.next();
                String respuesta = "S";
                
                while(respuesta.equalsIgnoreCase("S")){
                    
                    finalBoard.printNewBoard(board);

                    while (true) {
                        System.out.println("---------------------");
                        connector.playerTurn(board, scanner);
                        if (connector.isGameFinished(board)) {
                            System.out.println(namePlayer + " wins! yay! :D");
                            playerWinCounter++;
                            break;
                        }

                        System.out.println("---------------------");

                        connectComp.computerTurn(board);
                        if (connector.isGameFinished(board)) {
                            computerWinCounter++;
                            break;
                        }
                        finalBoard.printBoard(board);
                    }
                    System.out.println("------ Resultados: ------\nTus victorias: " + playerWinCounter + "\nVictorias de la computadora: " + computerWinCounter);

                    System.out.println("--------------\nQuiere otra ronda? S/N");
                    respuesta = scanner.next();
                }
                break;
            default:
                System.out.println("Opcion invalida");
        }

    }
}
