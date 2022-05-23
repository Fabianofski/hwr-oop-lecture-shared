package hwr.oop.exercises.gameoflife;

import java.util.Objects;

public class Position {

    int x,y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isNextTo(Position neighbour) {
        return onAxisNearerThanOne(neighbour.x, x) && onAxisNearerThanOne(neighbour.y, y);
    }

    private boolean onAxisNearerThanOne(int a, int b) {
        return Math.abs(a - b) <= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
