package shapes;

import utils.ShapeNames;

import java.util.concurrent.ThreadLocalRandom;

public class GeometryObjectFactory {

    //TODO: Replace it later with the Preferences API settings
    //TODO: Look into object creation process

    private static final double MAXIMAL_CIRCLE_RADIUS = 100;
    private static final double MAXIMAL_SQUARE_SIDE_LENGTH = 100;
    private static final double MAXIMAL_TRAPEZOID_SIDE_LENGTH = 100;
    private static final double MAXIMAL_TRIANGLE_SIDE_LENGTH = 100;

    private GeometryObjectFactory() {
    }

    public static GeometryObject generateShape(ShapeNames key, String color){
        switch (key){
            case CIRCLE:
                return crateCircle(color, key.toString());

            case SQUARE:
                return createSquare(color, key.toString());

            case TRIANGE:
                return createTriangle(color, key.toString());

            case TRAPEZOID:
                return createTrapezoid(color, key.toString());

            default:
                //TODO: Insert Error handler message
                break;
        }
        return null;
    }

    private static Circle crateCircle(String color, String name){
        double generatedRadius = ThreadLocalRandom.current().nextDouble(0.000001, MAXIMAL_CIRCLE_RADIUS);
        return new Circle(generatedRadius, color, name);
    }

    private static Square createSquare(String color, String name){
        double generatedSide = ThreadLocalRandom.current().nextDouble(0.000001, MAXIMAL_SQUARE_SIDE_LENGTH);
        return new Square(generatedSide, color, name);
    }

    private static Trapezoid createTrapezoid(String color, String name){
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
                color,
                name);
    }

    private static Triangle createTriangle(String color, String name){
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
                                color,
                                name);
    }
}
