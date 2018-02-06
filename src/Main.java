import shapes.Square;
import shapes.Triangle;
import utils.Colors;

public class Main {

    public static void main(String[] args) {

        Square square = new Square(2, Colors.COLOR_GREEN.toString());
        square.makeCalculations();
//        System.out.println(square.getmSide() + "\n" +
//                            square.getmColor() + "\n" +
//                            square.getmDiagonal() + "\n" +
//                            square.getmPerimeter() + "\n" +
//                            square.getmArea());

        Triangle triangle = new Triangle(5, 9, 7, Colors.COLOR_RED.toString());
        triangle.makeCalculations();
        System.out.println(triangle.getmBase() + "\n" +
                            triangle.getmCathetusOne() + "\n" +
                            triangle.getmCathetusTwo() + "\n" +
                            triangle.getmColor() + "\n" +
                            triangle.getmPerimeter() + "\n" +
                            triangle.getmArea());
    }

}
