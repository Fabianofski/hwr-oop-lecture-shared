package hwr.oop.exercises.gameoflife;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class GameOfLifeManualTest {
    private static final int FIELD_WIDTH = 10;
    private static final int FIELD_HEIGHT = 5;

    Scanner in;

    private Game game;
    private Field field;
    private Position[] positions;
    private Cell[] cells;

    @BeforeEach
    void setUp() {
        in = new Scanner(System.in);
        field = new Field(FIELD_WIDTH, FIELD_HEIGHT);
        game = new Game(field);
        initializePositions();
        initializeCells();
    }

    @Test
    //@Disabled("manual test")
    void manualTest() throws InterruptedException {
        inputAliveCellsAtStart();
        while(true) {
            String string = buildConsoleOutput();
            game.proceed();
            System.out.println(string);
            Thread.sleep(2000);
        }
    }

    private void inputAliveCellsAtStart() {
        do {
            System.out.println("Mark cells alive:");
            System.out.print("X:");
            int x = in.nextInt();
            System.out.print("Y:");
            int y = in.nextInt();
            markCellAlive(x,y);
            System.out.println(buildConsoleOutput());

            System.out.println("Mark another cell alive? (y/n)");
        } while (in.next().equals("y"));
    }

    private String buildConsoleOutput() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            boolean newRow = i % FIELD_WIDTH == 0;
            if (newRow) {
                builder.append('\n');
            }
            Cell cell = cells[i];
            boolean isAlive = cell.isAlive();
            builder.append(isAlive ? 'X' : '-');
        }
        builder.append('\n');
        return builder.toString();
    }

    private void initializeCells() {
        cells = new Cell[FIELD_WIDTH * FIELD_HEIGHT];
        int index = 0;
        for (Position position : positions) {
            Cell cell = field.getCellAt(position);
            cells[index] = cell;
            index++;
        }
    }

    private void initializePositions() {
        positions = new Position[FIELD_WIDTH * FIELD_HEIGHT];
        int index = 0;
        for (int y = 0; y < FIELD_HEIGHT; y++) {
            for (int x = 0; x < FIELD_WIDTH; x++) {
                Position p = new Position(x, y);
                positions[index] = p;
                index++;
            }
        }
    }

    private void markCellAlive(int x, int y){
        Cell cell = field.getCellAt(new Position(x,y));
        cell.markAlive();
    }
}
