
import java.util.Scanner;

/**
 * Esta clase es la lógica del jugador vs jugador.
 * @author sergi
 */
public class LogicGame {

    Board finalBoard = new Board();

    /**
     * Este metodo sirve para verificar si está el mismo simbolo en línea de 3
     * @param board Recibe el tablero como parametro.
     * @param symbol Recibe X o O dependiendo del turno.
     * @return Devuelve true si cumple alguna condicion de victoria.
     */
    public boolean verifyWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol)
                || (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol)
                || (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol)
                || (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol)
                || (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol)
                || (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol)
                || (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
                || (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }
    
    
/**
 * Este metodo sirve para validar si la posicion seleccionada está vacia.
 * @param board Recibe el tablero como parametro.
 * @param position recibe la posicion ingresada por el jugador.
 * @return devuelve true si el espacio en el tablero está vacio.
 */
    public boolean isValidMove(char[][] board, int position) {
        switch (position) {
            case 1:
                return (board[0][0] == ' ');
            case 2:
                return (board[0][1] == ' ');
            case 3:
                return (board[0][2] == ' ');
            case 4:
                return (board[1][0] == ' ');
            case 5:
                return (board[1][1] == ' ');
            case 6:
                return (board[1][2] == ' ');
            case 7:
                return (board[2][0] == ' ');
            case 8:
                return (board[2][1] == ' ');
            case 9:
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    /**
     * Este método sirve para que el jugador eliga una posicion en el tablero 
     * cuando es jugados vs jugador.
     * @param board Recibe el tablero como parametro.
     * @param scanner Recibe el scanner como parametro para leer la posicion.
     */
    public void playerTurn(char[][] board, Scanner scanner) {
        String userInput;

        finalBoard.printBoard(board);
        System.out.println("\"Elige una posición? (1-9)");

        do {
            userInput = scanner.nextLine().trim();
            if (userInput.isEmpty() || !isValidMove(board, Integer.valueOf(userInput))) {
                System.out.println("Por favor elige una casilla válida");
            }
        } while (userInput.isEmpty() || !isValidMove(board, Integer.valueOf(userInput)));

        placeMove(board, Integer.valueOf(userInput), 'X');
    }

    /**
     * Este metodo sirve para añadir el simbolo una vez comprobado que la 
     * posicion está vacía.
     * @param board Recibe el tablero como parametro.
     * @param position Recibe la posicion ingresada por el jugador.
     * @param symbol Recibe el simbolo X o Y dependiendo del caso.
     */
    public void placeMove(char[][] board, int position, char symbol) {
        switch (position) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Espacio inexistente! :(");
        }
    }

    /**
     * Este metodo sirve para comprobar si el juego jugador vs computadora 
     * finaliza.
     * @param board Recibe el tablero como parametro.
     * @return Devuelve true si algun jugador ganó o si no quedan espacios 
     * vacios
     */
    public boolean isGameFinished(char[][] board) {

        Board printB = new Board();

        if (verifyWon(board, 'X')) {
            printB.printBoard(board);
            return true;
        }

        if (verifyWon(board, 'O')) {
            printB.printBoard(board);
            System.out.println("Ganó la computadora");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printB.printBoard(board);
        System.out.println("El juego terminó en empate");
        return true;
    }

     /**
     * Este metodo se utiliza para mostra el tablero en consola.
     *
     * @param board Recibe el tablero como parametro.
     */
    public void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

    /**
     * Este metodo sigue la logica del juego para jugador vs jugador.
     * @param board Recibe el tablero como parametro.
     * @param scanner Recibe el scanner para leer la posicion seleccionada
     * por el jugador.
     * @return Devuelve un entero para utilizarlo en el método principal.
     */
    public int logicTwoPlayers(char[][] board, Scanner scanner) {

        int inputPlayer1;
        int inputPlayer2;

        while (true) {
            System.out.println("Jugador 1, donde queres colocar la X? 1-9");
            inputPlayer1 = scanner.nextInt();
            System.out.println(inputPlayer1);
            if (isValidMove(board, inputPlayer1)) {
                placeMove(board, inputPlayer1, 'X');
                printBoard(board);
                if (verifyWon(board, 'X')) {
                    return 1;
                }
            } else {
                System.out.println(inputPlayer1 + " No es un movimiento válido");
            }
            if (TwoPlayersFinished(board)) {
                return 0;
            }
            System.out.println("Jugador 2, donde queres colocar la O? 1-9");
            inputPlayer2 = scanner.nextInt();
            if (isValidMove(board, inputPlayer2)) {
                placeMove(board, inputPlayer2, 'O');
                printBoard(board);
                if (verifyWon(board, 'O')) {
                    return 2;
                }
            } else {
                System.out.println(inputPlayer2 + " No es un movimiento válido");
            }

        }
    }

    
    /**
     * Este metodo sirve para verificar si el tablero aun tiene posiciones 
     * vacias
     * @param board Recibe el tablero como parametro.
     * @return Devuelve true si el tablero está lleno.
     */
    public boolean TwoPlayersFinished(char[][] board) {

        Board printB = new Board();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printB.printBoard(board);
        return true;
    }
}
