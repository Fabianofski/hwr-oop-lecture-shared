package hwr.oop.examples.polymorphism.subtyp;

public class Rectangular extends Triangle{
    public Rectangular(double[] sides, double angleA, double angleB) {
        super(sides, new double[]{angleA, angleB, 90});
    }
}
