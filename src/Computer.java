
import java.util.Random;

/**
 * Esta clase es la lógica de la computadora
 *
 * @author sergi
 */
public class Computer {

    public int computerMove;

    /**
     * Este método sirve para que la computadora eliga una posicion aleatoria en
     * el tablero.
     *
     * @param board Recibe el tablero como parametro.
     */
    public void computerTurn(char[][] board) {
        Random rand = new Random();
        LogicGame comp = new LogicGame();

        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (comp.isValidMove(board, computerMove)) {
                break;
            }
        }
        System.out.println("----- La increible computadora eligió: " + computerMove + " -----");
        comp.placeMove(board, computerMove, 'O');
    }
}
