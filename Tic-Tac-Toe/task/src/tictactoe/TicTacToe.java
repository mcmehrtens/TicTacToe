package tictactoe;

import java.util.Scanner;

public class TicTacToe {
    private GameState currentState;
    private Character[][] board;
    private Scanner scanner;
    private int numX;
    private int numY;
    private int num_;

    public TicTacToe(Scanner scanner) {
        this.scanner = scanner;
        currentState = GameState.READY;
        board = new Character[3][3];

        numX = 0;
        numY = 0;
        num_ = 9;

        // Fill the board with space characters
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    /* Prints the board and sets the GameState to X_TURN */
    public void startGame() {
        printBoard();
        setCurrentState(GameState.X_TURN);
    }

    /* Prints the board to the screen + the frame */
    private void printBoard() {
        System.out.println("---------");
        System.out.println("| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |");
        System.out.println("| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |");
        System.out.println("| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |");
        System.out.println("---------");
    }

    /* Processes input from the user;
     * checks to make sure the input is valid */
    public void getInput() {
        System.out.print("Enter the coordinates: ");
        String in = scanner.nextLine();
        in = in.trim();
        char[] inputArray = in.toCharArray();

        // Checks to see if the user has inputted words
        if (inputArray.length != 3 || !Character.isDigit(inputArray[0]) || inputArray[1] != ' ' || !Character.isDigit(inputArray[2])) {
            System.out.println("You should enter numbers!");
            return;
        }

        int x = Integer.parseInt(Character.toString(inputArray[0]));
        int y = Integer.parseInt(Character.toString(inputArray[2]));

        if (x < 1 || x > 3 || y < 1 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return;
        }

        markBoard(currentState == GameState.X_TURN ? 'X' : 'O', x, y);
    }

    private void markBoard(Character mark, int x, int y) {
        int i = 0;
        int j = 0;
        /* Convert the coordinates to i and j for the TicTacToe board */
        if (x == 1) j = 0;
        if (x == 2) j = 1;
        if (x == 3) j = 2;
        if (y == 1) i = 2;
        if (y == 2) i = 1;
        if (y == 3) i = 0;

        if (board[i][j] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return;
        } else {
            board[i][j] = mark;
        }

        if (mark == 'X') {
            numX++;
        } else {
            numY++;
        }

        num_--;

        printBoard();
        if (checkVictory(currentState == GameState.X_TURN ? 'X' : 'O')) {
            System.out.println((currentState == GameState.X_TURN ? 'X' : 'O') + " wins");
            setCurrentState(GameState.FINISHED);
        } else if (num_ == 0) {
            System.out.println("Draw");
            setCurrentState(GameState.FINISHED);
        } else {
            setCurrentState(currentState == GameState.X_TURN ? GameState.O_TURN : GameState.X_TURN);
        }
    }

    /* Checks to see if there is a victory
     * returns true if a victory was found */
    private boolean checkVictory(Character c) {
        // Check rows for victory
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c) {
                return true;
            }
        }

        // Check columns for victory
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == c && board[1][i] == c && board[2][i] == c) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == c && board[1][1] == c && board[2][2] == c) return true;
        if (board[0][2] == c && board[1][1] == c && board[2][0] == c) return true;

        return false;
    }

    /* Set GameState */
    public void setCurrentState(GameState state) {
        currentState = state;
    }

    /* Get GameState */
    public GameState getCurrentState() {
        return currentState;
    }
}
