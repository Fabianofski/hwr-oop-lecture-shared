package hwr.oop.examples.polymorphism.subtyp;

public class Isosceles extends Triangle{

    public Isosceles(double c, double ab, double[] angles) {
        super(new double[]{c,ab, ab}, angles);
    }
}
