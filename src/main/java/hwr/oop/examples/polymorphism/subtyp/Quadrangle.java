package hwr.oop.examples.polymorphism.subtyp;

public interface Quadrangle extends Shape {
    @Override
    default int getNumberOfSides() { return 4; }

    double[] getDistinctAngles();
}
