import shapes.Circle;
import shapes.Square;
import shapes.Trapezoid;
import shapes.Triangle;
import utils.Colors;

public class Main {

    public static void main(String[] args) {

//        Square square = new Square(2, Colors.COLOR_GREEN.toString());
//        square.makeCalculations();
//        System.out.println(square.getmSide() + "\n" +
//                            square.getmColor() + "\n" +
//                            square.getmDiagonal() + "\n" +
//                            square.getmPerimeter() + "\n" +
//                            square.getmArea());

//        Triangle triangle = new Triangle(5, 9, 7, Colors.COLOR_RED.toString());
//        triangle.makeCalculations();
//        System.out.println(triangle.getmBase() + "\n" +
//                            triangle.getmCathetusOne() + "\n" +
//                            triangle.getmCathetusTwo() + "\n" +
//                            triangle.getmColor() + "\n" +
//                            triangle.getmPerimeter() + "\n" +
//                            triangle.getmArea());

//        Circle circle = new Circle(12, Colors.COLOR_BLUE.toString());
//        circle.makeCalculations();
//        System.out.println(circle.getmRadius() + "\n" +
//                            circle.getmDiameter() + "\n" +
//                            circle.getmColor() + "\n" +
//                            circle.getmLengthOfCircumference() + "\n" +
//                            circle.getmArea());

        Trapezoid trapezoid = new Trapezoid(10, 5, 6, 7 , Colors.COLOR_RED.toString());
        trapezoid.makeCalculations();
        System.out.println(trapezoid.getmColor() + "\n" +
                trapezoid.getmBigBase() + "\n" +
                trapezoid.getmSmallBase() + "\n" +
                trapezoid.getmLeftSide() + "\n" +
                trapezoid.getmRightSide() + "\n" +
                trapezoid.getmHeight() + "\n" +
                trapezoid.getmPerimeter() + "\n" +
                trapezoid.getmArea());

    }

}
