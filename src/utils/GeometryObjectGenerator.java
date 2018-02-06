package utils;

import shapes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeometryObjectGenerator {

    //TODO: Replace it later with the Preferences API settings
    //TODO: Look into object creation process

    public static final double MAXIMAL_CIRCLE_RADIUS = 100;
    public static final double MAXIMAL_SQUARE_SIDE_LENGTH = 100;
    public static final double MAXIMAL_TRAPEZOID_SIDE_LENGTH = 100;
    public static final double MAXIMAL_TRIANGLE_SIDE_LENGTH = 100;

    public static List<GeometryObject> listOfGeneratedShapes = new ArrayList<>();

    private GeometryObjectGenerator() {
    }

    public static void generateShape(ShapeNames key){
        switch (key){
            case CIRCLE:
                listOfGeneratedShapes.add(crateCircle());
                //System.out.println("You picked: " + key.toString());
                break;

            case SQUARE:
                listOfGeneratedShapes.add(createSquare());
                //System.out.println("You picked: " + key.toString());
                break;

            case TRIANGE:
                listOfGeneratedShapes.add(createTriangle());
                //System.out.println("You picked: " + key.toString());
                break;

            case TRAPEZOID:
                listOfGeneratedShapes.add(createTrapezoid());
                //System.out.println("You picked: " + key.toString());
                break;

            default:
                System.out.println("Some unexpected error occurred!");
                break;
        }
    }

    public static ShapeNames pickTheShape(){
        List<ShapeNames> listOfShapeNames = new ArrayList<>();
        listOfShapeNames.add(ShapeNames.CIRCLE);
        listOfShapeNames.add(ShapeNames.SQUARE);
        listOfShapeNames.add(ShapeNames.TRAPEZOID);
        listOfShapeNames.add(ShapeNames.TRIANGE);

        //TODO: Enclose it try block after writing custom Error handler
        Random random = new Random();
        int index = random.nextInt(4);
        return listOfShapeNames.get(index);
    }

    private static Circle crateCircle(){
        //Random random = new Random();
        //double generatedRadius = random.nextInt((int) MAXIMAL_CIRCLE_RADIUS) + (1 / random.nextInt(101));
        double generatedRadius = ThreadLocalRandom.current().nextDouble(0.000001, MAXIMAL_CIRCLE_RADIUS);

        return new Circle(generatedRadius, Colors.COLOR_RED.toString());
    }

    private static Square createSquare(){
        //Random random = new Random();
        //double generatedSide = random.nextInt((int) MAXIMAL_SQUARE_SIDE_LENGTH) + (1 / random.nextInt(101));
        double generatedSide = ThreadLocalRandom.current().nextDouble(0.000001, MAXIMAL_SQUARE_SIDE_LENGTH);

        return new Square(generatedSide, Colors.COLOR_RED.toString());
    }

    private static Trapezoid createTrapezoid(){
//        Random random = new Random();
//        double generatedBigBase = random.nextInt((int) MAXIMAL_TRAPEZOID_SIDE_LENGTH) + (1 / random.nextInt(101));
//        double generatedSmallBase = random.nextInt((int) MAXIMAL_TRAPEZOID_SIDE_LENGTH) + (1 / random.nextInt(101));
//        double generatedLeftSide = random.nextInt((int) MAXIMAL_TRAPEZOID_SIDE_LENGTH) + (1 / random.nextInt(101));
//        double generatedRightSide = random.nextInt((int) MAXIMAL_TRAPEZOID_SIDE_LENGTH) + (1 / random.nextInt(101));

        double baseMinimum = 0.000001;

        double generatedSmallBase = ThreadLocalRandom.current().nextDouble(0.000001, MAXIMAL_TRAPEZOID_SIDE_LENGTH);
        double generatedLeftSide = ThreadLocalRandom.current().nextDouble(generatedSmallBase,
                                                                            MAXIMAL_TRAPEZOID_SIDE_LENGTH);
        double generatedRightSide = ThreadLocalRandom.current().nextDouble(generatedSmallBase,
                                                                            MAXIMAL_TRAPEZOID_SIDE_LENGTH);

        if(generatedLeftSide > generatedRightSide){
            baseMinimum = generatedLeftSide;
        }else {
            baseMinimum = generatedRightSide;
        }

        double generatedBigBase = ThreadLocalRandom.current().nextDouble(baseMinimum,
                                                                            MAXIMAL_TRAPEZOID_SIDE_LENGTH);

        return new Trapezoid(generatedBigBase,
                generatedSmallBase,
                generatedLeftSide,
                generatedRightSide,
                Colors.COLOR_RED.toString());
    }

    private static Triangle createTriangle(){
//        Random random = new Random();
//        double generatedBase = random.nextInt((int) MAXIMAL_TRIANGLE_SIDE_LENGTH) + (1 / random.nextInt(101));
//        double generatedCathetusOne = random.nextInt((int) MAXIMAL_TRIANGLE_SIDE_LENGTH) + (1 / random.nextInt(101));
//        double generatedCathetusTwo = random.nextInt((int) MAXIMAL_TRIANGLE_SIDE_LENGTH) + (1 / random.nextInt(101));

        double baseMinimum = 0.000001;
        double baseMaximum = MAXIMAL_TRIANGLE_SIDE_LENGTH;

        double generatedCathetusOne = ThreadLocalRandom.current().nextDouble(0.000001, MAXIMAL_TRIANGLE_SIDE_LENGTH);
        double generatedCathetusTwo = ThreadLocalRandom.current().nextDouble(0.000001, MAXIMAL_TRIANGLE_SIDE_LENGTH);

        if(generatedCathetusOne > generatedCathetusTwo){
            baseMinimum = generatedCathetusOne;
        }else {
            baseMinimum = generatedCathetusTwo;
        }

        if(generatedCathetusOne + generatedCathetusTwo < MAXIMAL_TRIANGLE_SIDE_LENGTH){
            baseMaximum = generatedCathetusOne + generatedCathetusTwo;
        }

        double generatedBase = ThreadLocalRandom.current().nextDouble(baseMinimum, baseMaximum);

        return new Triangle(generatedBase,
                                generatedCathetusOne,
                                generatedCathetusTwo,
                                Colors.COLOR_RED.toString());
    }
}
