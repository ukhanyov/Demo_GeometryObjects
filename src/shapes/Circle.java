package shapes;

import utils.CirclePropertiesCalculations;

public class Circle extends GeometryObject implements CirclePropertiesCalculations{

    private double mRadius;
    private double mDiameter;

    private double mLengthOfCircumference;

    public Circle(double radius, String color) {
        this.mColor = color;
        this.mRadius = radius;
        this.mDiameter = 2 * mRadius;
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

    public void areTheNumbersRigth(){

    }

    public double getmRadius() {
        return mRadius;
    }

    protected void setmRadius(double mRadius) {
        this.mRadius = mRadius;
    }

    public double getmDiameter() {
        return mDiameter;
    }

    protected void setmDiameter(double mDiameter) {
        this.mDiameter = mDiameter;
    }

    public double getmLengthOfCircumference() {
        return mLengthOfCircumference;
    }

    protected void setmLengthOfCircumference(double mLengthOfCircumference) {
        this.mLengthOfCircumference = mLengthOfCircumference;
    }
}
