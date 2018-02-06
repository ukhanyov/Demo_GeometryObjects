package shapes;

import utils.CirclePropertiesCalculations;

public class Circle extends GeometryObject implements CirclePropertiesCalculations{

    private double mRadius;
    private double mDiameter;

    private double mLengthOfCircumference;

    Circle(double radius, String color) {
        this.mColor = color;
        this.mRadius = radius;
        this.mDiameter = 2 * mRadius;

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
        return "Circle with following parameters:" + "\n" +
                "Color: " + getmColor() + "\n" +
                "Radius: " + getmRadius() +  "\n" +
                "Diameter: " + getmDiameter()+  "\n" +
                "Calculated Area = " + getmArea() + "\n" +
                "Calculated Length Of Circumference = " + getmLengthOfCircumference();
    }

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
}
