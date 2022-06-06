package hwr.oop.examples.polymorphism.subtyp;

import java.util.Arrays;

public class ShapeFactory {

    public Shape CreateShape(double[] sides, double[] angles){
        double[] distinct_sides = Arrays.stream(sides).distinct().toArray();
        double[] distinct_angles = Arrays.stream(angles).distinct().toArray();

        if(sides.length == 4 && distinct_angles[0] == 90){
            if(distinct_sides.length == 2)
                return new Rectangle(distinct_sides[0], distinct_sides[1]);
            else if(distinct_sides.length == 1)
                return new Square(distinct_sides[0]);
            else
                return new Rectangular(sides, distinct_angles[0], distinct_angles[1]);
        }

        if(sides.length == 3){
            if(distinct_angles.length == 1)
                return new Equilateral(distinct_sides[0], distinct_angles[0]);
            else if (distinct_sides.length == 2 && distinct_angles.length == 2)
                return new Isosceles(distinct_sides[0], distinct_sides[1], angles);
            else
                return new Triangle(sides, angles);
        }

        return null;
    }

}
