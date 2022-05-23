package hwr.oop.examples.polymorphism.subtyp;

public class Ellipse implements Shape{

    double width, height;

    public Ellipse(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getPerimeterLength() {
        return Math.PI * (3*width + 2*height - Math.sqrt(width * height));
    }

    @Override
    public double getAreaSize() {
        return Math.PI * width * height;
    }

    @Override
    public int getNumberOfSides() {
        return Integer.MAX_VALUE;
    }

    @Override
    public double getInternalAngleSum() {
        return 360;
    }
}
