package hwr.oop.examples.polymorphism.subtyp;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Triangle implements Shape{

    double[] sides;
    double[] angles;

    public Triangle(double[] sides, double[] angles) {
        this.sides = sides;
        this.angles = angles;
    }

    @Override
    public double getPerimeterLength() {
        return Arrays.stream(sides).sum();
    }

    @Override
    public double getAreaSize() {
        double height = 1;
        double c = 0;
        for (double side : sides) {
            if(side > c) c = side;
        }
        return c * height * 0.5d;
    }

    @Override
    public int getNumberOfSides() {
        return 3;
    }

    @Override
    public double getInternalAngleSum() {
        return 180;
    }
}
