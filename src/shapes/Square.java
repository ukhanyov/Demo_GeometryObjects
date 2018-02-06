package shapes;

import utils.SquarePropertiesCalculations;

public class Square extends GeometryObject implements SquarePropertiesCalculations {

    private double mSide;
    private double mDiagonal;
    private double mPerimeter;

    public Square(double side, String color) {
        this.mSide = side;
        this.mColor = color;
    }

    @Override
    public void calculatePerimeter() {
        mPerimeter = 4 * mSide;
    }

    @Override
    public void calculateArea() {
        mArea = Math.pow(mSide, 2);
    }

    @Override
    public void calculateDiagonal() {
        mDiagonal = mSide * Math.sqrt(2);
    }

    @Override
    public String toString() {
        return "Square with following parameters:" + "\n" +
                "Color: " + getmColor() + "\n" +
                "Side: " + getmSide() + "\n" +
                "Calculated Diagonal = " + getmDiagonal() + "\n" +
                "Calculated perimeter = " + getmPerimeter() + "\n" +
                "Calculated area = " + getmArea();
    }

    public void makeCalculations(){
        calculateDiagonal();
        calculatePerimeter();
        calculateArea();
    }

    public void areTheNumbersRigth(){

    }

    public double getmSide() {
        return mSide;
    }

    protected void setmSide(double mSide) {
        this.mSide = mSide;
    }

    public double getmDiagonal() {
        return mDiagonal;
    }

    protected void setmDiagonal(double mDiagonal) {
        this.mDiagonal = mDiagonal;
    }

    public double getmPerimeter() {
        return mPerimeter;
    }

    protected void setmPerimeter(double mPerimeter) {
        this.mPerimeter = mPerimeter;
    }
}
