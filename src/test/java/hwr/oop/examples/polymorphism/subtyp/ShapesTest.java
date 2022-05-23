package hwr.oop.examples.polymorphism.subtyp;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShapesTest {

    @Nested
    class SquareTest {
        @Test
        void square_IsPolymorphicType() {
            Shape square = new Square(42);
            assertThat(square)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Rectangle.class)
                    .isInstanceOf(Square.class);
        }

        @Test
        void squareIsRectangle_ButRectangleIsNoSquare() {
            Shape square = new Square(42);
            Shape rectangle = new Rectangle(13, 37);
            assertThat(square).isInstanceOf(Rectangle.class);
            assertThat(rectangle).isNotInstanceOf(Square.class);
        }

        @Test
        void square_GetPerimeterLength_IsFourTimesProvidedSize() {
            Shape square = new Square(42);
            double perimeterLength = square.getPerimeterLength();
            assertThat(perimeterLength).isEqualTo(4 * 42);
        }

        @Test
        void square_GetAreaSize_IsSideLengthSquared() {
            Shape square = new Square(42);
            double areaSize = square.getAreaSize();
            assertThat(areaSize).isEqualTo(42 * 42);
        }

        @Test
        void square_GetNumberOfSides_ReturnsFour() {
            Shape square = new Square(42);
            int numberOfSides = square.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(4);
        }
    }

    @Nested
    class RectangleTest {
        @Test
        void rectangle_IsPolymorphicType() {
            Rectangle rectangle = new Rectangle(42, 1337);
            assertThat(rectangle)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Rectangle.class);
        }

        @Test
        void rectangle_GetPerimeterLength_IsFourTimesProvidedSize() {
            Shape rectangle = new Rectangle(42, 1337);
            double perimeterLength = rectangle.getPerimeterLength();
            assertThat(perimeterLength).isEqualTo(42 + 42 + 1337 + 1337);
        }

        @Test
        void rectangle_GetAreaSize_IsSideLengthSquared() {
            Shape rectangle = new Rectangle(1337, 42);
            double areaSize = rectangle.getAreaSize();
            assertThat(areaSize).isEqualTo(42 * 1337);
        }

        @Test
        void rectangle_GetNumberOfSides_ReturnsFour() {
            Shape rectangle = new Rectangle(42, 1337);
            int numberOfSides = rectangle.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(4);
        }

        @Test
        void quadrangle_comparable() {
            Comparable<Shape> first = new Rectangle(1, 2);
            Comparable<Shape> second = new Rectangle(1, 2);

        }
    }

    @Nested
    class RhombusTest{
        @Test
        void rhombus_IsPolymorphicType() {
            Rhombus rhombus = new Rhombus(42, 45, 135);
            assertThat(rhombus)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Rectangle.class)
                    .isInstanceOf(Parallelogramm.class)
                    .isInstanceOf(Rhombus.class);
        }

        @Test
        void rhombus_GetPerimeterLength_IsFourTimesProvidedSize() {
            Shape rhombus = new Rhombus(42, 45, 135);
            double perimeterLength = rhombus.getPerimeterLength();
            assertThat(perimeterLength).isEqualTo(42+42+42+42);
        }

        @Test
        void rhombus_GetAreaSize_IsSideLengthSquared() {
            Shape rhombus = new Rhombus(42, 45, 135);
            double areaSize = rhombus.getAreaSize();
            assertThat(areaSize).isEqualTo(42*42);
        }

        @Test
        void rhombus_GetNumberOfSides_ReturnsFour() {
            Shape rhombus = new Rhombus(42, 45, 135);
            int numberOfSides = rhombus.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(4);
        }

        @Test
        void quadrangle_comparable() {
            Comparable<Shape> first = new Rhombus(42, 45, 135);
            Comparable<Shape> second = new Rhombus(42, 45, 135);

        }
    }

    @Nested
    class ParallelogrammTest{
        @Test
        void parallelogramm_IsPolymorphicType() {
            Parallelogramm parallelogramm = new Parallelogramm(42, 1337, 45, 135);
            assertThat(parallelogramm)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Rectangle.class)
                    .isInstanceOf(Parallelogramm.class);
        }

        @Test
        void parallelogramm_GetPerimeterLength_IsSumOfProvidedSides() {
            Shape parallelogramm = new Parallelogramm(42,1337, 45, 135);
            double perimeterLength = parallelogramm.getPerimeterLength();
            assertThat(perimeterLength).isEqualTo(42+42+1337+1337);
        }

        @Test
        void parallelogramm_GetAreaSize_IsSideLengthsMultiplied() {
            Shape parallelogramm = new Parallelogramm(42,1337, 45, 135);
            double areaSize = parallelogramm.getAreaSize();
            assertThat(areaSize).isEqualTo(42*1337);
        }

        @Test
        void parallelogramm_GetNumberOfSides_ReturnsFour() {
            Shape parallelogramm = new Parallelogramm(42, 1337, 45, 135);
            int numberOfSides = parallelogramm.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(4);
        }

        @Test
        void quadrangle_comparable() {
            Comparable<Shape> first = new Parallelogramm(42,1337, 45, 135);
            Comparable<Shape> second = new Parallelogramm(42,1337, 45, 135);

        }
    }

    @Nested
    class TrapezTest {
        @Test
        void trapez_IsPolymorphicType() {
            Trapez trapez = new Trapez(new double[]{2,2,2,2}, new double[]{45,45,135,135});
            assertThat(trapez)
                    .isInstanceOf(Object.class)
                    .isInstanceOf(Shape.class)
                    .isInstanceOf(Quadrangle.class)
                    .isInstanceOf(Trapez.class);
        }

        @Test
        void trapez_GetPerimeterLength_IsSumOfProvidedSides() {
            Shape trapez = new Trapez(new double[]{8,2.82d,3,2.82d}, new double[]{45,45,135,135});
            double perimeterLength = trapez.getPerimeterLength();
            assertThat(perimeterLength).isEqualTo(8+3+2.82d*2);
        }

        @Test
        void trapez_GetAreaSize_IsSideLengthSquared() {
            Shape trapez = new Trapez(new double[]{8,2.82d,3,2.82d}, new double[]{45,45,135,135});
            double areaSize = trapez.getAreaSize();
            assertThat(areaSize).isEqualTo(0);
        }

        @Test
        void trapez_GetNumberOfSides_ReturnsFour() {
            Shape trapez = new Trapez(new double[]{8,2.82d,3,2.82d}, new double[]{45,45,135,135});
            int numberOfSides = trapez.getNumberOfSides();
            assertThat(numberOfSides).isEqualTo(4);
        }

        @Test
        void quadrangle_comparable() {
            Comparable<Shape> first = new Trapez(new double[]{8,2.82d,3,2.82d}, new double[]{45,45,135,135});
            Comparable<Shape> second = new Trapez(new double[]{8,2.82d,3,2.82d}, new double[]{45,45,135,135});

        }
    }

    @Nested
    class EllipseTest{

    }

    @Nested
    class CircleTest{

    }
}
