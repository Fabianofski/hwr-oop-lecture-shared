package hwr.oop.examples.polymorphism.subtyp;

public class Parallelogramm extends Rectangle{

    private final double angleA;
    private final double angleB;
    public Parallelogramm(double width, double height, double angleA, double angleB) {
        super(height, width);
        this.angleA = angleA;
        this.angleB = angleB;
    }

    @Override
    public double[] getDistinctAngles() {
        return new double[]{angleA, angleB};
    }
}