package shapes;

import utils.Colors;
import utils.Constants;
import utils.ShapeNames;

import java.util.concurrent.ThreadLocalRandom;

public class GeometryObjectFactory {

    private GeometryObjectFactory() {
    }

    /** Handles creation of a GeometryObject
     *
     * @param key Object's shape
     * @param color Object's color
     * @return GeometryObject
     */
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

    /** Handles creation of a Circle shape with random radius
     *
     * @param color Desired color of the shape
     * @return Circle object
     */
    private static Circle crateCircle(Colors color){
        double generatedRadius = ThreadLocalRandom.current().nextDouble(Constants.CONSTANT_MIN_CIRCLE_RADIUS,
                Constants.CONSTANT_MAX_CIRCLE_RADIUS);
        return new Circle(generatedRadius, color);
    }

    /** Handles creation of a Circle shape with random side length
     *
     * @param color Desired color of the shape
     * @return Square object
     */
    private static Square createSquare(Colors color){
        double generatedSide = ThreadLocalRandom.current().nextDouble(Constants.CONSTANT_MIN_SQUARE_SIDE,
                Constants.CONSTANT_MAX_SQUARE_SIDE);
        return new Square(generatedSide, color);
    }

    /** Handles creation of a Trapezoid shape with random sides length
     *
     * @param color Desired color of the shape
     * @return Trapezoid object
     */
    private static Trapezoid createTrapezoid(Colors color){
        double generatedSmallBase;
        double generatedLeftSide;
        double generatedRightSide;
        double generatedBigBase;

        while (true){
            generatedSmallBase = ThreadLocalRandom.current().nextDouble(
                    Constants.CONSTANT_MIN_TRAPEZOID_SIDE,
                    Constants.CONSTANT_MAX_TRAPEZOID_SIDE);
             generatedLeftSide = ThreadLocalRandom.current().nextDouble(
                    Constants.CONSTANT_MIN_TRAPEZOID_SIDE,
                    generatedSmallBase);
            generatedRightSide = ThreadLocalRandom.current().nextDouble(
                    Constants.CONSTANT_MIN_TRAPEZOID_SIDE,
                    generatedSmallBase);
            generatedBigBase = ThreadLocalRandom.current().nextDouble(generatedSmallBase,
                    Constants.CONSTANT_MAX_TRAPEZOID_SIDE);

            double height = Math.sqrt(((generatedBigBase + generatedLeftSide - generatedSmallBase + generatedRightSide)*
                    (-generatedBigBase + generatedLeftSide + generatedSmallBase + generatedRightSide)*
                    (generatedBigBase - generatedLeftSide - generatedSmallBase + generatedRightSide)*
                    (generatedBigBase + generatedLeftSide - generatedSmallBase - generatedRightSide)) /
                    (4 * Math.pow((generatedBigBase - generatedSmallBase),2)));
            if(height > 0){
                break;
            }
        }



        return new Trapezoid(generatedBigBase,
                generatedSmallBase,
                generatedLeftSide,
                generatedRightSide,
                color);
    }

    /** Handles creation of a Triangle shape with random sides length
     *
     * @param color Desired color of the shape
     * @return Triangle object
     */
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
