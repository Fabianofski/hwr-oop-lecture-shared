package hwr.oop.examples.polymorphism.subtyp;

public interface Shape extends Comparable<Shape>{
    double getPerimeterLength();

    double getAreaSize();

    int getNumberOfSides();

    double getInternalAngleSum();

    @Override
    default int compareTo(Shape o) {
        return Double.compare(getAreaSize(), o.getAreaSize());
    }
}
