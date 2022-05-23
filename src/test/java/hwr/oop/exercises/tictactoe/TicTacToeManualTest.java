package hwr.oop.exercises.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class TicTacToeManualTest {

    TicTacToe game;
    PrintStream out;
    Scanner in;
    Map<Integer, Character> visualCues;
    int boardSize = 5;
    int scoreA = 0, scoreB = 0;
    boolean playIn3D = true;

    @BeforeEach
    void setUp() {
        game = new TicTacToe(boardSize, playIn3D);
        out = System.out;
        in = new Scanner(System.in);
        initializeVisualCues();
    }

    @Test
    //@Disabled("manual test")
    void playUntilGameOver() {
        int currentTurn;
        do {
            currentTurn = scoreA + scoreB % 2;
            printCurrentStateOfGame();
            while (!game.isGameOver()) {
                playMoveNumber(currentTurn);
                printCurrentStateOfGame();
                currentTurn++;
            }
            restartGame(currentTurn);
        } while (Objects.equals(in.next(), "y"));
    }

    void restartGame(int currentTurn) {
        if(currentTurn % 2 == 0) scoreB++;
        else scoreA++;
        out.println("Game over!");
        out.println(scoreA + ":" + scoreB);
        out.println("Try again? (y/n)");
        game = new TicTacToe(boardSize, playIn3D);
    }

    void initializeVisualCues() {
        visualCues = new HashMap<>();
        visualCues.put(0, '-');
        visualCues.put(1, 'X');
        visualCues.put(2, 'O');
    }

    void playMoveNumber(int turnNumber) {
        boolean firstPlayer = turnNumber % 2 == 0;
        String help = firstPlayer ? "A" : "B";
        out.println("Now Player " + help + "s turn!");
        out.print("X: ");
        int x = in.nextInt();
        out.print("Y: ");
        int y = in.nextInt();
        int z = 0;
        if(playIn3D){
            out.print("Z: ");
            z = in.nextInt();
        }
        out.println("");
        performMoveFor(firstPlayer, x, y, z);
    }

    void performMoveFor(boolean firstPlayer, int x, int y, int z) {
        if (firstPlayer) {
            game.setCross(x, y, z);
        } else {
            game.setCircle(x, y, z);
        }
    }

    void printCurrentStateOfGame() {
        for (int z = 0; z < (playIn3D ? boardSize : 1); z++) {
            out.println("level ("+z+")");
            for (int y = 0; y < boardSize; y++) {
                for (int x = 0; x < boardSize; x++) {
                    int field = game.getValueAt(x, y, z);
                    char stuff = visualCues.get(field);
                    out.print(stuff);
                    out.print(' ');
                }
                out.print('\n');
            }
        }
        out.println();
    }
}
