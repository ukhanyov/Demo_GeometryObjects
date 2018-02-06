package shapes;

import utils.SquarePropertiesCalculations;

public class Square extends GeometryObject implements SquarePropertiesCalculations {

    private double mSide;
    private double mDiagonal;
    private double mPerimeter;

    Square(double side, String color) {
        this.mSide = side;
        this.mColor = color;

        areTheNumbersRight();
        makeCalculations();
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
                "Calculated Perimeter = " + getmPerimeter() + "\n" +
                "Calculated Area = " + getmArea();
    }

    public void makeCalculations(){
        calculateDiagonal();
        calculatePerimeter();
        calculateArea();
    }

    private void areTheNumbersRight(){
        if(mSide <= 0){
            throw new IllegalArgumentException();
        }
    }

    protected double getmSide() {
        return mSide;
    }

    protected void setmSide(double mSide) {
        this.mSide = mSide;
    }

    protected double getmDiagonal() {
        return mDiagonal;
    }

    protected void setmDiagonal(double mDiagonal) {
        this.mDiagonal = mDiagonal;
    }

    protected double getmPerimeter() {
        return mPerimeter;
    }

    protected void setmPerimeter(double mPerimeter) {
        this.mPerimeter = mPerimeter;
    }
}
