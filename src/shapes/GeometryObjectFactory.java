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
        double generatedRadius = ThreadLocalRandom.current().nextDouble(0.000001,
                Constants.CONSTANT_MAXIMAL_CIRCLE_RADIUS);
        return new Circle(generatedRadius, color);
    }

    private static Square createSquare(Colors color){
        double generatedSide = ThreadLocalRandom.current().nextDouble(0.000001,
                Constants.CONSTANT_MAXIMAL_SQUARE_SIDE);
        return new Square(generatedSide, color);
    }

    private static Trapezoid createTrapezoid(Colors color){
        double baseMinimum = 0.000001;

        double generatedSmallBase = ThreadLocalRandom.current().nextDouble(0.000001,
                Constants.CONSTANT_MAXIMAL_TRAPEZOID_SIDE);
        double generatedLeftSide = ThreadLocalRandom.current().nextDouble(generatedSmallBase,
                Constants.CONSTANT_MAXIMAL_TRAPEZOID_SIDE);
        double generatedRightSide = ThreadLocalRandom.current().nextDouble(generatedSmallBase,
                Constants.CONSTANT_MAXIMAL_TRAPEZOID_SIDE);

        if(generatedLeftSide > generatedRightSide){
            baseMinimum = generatedLeftSide;
        }else {
            baseMinimum = generatedRightSide;
        }

        double generatedBigBase = ThreadLocalRandom.current().nextDouble(baseMinimum,
                Constants.CONSTANT_MAXIMAL_TRAPEZOID_SIDE);
        return new Trapezoid(generatedBigBase,
                generatedSmallBase,
                generatedLeftSide,
                generatedRightSide,
                color);
    }

    private static Triangle createTriangle(Colors color){
        double baseMinimum = 0.000001;
        double baseMaximum = Constants.CONSTANT_MAXIMAL_TRIANGLE_SIDE;

        double generatedCathetusOne = ThreadLocalRandom.current().nextDouble(0.000001,
                Constants.CONSTANT_MAXIMAL_TRIANGLE_SIDE);
        double generatedCathetusTwo = ThreadLocalRandom.current().nextDouble(0.000001,
                Constants.CONSTANT_MAXIMAL_TRIANGLE_SIDE);

        if(generatedCathetusOne > generatedCathetusTwo){
            baseMinimum = generatedCathetusOne;
        }else {
            baseMinimum = generatedCathetusTwo;
        }

        if(generatedCathetusOne + generatedCathetusTwo < Constants.CONSTANT_MAXIMAL_TRIANGLE_SIDE){
            baseMaximum = generatedCathetusOne + generatedCathetusTwo;
        }

        double generatedBase = ThreadLocalRandom.current().nextDouble(baseMinimum, baseMaximum);

        return new Triangle(generatedBase,
                                generatedCathetusOne,
                                generatedCathetusTwo,
                                color);
    }
}
