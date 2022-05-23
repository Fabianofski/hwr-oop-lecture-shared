package hwr.oop.exercises.gameoflife;

public class Field {

    Cell[] cellField;
    private final int fieldWidth, fieldHeight;

    public Field(int fieldSize) {
        this(fieldSize, fieldSize);
    }

    public Field(int fieldWidth, int fieldHeight){
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        fillFieldWithCells();
    }

    private void fillFieldWithCells() {
        cellField = new Cell[fieldWidth * fieldHeight];
        for (int x = 0; x < fieldWidth; x++) {
            for (int y = 0; y < fieldHeight; y++) {
                cellField[x + y * fieldWidth] = new Cell(new Position(x,y), this);
            }
        }
    }

    public Cell getCellAt(Position position) {
        return cellField[position.x + position.y * fieldWidth];
    }
}
