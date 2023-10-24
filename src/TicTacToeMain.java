
import java.util.Scanner;

public class TicTacToeMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Board finalBoard = new Board();
        LogicGame connector = new LogicGame();
        Computer connectComp = new Computer();
        String respuesta = "S";

        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        System.out.println("Como te gustaria jugar?\n 1. Jugador-Jugador\n 2. Jugador-Computadora");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                int counterPlayer1 = 0;
                int counterPlayer2 = 0;
                System.out.println("Ingrese el nombre del jugador 1:");
                String jugador1 = scanner.next();

                System.out.println("Ingrese el nombre del jugador 2:");
                String jugador2 = scanner.next();

                finalBoard.printBoard(board);

                while (respuesta.equalsIgnoreCase("S")) {

                    int result = connector.logicTwoPlayers(board, scanner);
                    if (result == 1) {
                        System.out.println("Gano " + jugador1);
                        counterPlayer1++;

                    } else {
                        if (result == 2) {
                            System.out.println("Gano " + jugador2);
                            counterPlayer2++;
                        } else {
                            System.out.println("Empate");
                        }
                    }
                    System.out.println("------ Resultados: ------\nVictorias de " + jugador1 + ": " + counterPlayer1 + "\nVictorias de " + jugador2 + ": " + counterPlayer2);

                    System.out.println("--------------------------\nQuiere otra ronda? S/N");
                    respuesta = scanner.next();
                    finalBoard.printNewBoard(board);

                }

                break;
            case 2:

                int playerWinCounter = 0;
                int computerWinCounter = 0;
                System.out.println("Ingrese su nombre:");
                String namePlayer = scanner.next();

                while (respuesta.equalsIgnoreCase("S")) {

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
