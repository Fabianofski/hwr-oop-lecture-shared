package hwr.oop.exercises.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Field field;
    public Game(Field field) {
        this.field = field;
    }

    public void proceed() {
        List<Cell> cellsAliveNextGeneration = getCellsAliveNextGeneration();
        markNextGenerationAlive(cellsAliveNextGeneration);
    }

    private List<Cell> getCellsAliveNextGeneration() {
        List<Cell> cellsAliveNextGeneration = new ArrayList<>();
        for (Cell cell : field.cellField) {
            if(cell.isAliveNextGeneration()) cellsAliveNextGeneration.add(cell);
        }
        return cellsAliveNextGeneration;
    }

    private void markNextGenerationAlive(List<Cell> aliveCells) {
        for (Cell cell : field.cellField) {
            if(aliveCells.contains(cell))
                cell.markAlive();
            else
                cell.markDead();
        }
    }
}
