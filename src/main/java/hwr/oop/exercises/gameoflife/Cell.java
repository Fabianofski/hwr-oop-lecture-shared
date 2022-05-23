package hwr.oop.exercises.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    Position position;
    Field field;
    boolean isAlive;
    
    public Cell(Position position, Field field) {
        this.position = position;
        this.field = field;
    }

    public Cell[] getNeighbours() {
        List<Cell> neighbours = new ArrayList<>();
        Cell[] cellField = field.cellField;

        for (Cell cell : cellField) {
            Position cellPosition = cell.position;
            if(cellPosition.isNextTo(position) && !cellPosition.equals(position)){
                neighbours.add(cell);
            }
        }
        return neighbours.toArray(Cell[]::new);
    }

    public boolean isAliveNextGeneration() {
        Cell[] cells = getNeighbours();
        int count = 0;
        for (Cell cell : cells) {
            if(cell.isAlive) count++;
        }

        return (count == 2 && isAlive) || count == 3;
    }

    public Position getPosition() {
        return position;
    }

    public void markAlive() {
        isAlive = true;
    }

    public void markDead(){ isAlive = false; }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isDead() {
        return !isAlive;
    }

}