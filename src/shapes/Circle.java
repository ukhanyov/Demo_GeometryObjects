package shapes;

import utils.CirclePropertiesCalculations;
import utils.Colors;
import utils.ShapeNames;

import java.util.ArrayList;
import java.util.List;

public class Circle extends GeometryObject implements CirclePropertiesCalculations{

    private double mRadius;
    private double mDiameter;

    // A list of available side(s) of the created shape object
    private List<Double> sidesOfTheShape = new ArrayList<>();

    private ShapeNames mName;

    private double mLengthOfCircumference;

    /** Create Circle, derived from GeometryObject
     *
     * @param radius A radius of a circle
     * @param color A color of a circle
     */
    Circle(double radius, Colors color) {
        this.mColor = color;
        this.mRadius = radius;
        this.mDiameter = 2 * mRadius;
        this.mName = ShapeNames.CIRCLE;

        this.sidesOfTheShape.add(mRadius);

        areTheNumbersRight();
        makeCalculations();
    }

    @Override
    public void calculateArea() {
        this.mArea = Math.PI * Math.pow(mRadius, 2);
    }

    @Override
    public void calculateLengthOfCircumference() {
        this.mLengthOfCircumference = Math.PI * mDiameter;
    }

    @Override
    public void makeCalculations() {
        calculateLengthOfCircumference();
        calculateArea();
    }

    @Override
    public String toString() {

        return String.format("Circle with following parameters:" + "\n" +
                "Color: " + getmColor() + "\n" +
                "Radius: " + "%.3f" +  "\n" +
                "Diameter: " + "%.3f" + "\n" +
                "Calculated Area = " + "%.3f" + "\n" +
                "Calculated Length Of Circumference = " + "%.3f",
                (float)getmRadius(), (float)getmDiameter(), (float)getmArea(), (float)getmLengthOfCircumference());
    }

    /** Checks, if the numbers are ok, allowing to proceed with creation of desirable object
     *
     */
    private void areTheNumbersRight(){
        if(mRadius <= 0){
            throw new IllegalArgumentException();
        }
    }

    protected double getmRadius() {
        return mRadius;
    }

    protected void setmRadius(double mRadius) {
        this.mRadius = mRadius;
    }

    protected double getmDiameter() {
        return mDiameter;
    }

    protected void setmDiameter(double mDiameter) {
        this.mDiameter = mDiameter;
    }

    protected double getmLengthOfCircumference() {
        return mLengthOfCircumference;
    }

    protected void setmLengthOfCircumference(double mLengthOfCircumference) {
        this.mLengthOfCircumference = mLengthOfCircumference;
    }

    public ShapeNames getmName() {
        return mName;
    }

    protected void setmName(ShapeNames mName) {
        this.mName = mName;
    }

    @Override
    public List<Double> getSidesOfTheShape() {
        return sidesOfTheShape;
    }

    @Override
    protected void setSidesOfTheShape(List<Double> sidesOfTheShape) {
        this.sidesOfTheShape = sidesOfTheShape;
    }
}
