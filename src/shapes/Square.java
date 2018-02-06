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

    public double getmSide() {
        return mSide;
    }

    public void setmSide(double mSide) {
        this.mSide = mSide;
    }

    public double getmDiagonal() {
        return mDiagonal;
    }

    public void setmDiagonal(double mDiagonal) {
        this.mDiagonal = mDiagonal;
    }

    public double getmPerimeter() {
        return mPerimeter;
    }

    public void setmPerimeter(double mPerimeter) {
        this.mPerimeter = mPerimeter;
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

    public void makeCalculations(){
        calculateDiagonal();
        calculatePerimeter();
        calculateArea();
    }
}
