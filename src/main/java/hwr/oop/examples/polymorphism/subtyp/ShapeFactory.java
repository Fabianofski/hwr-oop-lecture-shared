package hwr.oop.examples.polymorphism.subtyp;

import java.util.Arrays;

public class ShapeFactory {

    private double[] sides;
    private double[] angles;

    public Shape CreateShape(double[] sides, double[] angles){
        this.sides = Arrays.stream(sides).distinct().toArray();
        this.angles = Arrays.stream(sides).distinct().toArray();

        if(angles.length < 2){
            if(sides.length == 2 && angles[0] == 90)
                return new Rectangle(this.sides[0], this.sides[1]);
            else if(sides.length == 1 && angles[0] == 90)
                return new Square(sides[0]);
        }
        return null;
    }

}
