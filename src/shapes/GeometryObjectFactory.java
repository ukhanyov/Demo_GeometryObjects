package shapes;

import utils.Colors;
import utils.Constants;
import utils.ShapeNames;

import java.util.concurrent.ThreadLocalRandom;

public class GeometryObjectFactory {

    private GeometryObjectFactory() {
    }

    public static GeometryObject generateShape(ShapeNames key, Colors color){
        switch (key){
            case CIRCLE:
                return crateCircle(color);

            case SQUARE:
                return createSquare(color);

            case TRIANGE:
                return createTriangle(color);

            case TRAPEZOID:
                return createTrapezoid(color);

            default:
                throw new IllegalArgumentException("Wrong type of Shape object in the Shape Factory");
        }
    }

    private static Circle crateCircle(Colors color){
        double generatedRadius = ThreadLocalRandom.current().nextDouble(Constants.CONSTANT_MIN_CIRCLE_RADIUS,
                Constants.CONSTANT_MAX_CIRCLE_RADIUS);
        return new Circle(generatedRadius, color);
    }

    private static Square createSquare(Colors color){
        double generatedSide = ThreadLocalRandom.current().nextDouble(Constants.CONSTANT_MIN_SQUARE_SIDE,
                Constants.CONSTANT_MAX_SQUARE_SIDE);
        return new Square(generatedSide, color);
    }

    private static Trapezoid createTrapezoid(Colors color){

        double generatedSmallBase = ThreadLocalRandom.current().nextDouble(
                Constants.CONSTANT_MIN_TRAPEZOID_SIDE,
                Constants.CONSTANT_MAX_TRAPEZOID_SIDE);
        double generatedLeftSide = ThreadLocalRandom.current().nextDouble(
                Constants.CONSTANT_MIN_TRAPEZOID_SIDE,
                generatedSmallBase);
        double generatedRightSide = ThreadLocalRandom.current().nextDouble(
                Constants.CONSTANT_MIN_TRAPEZOID_SIDE,
                generatedSmallBase);


        double generatedBigBase = ThreadLocalRandom.current().nextDouble(generatedSmallBase,
                Constants.CONSTANT_MAX_TRAPEZOID_SIDE);
        return new Trapezoid(generatedBigBase,
                generatedSmallBase,
                generatedLeftSide,
                generatedRightSide,
                color);
    }

    private static Triangle createTriangle(Colors color){
        double baseMinimum = Constants.CONSTANT_MIN_TRIANGLE_SIDE;
        double baseMaximum = Constants.CONSTANT_MAX_TRIANGLE_SIDE;

        double generatedCathetusOne = ThreadLocalRandom.current().nextDouble(Constants.CONSTANT_MIN_TRIANGLE_SIDE,
                Constants.CONSTANT_MAX_TRIANGLE_SIDE);
        double generatedCathetusTwo = ThreadLocalRandom.current().nextDouble(Constants.CONSTANT_MIN_TRIANGLE_SIDE,
                Constants.CONSTANT_MAX_TRIANGLE_SIDE);

        if(generatedCathetusOne > generatedCathetusTwo){
            baseMinimum = generatedCathetusOne;
        }else {
            baseMinimum = generatedCathetusTwo;
        }

        if(generatedCathetusOne + generatedCathetusTwo < Constants.CONSTANT_MAX_TRIANGLE_SIDE){
            baseMaximum = generatedCathetusOne + generatedCathetusTwo;
        }

        double generatedBase = ThreadLocalRandom.current().nextDouble(baseMinimum, baseMaximum);

        return new Triangle(generatedBase,
                                generatedCathetusOne,
                                generatedCathetusTwo,
                                color);
    }
}
