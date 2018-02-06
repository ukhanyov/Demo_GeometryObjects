package shapes;

import utils.Colors;
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

    public static GeometryObject generateShape(ShapeNames key){
        switch (key){
            case CIRCLE:
                return crateCircle();

            case SQUARE:
                return createSquare();

            case TRIANGE:
                return createTriangle();

            case TRAPEZOID:
                return createTrapezoid();

            default:
                //TODO: Insert Error handler message
                break;
        }
        return null;
    }

    private static Circle crateCircle(){
        double generatedRadius = ThreadLocalRandom.current().nextDouble(0.000001, MAXIMAL_CIRCLE_RADIUS);
        return new Circle(generatedRadius, Colors.COLOR_RED.toString());
    }

    private static Square createSquare(){
        double generatedSide = ThreadLocalRandom.current().nextDouble(0.000001, MAXIMAL_SQUARE_SIDE_LENGTH);
        return new Square(generatedSide, Colors.COLOR_RED.toString());
    }

    private static Trapezoid createTrapezoid(){
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
