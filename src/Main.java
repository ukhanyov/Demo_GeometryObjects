import shapes.GeometryObject;
import utils.GeometryObjectGenerator;

public class Main {

    public static void main(String[] args) {

        //TODO: Check if constructors are ok

//        Square square = new Square(7, Colors.COLOR_GREEN.toString());
//        square.areTheNumbersRight();
//        square.makeCalculations();
//        System.out.println(square.toString());
//        System.out.println();
//
//
//        Triangle triangle = new Triangle(5, 6, 7, Colors.COLOR_RED.toString());
//        triangle.areTheNumbersRight();
//        triangle.makeCalculations();
//        System.out.println(triangle.toString());
//        System.out.println();
//
//
//        Circle circle = new Circle(12, Colors.COLOR_BLUE.toString());
//        circle.areTheNumbersRight();
//        circle.makeCalculations();
//        System.out.println(circle.toString());
//        System.out.println();
//
//
//        Trapezoid trapezoid = new Trapezoid(10, 5, 6, 7 , Colors.COLOR_RED.toString());
//        trapezoid.areTheNumbersRight();
//        trapezoid.makeCalculations();
//        System.out.println(trapezoid.toString());
//        System.out.println();

        for (int i = 0; i < 10000; i++){
            GeometryObjectGenerator.generateShape(GeometryObjectGenerator.pickTheShape());
        }
        //GeometryObjectGenerator.generateShape(GeometryObjectGenerator.pickTheShape());

        for (GeometryObject item : GeometryObjectGenerator.listOfGeneratedShapes){
            System.out.println(item.toString() + "\n");
        }

            //System.out.println(GeometryObjectGenerator.listOfGeneratedShapes.get(0));


    }

}
