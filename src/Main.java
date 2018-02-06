import shapes.Circle;
import shapes.Square;
import shapes.Trapezoid;
import shapes.Triangle;
import utils.Colors;

public class Main {

    public static void main(String[] args) {

        Square square = new Square(2, Colors.COLOR_GREEN.toString());
        square.makeCalculations();
        System.out.println(square.toString());
        System.out.println();


        Triangle triangle = new Triangle(5, 9, 7, Colors.COLOR_RED.toString());
        triangle.makeCalculations();
        System.out.println(triangle.toString());
        System.out.println();


        Circle circle = new Circle(12, Colors.COLOR_BLUE.toString());
        circle.makeCalculations();
        System.out.println(circle.toString());
        System.out.println();


        Trapezoid trapezoid = new Trapezoid(10, 5, 6, 7 , Colors.COLOR_RED.toString());
        trapezoid.makeCalculations();
        System.out.println(trapezoid.toString());
        System.out.println();


    }

}
