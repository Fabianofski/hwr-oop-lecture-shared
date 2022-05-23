package hwr.oop.examples.polymorphism.subtyp;

import java.util.Arrays;

public class Trapez implements Quadrangle {

    double[] angles;
    double[] sides;
    public Trapez(double[] sides, double[] angles) {
        this.sides = sides;
        this.angles = angles;
    }

    @Override
    public double[] getDistinctAngles() {
        return Arrays.stream(angles).distinct().toArray();
    }

    @Override
    public double getPerimeterLength() {
        return Arrays.stream(sides).sum();
    }

    @Override
    public double getAreaSize() {
        return 0;
    }

    @Override
    public double getInternalAngleSum() {
        return Arrays.stream(angles).sum();
    }
}
