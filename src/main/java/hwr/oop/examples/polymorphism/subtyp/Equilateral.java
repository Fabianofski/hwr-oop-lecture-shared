package hwr.oop.examples.polymorphism.subtyp;

public class Equilateral extends Triangle{
    public Equilateral(double side, double angle) {
        super(new double[]{side, side, side}, new double[]{angle, angle});
    }
}
