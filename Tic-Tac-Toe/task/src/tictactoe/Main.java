package tictactoe;

import java.util.Scanner;

public class Main {
    /* Execute program;
     * loop the getInput() function until GameState == FINISHED */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TicTacToe game = new TicTacToe(scanner);
        game.startGame();
        while (game.getCurrentState() != GameState.FINISHED) {
            game.getInput();
        }
    }
}