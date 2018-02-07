package shapes;

import utils.CirclePropertiesCalculations;

public class Circle extends GeometryObject implements CirclePropertiesCalculations{

    private double mRadius;
    private double mDiameter;

    private String mName;

    private double mLengthOfCircumference;

    Circle(double radius, String color, String name) {
        this.mColor = color;
        this.mRadius = radius;
        this.mDiameter = 2 * mRadius;
        this.mName = name;

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

    public String getmName() {
        return mName;
    }

    protected void setmName(String mName) {
        this.mName = mName;
    }
}
